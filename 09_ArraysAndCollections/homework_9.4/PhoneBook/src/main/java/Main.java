import java.util.Scanner;

public class Main {

    private static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {

        String wrongFormat = "Неверный формат ввода";

        while (true) {
            System.out.println("\nВведите номер, имя или команду:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (phoneBook.checkName(input)) {
                if (phoneBook.getContactByName(input).isEmpty()) {
                    System.out.println("Такого имени в телефонной книге нет." +
                            "\nВведите номер телефона для абонента " + input + ":");
                    String input1 = scanner.nextLine();
                    if (phoneBook.checkPhone(input1)) {
                        phoneBook.addContact(input1, input);
                        System.out.println("Контакт сохранен!");
                    } else {
                        System.out.println(wrongFormat);
                    }
                } else {
                    System.out.println(phoneBook.getContactByName(input));
                }
            }

            else if (phoneBook.checkPhone(input)) {
                if (phoneBook.getContactByPhone(input).isEmpty()) {
                    System.out.println("Такого номера нет в телефонной книге." +
                            "\nВведите имя для номера " + input + ":");
                    String input1 = scanner.nextLine();
                    if (phoneBook.checkName(input1)) {
                        phoneBook.addContact(input1, input);
                        System.out.println("Контакт сохранен!");
                    } else {
                        System.out.println(wrongFormat);
                    }
                } else {
                    System.out.println(phoneBook.getContactByPhone(input));
                }
            }

            else if (input.equals("LIST")) {
                System.out.println(phoneBook.getAllContacts());
            } else {
                System.out.println(wrongFormat);
            }
        }
    }
}


