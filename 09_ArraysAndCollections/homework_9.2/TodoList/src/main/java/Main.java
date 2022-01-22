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


            switch (findCommand(input)) {
                case "ADD" -> {
                    if (findIndex(input) != -1) {
                        todoList.add(findIndex(input), input);
                    } else {
                        todoList.add(input);
                    }
                }
                case "EDIT" -> todoList.edit(input,findIndex(input));
                case "DELETE" -> todoList.delete(findIndex(input));
                case "LIST" -> todoList.getTodos();
                default -> System.out.println("Введена неверная команда");
            }
        }
    }

    public static String findCommand(String input) {
        int end = input.indexOf(' ', 0);

        if(end == -1){
            return input;
        }
        return input.substring(0, end);
    }

    public static int findIndex(String input) {
        String regex = "[^0-9]";
        String replace = input.replaceAll(regex, "");

        if(replace != "") {
            int index = Integer.parseInt(replace);
            return index;
        }

        return -1;
    }
}
