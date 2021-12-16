import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    String fio = "Салтыков-Щедрин Михаил Евграфович";
    String surname, name, lastName;
    String regex = "[А-Яа-я\\-]+";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(fio);

    int firstIndex = input.indexOf(" ");
    int lastIndexOf = input.lastIndexOf(" ");

    if (matcher.find()) {
      surname = input.substring(0,firstIndex);
      name = input.substring(firstIndex, lastIndexOf);
      lastName = input.substring(lastIndexOf);
      System.out.println("Фамилия: " + surname);
      System.out.println("Имя: " + name);
      System.out.println("Отчество: " + lastName);
    } else {
      System.out.println("Введенная строка не является ФИО.");
    }

  }

}
