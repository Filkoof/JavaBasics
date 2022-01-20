import java.util.Scanner;

public class Main {

    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList

        System.out.println("Список команд:" +
                "\n\t ADD - добавить дело" +
                "\n\t EDIT - заменить дело" +
                "\n\t DELETE - удаление дела" +
                "\n\t LIST - список дел по порядку");

        String todo;

        while (true) {
            System.out.println("Введите команду:");
            String input = new Scanner(System.in).nextLine();

            switch (input) {
                case "ADD":
                    todo = input.toString();
                    break;
                case "EDIT":
                    todo = input.toString();
                    break;
                case "DELETE":
                    todo = input.toString();
                    break;
                case "LIST":
                    todo = input.toString();
                    break;
            }
        }

    }
}
