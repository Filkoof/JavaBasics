import java.time.*;

public class Main {

  public static void main(String[] args) {

    LocalDate birthday = LocalDate.of(1996,01,21);

    System.out.println(getPeriodFromBirthday(birthday));

  }

  private static String getPeriodFromBirthday(LocalDate birthday) {
    LocalDate now = LocalDate.now();
    String text = " ";

    Period date = Period.between(birthday, now);

    text = text + date.getYears() + " years, " + date.getMonths() + " months, " + date.getDays() + " days";

    return text;
  }

}
