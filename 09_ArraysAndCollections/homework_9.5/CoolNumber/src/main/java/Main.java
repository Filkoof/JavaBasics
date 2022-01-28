import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        List<String> numbers = CoolNumbers.generateCoolNumbers();

        while (true){
            System.out.println("Введите номер: ");
            String input = new Scanner(System.in).nextLine();

            if (findNumber(input)){
                CoolNumbers.bruteForceSearchInList(numbers, input);
                CoolNumbers.binarySearchInList(numbers, input);
                CoolNumbers.searchInHashSet(new HashSet<>(numbers), input);
                CoolNumbers.searchInTreeSet(new TreeSet<>(numbers), input);
            } else {
                System.out.println("Неверный формат крутого гос.номера");
            }
        }
    }

    public static boolean findNumber(String input){
        String regex = "[AВЕКМНОРСТУХ][0-9]{3}[AВЕКМНОРСТУХ]{2}[0-9]{2,3}";

        return input.matches(regex);
    }
}
