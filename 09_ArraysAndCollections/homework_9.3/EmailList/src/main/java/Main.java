import java.util.Scanner;

public class Main {

    private static EmailList emailList = new EmailList();

    public static void main(String[] args) {

        System.out.println("Список команд:" +
                "\n\t ADD - добавить email" +
                "\n\t LIST - список email");
        
        while (true) {
            System.out.println("Введите команду:");
            String input = new Scanner(System.in).nextLine();

            switch (findCommand(input)){
                case "ADD" -> emailList.add(input);
                case "LIST" -> emailList.getSortedEmails();
                default -> System.out.println("Неверная команда");
            }
        }
    }

    public static String findCommand (String input) {
        int end = input.indexOf(' ', 0);

        if(end == -1){
            return input;
        }

        return input.substring(0, end);
    }

}
