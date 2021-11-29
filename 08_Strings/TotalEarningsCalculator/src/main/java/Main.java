public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

    String numbers = "";
    String sum = "";

    for (int i = 0; i < text.length(); i++) {
      char symbol = text.charAt(i);
      if(Character.isDigit(symbol)){
        numbers = numbers + symbol;
      }
      else if(symbol == ' '){
        sum = sum + numbers;
        numbers = " ";
      }
    }

    System.out.println(sum);

   }

}