public class Main {
    public static void main(String [] args) {
        Product product = new Product( );
        product.setPrice(500);
        product.setBarCode(298932);
        product.setName("книга");
        System.out.println(product);

        Product copy = new Product(
                product.getName(),
                product.getPrice(),
                product.getBarCode());

    }
}
