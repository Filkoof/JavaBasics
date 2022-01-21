import java.util.Scanner;

public class Main {

    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {

        System.out.println("Список команд:" +
                "\n\t ADD - добавить дело" +
                "\n\t EDIT - заменить дело" +
                "\n\t DELETE - удаление дела" +
                "\n\t LIST - список дел по порядку");

        while (true) {
            System.out.println("\nВведите команду:");
            String input = new Scanner(System.in).nextLine();

            switch (input) {
                case "ADD" -> todoList.add(input);
                case "EDIT" -> todoList.edit(input,1);
                case "DELETE" -> todoList.delete(1);
                case "LIST" -> todoList.getTodos();
                default -> System.out.println("Введена неверная команда");
            }
        }
    }
}
