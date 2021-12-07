public class Main {

  public static void main(String[] args) {
    String text = "";
  }

  public static String splitTextIntoWords(String text) {
    String[] words = text.split("[^a-zA-Z’]+");
    String split = "";
    for(int i = 0; i < words.length; i++){
      if (i != words.length - 1) split += words[i] +  System.lineSeparator();
      else{
        split += words[i];
      }
    }

    return split;
  }

}