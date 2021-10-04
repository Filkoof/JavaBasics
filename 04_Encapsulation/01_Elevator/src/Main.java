import java.util.Scanner;

public class Main {
    Elevator elevator = new Elevator(-3, 26);

    public void main(String[] args) {
        while (true) {
            System.out.println("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }

    }
}
