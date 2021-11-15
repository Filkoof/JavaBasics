public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator(2,3);
        System.out.println(calculator.calculate(Operation.ADD));
    }
}
