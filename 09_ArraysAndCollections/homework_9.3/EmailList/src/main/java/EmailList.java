import java.util.TreeSet;

public class EmailList {

    public TreeSet<String> emailList = new TreeSet<>();

    public void add(String email) {
        if (checkEmailStyle(email)){
            emailList.add(email);
        } else {
            System.out.println("Неверный формат email");
        }
    }

    public TreeSet<String> getSortedEmails() {
        for (String emails: emailList){
            System.out.println(emails);
        }
        return emailList;
    }

    public static boolean checkEmailStyle (String input) {
        String regex = "[^\\s]+@[A-Za-z]+\\.[A-Za-z]{2,3}";

        return input.matches(regex);
    }

}
