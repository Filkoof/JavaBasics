public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(1,2,3);

        Delivery delivery = new Delivery(new Dimensions(1,2,3),
                2,
                "Невский 22",
                true,
                "12123вв",
                false
                );
        dimensions.getVolume();

        System.out.println(delivery);

        Dimensions copy = new Dimensions(dimensions.getWidth(), dimensions.getHeight(), dimensions.getLength());

    }
}
