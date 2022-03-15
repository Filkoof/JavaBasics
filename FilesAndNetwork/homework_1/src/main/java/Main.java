import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            for (; ; ) {
                System.out.println("Укажите путь: ");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                System.out.println(FileUtils.getReadableSize(FileUtils.calculateFolderSize(input)));
            }
        } catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }
     }
}
