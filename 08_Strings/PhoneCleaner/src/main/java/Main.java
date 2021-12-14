import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

//    Scanner scanner = new Scanner(System.in);
//    while (true) {
//      String input = scanner.nextLine();
//      if (input.equals("0")) {
//        break;
//      }
//    }

    String phone1 = "+7 909 123-45-67"; //79091234567 +
    String phone2 = "+7 (909) 1234567"; //79091234567 +
    String phone3 = "8-905-1234567"; //79051234567 8 заменить на 7
    String phone4 = "9-453-1234567"; //Неверный формат номера 9 вместо 7 или 8 +
    String phone5 = "8-905-123"; //Неверный формат номера недостаточно цифр +
    String phone6 = "905-1234567"; //79051234567 добавить 7 +
    String phone7 = "8-905-12345672342"; //Неверный формат номера лишние цифры +
    String error = "";

    for (int i = 0; i < formatPhoneNumber(phone3).length(); i ++) {
      char symbol = formatPhoneNumber(phone3).charAt(i);
      if (formatPhoneNumber(phone3).length() < 10 || formatPhoneNumber(phone3).length() > 11){
        error = "Неверный формат номера";
        System.out.println("Ошибка");
        break;
      }
      if (formatPhoneNumber(phone3).length() == 10){
        phone7 = "7" + formatPhoneNumber(phone4);
        System.out.println("Добавлена 7");
      }
      if (formatPhoneNumber(phone3).charAt(0) == '9'){
        error = "Неверный формат номера";
        System.out.println("Ошибка");
        break;
      }
      if (formatPhoneNumber(phone3).charAt(0) == '8') {
        formatPhoneNumber(phone3).charAt(0) = '7';
      }
    }

//    System.out.println(formatPhoneNumber(phone1));
//    System.out.println(formatPhoneNumber(phone2));
//    System.out.println(formatPhoneNumber(phone3));
    System.out.println(formatPhoneNumber(phone4));
//    System.out.println(formatPhoneNumber(phone5));
//    System.out.println(formatPhoneNumber(phone6));
//    System.out.println(formatPhoneNumber(phone7));
  }

    public static String formatPhoneNumber(String phone){
      String regex = "[^0-9]";
      return phone.replaceAll(regex, "");
  }

}

