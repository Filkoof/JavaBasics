import java.util.Scanner;

public class Main {

    private static int CAPACITY_TRUCK = 12;
    private static int CAPACITY_CONTAINER = 27;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        int truck = 0;
        int container = 0;
        int box = Integer.parseInt(boxes);

        for (int i = 0; i < box; i++) {

            if((i % (CAPACITY_TRUCK * CAPACITY_CONTAINER) == 0) && box != 0){
                truck++;
                System.out.println("Грузовик: " + truck);

            }

            if((i % CAPACITY_CONTAINER == 0) && box != 0) {
                container++;
                System.out.println("\tКонтейнер: " + container);
            }
            System.out.println("\t\tЯщик: " + (i + 1));

        }

        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + truck + " шт.");
        System.out.println("контейнеров - " + container + " шт.");

    }

}
