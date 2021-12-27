import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    String surname, name, lastName;
    String regex = "[А-Яа-я\\-]+";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);

    int firstIndex = input.indexOf(" ");
    int lastIndex = input.lastIndexOf(" ");

    if (matcher.results().count() == 3) {
      surname = input.substring(0, firstIndex);
      name = input.substring(firstIndex + 1, lastIndex);
      lastName = input.substring(lastIndex + 1);

      System.out.println("Фамилия: " + surname);
      System.out.println("Имя: " + name);
      System.out.println("Отчество: " + lastName);
    } else {
      System.out.println("Введенная строка не является ФИО");
    }

  }

}

