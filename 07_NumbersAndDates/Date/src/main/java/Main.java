import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 7;
        int month = 4;
        int year = 1996;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - E")
                .localizedBy(new Locale("us"));

        for (int i = 0;i >= 0 ; i++){
            if (birthday.isBefore(today) || birthday.equals(today)){
                System.out.println(i + " - " + formatter.format(birthday));
                birthday = birthday.plusYears(1);
            }
            else {
                break;
            }
        }

        return " ";
    }
}
