package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions();
        dimensions.setWidth();
        dimensions.setHeight();
        dimensions.setLengt();

        Delivery delivery = new Delivery();
        delivery.setAddress();
        delivery.setWeight();

        Dimensions copy = new Dimensions(dimensions.getWidth(), dimensions.getHeight(), dimensions.getLength());

    }
}
