import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

  }

  public static String splitTextIntoWords(String text) {
    String[] words = text.split("^[a-z]");
    for(int i = 0; i < words.length; i++){
      System.out.println(words[i]);
    }

    return words;
  }

}