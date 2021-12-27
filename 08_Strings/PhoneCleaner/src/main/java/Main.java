import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    String regex = "([7-8]?)[0-9]{9,10}";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(formatPhoneNumber(input));

    if(matcher.matches()){
      if(formatPhoneNumber(input).startsWith("8")){
        System.out.println(formatPhoneNumber(input).replaceFirst("8","7"));
      }
      else if(formatPhoneNumber(input).length() == 10){
        System.out.println(formatPhoneNumber("7" + input));
      } else {
        System.out.println(formatPhoneNumber(input));
      }
    } else {
      System.out.println("Неверный формат номера");
    }

  }

  public static String formatPhoneNumber(String phone){
    String regex = "[^0-9]";
    return phone.replaceAll(regex, "");
  }

}

