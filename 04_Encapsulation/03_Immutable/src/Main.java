public class Main {
    public static void main(String [] args) {
        Product product = new Product("книга" , 500, 423432);
        System.out.println(product);

        Product copy = new Product(
                product.getName(),
                product.getPrice(),
                product.getBarCode());

    }
}
