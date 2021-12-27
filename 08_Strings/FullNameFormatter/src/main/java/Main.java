import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String surname = "";
    String name = "";
    String lastName = "";
    int count = 0;
    String error = "";

    while (true) {
      String input = scanner.nextLine();
      for (int i = 0; i < input.length(); i++) {
        char symbol = input.charAt(i);
        if (symbol == ' ') {
          count++;
          continue;
        }
        if (Character.UnicodeBlock.of(symbol).equals(Character.UnicodeBlock.CYRILLIC) || symbol == '-') {
          if (count == 0) surname += symbol;
          if (count == 1) name += symbol;
          if (count == 2) lastName += symbol;
        } else {
          error = "Введенная строка не является ФИО";
          break;
        }
      }
      if (error != "" || count < 2) {
        System.out.println("Введенная строка не является ФИО");
        break;
      } else {
        System.out.println("Фамилия: " + surname);
        System.out.println("Имя: " + name);
        System.out.println("Отчество: " + lastName);
        break;
      }
    }
  }
}