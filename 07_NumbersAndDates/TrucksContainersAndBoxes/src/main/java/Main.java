package main.java;

import java.util.Scanner;

public class Main {

    private static int CAPACITY_TRUCK = 12; //Количество контейнеров вмещающееся в грузовик
    private static int CAPACITY_CONTAINER = 27; //Количество ящиков вмещающееся в контейнер

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        int truck = 0;
        int container = 0;
        int box = Integer.parseInt(boxes);

        if (box > 0){
            ++truck;
            ++container;
            System.out.println("Грузовик: " + truck);
            System.out.println("\tКонтейнер: " + container);
        }

        for (int i = 0; i <= box; i++) {
            System.out.println("\t\tЯщик: " + (i + 1));
            if (i % (CAPACITY_TRUCK * CAPACITY_CONTAINER) == 0) {
                ++truck;
                System.out.println("Грузовик " + truck);
            }
            if (i % CAPACITY_CONTAINER == 0) {
                ++container;
                System.out.println("\tКонтейнер: " + container);
            }
        }
        System.out.println("Необходимо:\tгрузовиков - " + truck + "шт.");
        System.out.println("Контейнеров - " + container + "шт.");

    }

}
