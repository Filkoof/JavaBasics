import java.util.Scanner;

public class main{
    Elevator elevator = new Elevator(-3, 26);

    while (true) {

        System.out.print("Введите номер этажа: ");

        int floor = new Scanner(System.in).nextInt();

        elevator.move(floor);

    }
}
