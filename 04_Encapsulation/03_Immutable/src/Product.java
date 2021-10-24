public class Product {
    private final String name;
    private int price;
    private final int barCode;

    public Product(String name, int price, int barCode) {
        this.name = name;
        this.price = price;
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        return new Product(name, price , barCode);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBarCode() {
        return barCode;
    }

    public Product setBarCode(int barCode) {
        return new Product(name, price, barCode);
    }
}
