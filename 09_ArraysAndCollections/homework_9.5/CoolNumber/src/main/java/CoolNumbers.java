import java.util.*;

public class CoolNumbers {
    private static long start = System.currentTimeMillis();

    public static List<String> generateCoolNumbers() {
        ArrayList <String> numbers = new ArrayList<>();
        String[] letters = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

        for (String x : letters){
            for (String y : letters) {
                for (String z : letters) {
                    for (int n = 0; n <= 9; n++) {
                        for (int r = 0; r <= 199; r++) {
                            numbers.add(x + n + n + n + y + z + r);
                        }
                    }
                }
            }
        }

        return numbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {

        for (int i = 0; i < list.size(); i++){
            if (number.equals(list.get(i))){

                System.out.println("Поиск перебором: номер найден, поиск занял "
                        + (System.currentTimeMillis() - start));
                return true;
            }
        }
        System.out.println("Поиск перебором: номер не найден, поиск занял "
                + (System.currentTimeMillis() - start));
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {

        if (sortedList.contains(number)) {
            System.out.println("Бинарный поиск: номер найден, поиск занял "
                    + (System.currentTimeMillis() - start));
            return true;
        }
        System.out.println("Бинарный поиск: номер не найден, поиск занял "
                + (System.currentTimeMillis() - start));
        return false;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        if (hashSet.contains(number)){
            System.out.println("Поиск в HashSet: номер найден, поиск занял "
                    + (System.currentTimeMillis() - start));
            return true;
        }
        System.out.println("Поиск в HashSet: номер не найден, поиск занял "
                + (System.currentTimeMillis() - start));
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        if (treeSet.contains(number)){
            System.out.println("Поиск в TreeSet: номер найден, поиск занял "
                    + (System.currentTimeMillis() - start));
            return true;
        }
        System.out.println("Поиск в HashSet: номер не найден, поиск занял "
                + (System.currentTimeMillis() - start));
        return false;
    }

}
