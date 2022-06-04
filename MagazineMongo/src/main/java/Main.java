import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final MongoClient mongoClient = new MongoClient( "127.0.0.1" , 27017);
    private static final MongoDatabase database = mongoClient.getDatabase("local");
    public static MongoCollection<Document> shops = database.getCollection("Shops");
    public static MongoCollection<Document> products = database.getCollection("Products");

    public static String commands = "Список команд:" +
            "\n\t ДОБАВИТЬ_МАГАЗИН <имя магазина>  - Команда добавления магазина." +
            "\n\t ДОБАВИТЬ_ТОВАР <имя товара><число товара> - Команда добавления товара." +
            "\n\t ВЫСТАВИТЬ_ТОВАР <имя товара> <имя магазина> - Команда добавления товара в магазин." +
            "\n\t СТАТИСТИКА_ТОВАРОВ - Команда получения информации о товарах во всех магазинах." +
            "\n\t ОЧИСТИТЬ_БАЗУ - Команда удаления данных в базе";

    public static void main(String[] args) {
        System.out.println(commands + "\nВведите команду:");

        while (true) {
            String input = new Scanner(System.in).nextLine();

            String[] fragments = input.split(" ");

            switch (findCommand(input)) {
                case "ДОБАВИТЬ_МАГАЗИН" -> insertShop(fragments[1]);
                case "ДОБАВИТЬ_ТОВАР" -> insertProduct(fragments[1], Integer.parseInt(fragments[2]));
                case "ВЫСТАВИТЬ_ТОВАР" -> postProducts(fragments[1], fragments[2]);
                case "СТАТИСТИКА_ТОВАРОВ" -> showStatistic();
                case "ОЧИСТИТЬ_БАЗУ" -> dropDataBase();
                default -> error();
            }
        }
    }

    public static void insertShop(String shop) {
        System.out.println("Добавляем торговую точку");
        shops.insertOne(new Document()
                .append("ShopName", shop)
                .append("ProductsList", new ArrayList<String>()));
    }

    public static void insertProduct(String product, int price) {
        System.out.println("Закупаем продукты на склад");
        products.insertOne(new Document().append("ProductName", product).append("Price", price));
    }

    public static void postProducts(String product, String shop) {
        System.out.println("Выставляем продукты");
        shops.updateOne(getShop(shop),
                new Document("$addToSet", new Document("ProductsList", getProduct(product).get("ProductName"))));
    }

    public static void showStatistic() {
        AggregateIterable<Document> documents = products.aggregate(Arrays.asList(
                Aggregates.lookup("Shops", "ProductName", "ProductsList", "shops_list"),
                Aggregates.unwind("$shops_list"),
                Aggregates.group("$shops_list.ShopName",
                        Accumulators.sum("count_products", 1),
                        Accumulators.min("min_price", "$Price"),
                        Accumulators.max("max_price", "$Price"),
                        Accumulators.avg("avg_price", "$Price"))));

        for (Document document : documents) {
            String shopName = String.valueOf(document.get("_id"));
            System.out.println("Магазин: " + shopName +
                    "\n\tКоличество товара: " + document.get("count_products") +
                    "\n\tСредняя цена товара: " + document.get("avg_price") +
                    "\n\tСамый дорогой товар:  " + document.get("max_price") +
                    "\n\tСамый дешевый товар:  " + document.get("min_price") +
                    "\n\tКоличество товаров, дешевле 100 рублей: " + cheapestProductCount(shopName));
        }
    }

    private static long cheapestProductCount(String shopName) {
        Document shop = getShop(shopName);
        ArrayList<String> products = (ArrayList<String>) shop.get("ProductsList");
        return products.stream().filter(s -> (int) getProduct(s).get("Price") < 100).count();
    }

    public static void dropDataBase() {
        System.out.println("Крушим склады");
        shops.drop();
        products.drop();
    }

    private static Document getShop(String name) {
        return shops.find(new Document("ShopName", name)).first();
    }

    private static Document getProduct(String name) {
        return products.find(new Document("ProductName", name)).first();
    }

    public static void error() {
        System.out.println("Введена неверная команда");
        System.out.println(commands);
    }

    public static String findCommand(String input) {
        int end = input.indexOf(' ');
        if(end == -1) return input;
        return input.substring(0, end);
    }
}
