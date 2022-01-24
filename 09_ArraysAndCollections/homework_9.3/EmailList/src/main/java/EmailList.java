import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.TreeSet;

public class EmailList {

    public TreeSet<String> emailSet = new TreeSet<>();
    public ArrayList<String> emailList = new ArrayList<>();

    public void add(String email) {
        email = email.toLowerCase(Locale.ROOT);
        if (checkEmailStyle(email)){
            emailSet.add(email);
        } else {
            System.out.println("Неверный формат email");
        }
    }

    public ArrayList<String> getSortedEmails() {
        for (String emails: emailSet){
            String[] temp = emails.split(",");
            emailList.addAll(Arrays.asList(temp));
        }
        return emailList;
    }

    public static boolean checkEmailStyle (String input) {
        String regex = "[^\\s]+@[A-Za-z]+\\.[A-Za-z]{2,3}";

        return input.matches(regex);
    }

}
