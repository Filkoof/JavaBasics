import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movements {

    private static List<String> operationDescription = new ArrayList<>();
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
                    operationDescription.add(fragments[5].concat(fragments[7]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String oneForm(String line) {
        String[] fragments = line.split("\"");
        String temp;
        String split = "";

        String regex = "^[\\d]+,[\\d]+";

        for (int i = 0; i < fragments.length; i++) {
            temp = fragments[i];

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(temp);

            if (matcher.find()) {
                split += temp.replaceAll(",", ".");
            } else {
                split += temp;
            }
        }
        return split;
    }

    public double getExpenseSum() {
        return expenseSum;
    }

    public double getIncomeSum() {
        return incomeSum;
    }
}

