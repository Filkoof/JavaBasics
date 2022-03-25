import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movements {

    private static List<String> operationDescription = new ArrayList<>();
    private static double incomeSum;
    private static double expenseSum;

    public Movements(String pathMovementsCsv) {
        readMovementsFromFile(pathMovementsCsv);
    }

    public static void readMovementsFromFile(String path){
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));


            lines.remove(0);
            for (String line : lines){
                String[] fragments = oneForm(line).split(",");
                double income = Double.parseDouble(fragments[6]);
                double expense = Double.parseDouble(fragments[7]);

                if (fragments.length != 8) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }

                if (income != 0){
                    incomeSum += income;
                } else {
                    expenseSum += expense;
                }

                if(expense != 0){
                    operationDescription.add(fragments[5].concat(fragments[7]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String oneForm(String line){
        String regex = "\".+\"";
        String temp = line;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(temp);

        if (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            line.substring(start, end + 1)
                    .replaceAll("\"", "")
                    .replace(",", ".");

            return temp;
        } else {
            return line;
        }
    }

    public double getExpenseSum() {
        return expenseSum;
    }

    public double getIncomeSum() {
        return incomeSum;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
