public class ArithmeticCalculator {

    public int x = 0;
    public int y = 0;

    public ArithmeticCalculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int calculate(Operation type) {
        if(type == Operation.ADD) {
            return x + y;
        } else if (type == Operation.MULTIPLY) {
            return x * y;
        } else if (type == Operation.SUBTRACT) {
            return x - y;
        }
        return 0;
    }

}
