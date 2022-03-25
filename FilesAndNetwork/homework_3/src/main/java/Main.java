public class Main {

    public static final String MOVEMENT_LIST_CSV = "C:/Users/Professional/desktop/movementList.csv";

    public static void main(String[] args) {
        Movements movements = new Movements(MOVEMENT_LIST_CSV);

        System.out.println(movements);
    }
}
