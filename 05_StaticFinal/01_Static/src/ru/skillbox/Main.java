public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket("Колбаса", 556);
        Basket basket1 = new Basket("Тарелка", 130);
        Basket basket2 = new Basket("Весло", 880);
        System.out.println(Basket.getCount());
    }
}
