import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    //Scanner scanner = new Scanner(System.in);
   // String input = scanner.nextLine();

    String fio = "Салтыков-Щедрин Михаил Евграфович";
    String space = "[\\s]";
    String regex = "[А-Яа-я\\-]+";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(fio);

    int count = 0;

    while (matcher.find()) {
      int start = matcher.start();
      int end = matcher.end();
      System.out.println(fio.substring(start, end));
      }
    }

}

