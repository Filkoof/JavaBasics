public class Elevator {

    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFlor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp() {

        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;

    }

    public int move(int floor) {
        for(floor <= minFloor || floor >= maxFloor) {
            System.out.println("Этаж: " + currentFloor);
            if (currentFloor < floor) {
                moveDown();
            }
            if (currentFloor > floor) {
                moveUp();
            } else {
                System.out.println("Ошибка,отсутствует этаж ");
            }
        }

    }

}