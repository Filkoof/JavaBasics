public class Arithmetic {

    int x;
    int y;

    public Arithmetic(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void sum() {

        System.out.println("Сумма равна :" + x + y);
    }

    public void multiply() {

        System.out.println("Произведение равно:" + x * y);
    }

    public void max() {
        if (x > y) {
            System.out.println("Большее число:" + x);
        } else {
            System.out.println("Большее число:" + y);
        }
    }

    public void min() {
        if (x < y) {
            System.out.println("Меньшее число:" + x);
        } else {
            System.out.println("Меньшее число:" + y);
        }
    }


}
