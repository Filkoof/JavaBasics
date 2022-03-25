import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movements {

    private static final List<String> operationDescription = new ArrayList<>();
    private double incomeSum;
    private double expenseSum;

    public Movements(String pathMovementsCsv) {
        readMovementsFromFile(pathMovementsCsv);
    }

    public void readMovementsFromFile(String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));

            lines.remove(0);
            for (String line : lines) {
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

                if (expense != 0) {
                    operationDescription
                            .add(cleanOperationDescription(fragments[5])
                            .concat(": ")
                            .concat(fragments[7])
                            .concat("\n"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String oneForm(String line) {
        String[] fragments = line.split("\"");
        String temp;
        StringBuilder split = new StringBuilder();

        String regex = "^[\\d]+,[\\d]+";

        for (String fragment : fragments) {
            temp = fragment;

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(temp);

            if (matcher.find()) {
                split.append(temp.replaceAll(",", "."));
            } else {
                split.append(temp);
            }
        }
        return split.toString();
    }

    public static String cleanOperationDescription(String operation){
        return operation.replaceAll("[^a-zA-Z]+", " ");
    }

    public double getExpenseSum() {
        return expenseSum;
    }

    public double getIncomeSum() {
        return incomeSum;
    }

    public String toString() {
       return "Сумма расходов: " + expenseSum + "\n" +
               "Сумма доходов: " + incomeSum + "\n" +
               "Суммы расходов по организациям: \n" + operationDescription;
    }
}

