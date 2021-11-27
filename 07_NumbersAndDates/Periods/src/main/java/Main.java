import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Main {

  public static void main(String[] args) {

    LocalDate birthday = LocalDate.of(1996,01,21);

    System.out.println();

  }

  private static String getPeriodFromBirthday(LocalDate birthday) {
    LocalDate now = LocalDate.now();
    long difference = now.toEpochDay() - birthday.toEpochDay();
    int year = (int) (difference / 365);
    int month = (int) (difference % 365) / 31;
    int day = (int) (difference % 365) % 31;

    return " ";
  }

}
