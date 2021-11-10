public class ArithmeticCalculator {

    public int x = 0;
    public int y = 0;
    public final Operation type;

    public ArithmeticCalculator(int x, int y, Operation type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public Operation type() {
        return type;
    }

    public void Calculate() {
        if(this.type == Operation.ADD) {
            System.out.println("Сумма чисел равна: " + x + y);
        } else if (this.type == Operation.MULTIPLY) {
            System.out.println("Произведение чисел равно: " + x * y);
        } else if (this.type == Operation.SUBTRACT) {
            System.out.println("Разность чисел равна: " + (x - y));
        }
    }

}
