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

        Scanner scanner = new Scanner(System.in);
        String todo;

        System.out.println("\nВведите команду:");

        while (true) {
            if (scanner.equals("ADD")){
                todo = scanner.toString();
            }
            else if(scanner.equals("EDIT")){
                todo = scanner.toString();
                TodoList.edit(todo , 1);
            }
            else if(scanner.equals("DELETE")){
                todo = scanner.toString();
                TodoList.delete(1);
            }
            else if(scanner.equals("LIST")){
                todo = scanner.toString();
                TodoList.getTodos();
            }
        }

    }
}
