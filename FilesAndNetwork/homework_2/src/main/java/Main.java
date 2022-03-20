import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            System.out.println("Укажите копируемую папку: ");
            String sourceDirectory = scanner.nextLine();

            System.out.println("Укажите папку назначения: ");
            String destinationDirectory = scanner.nextLine();

            FileUtils.copyFolder(sourceDirectory, destinationDirectory);
        }

    }

}

