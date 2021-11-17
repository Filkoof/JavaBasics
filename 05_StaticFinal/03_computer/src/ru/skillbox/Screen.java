public class Screen {
    private final double diagonal;
    private final ScreenType type;
    private final double weightScreen;

    public Screen(double diagonal, ScreenType type, double weightScreen) {
        this.diagonal = diagonal;
        this.type = type;
        this.weightScreen = weightScreen;
    }

    public double getDiagonal(){
        return diagonal;
    }

    public double getWeightScreen(){
        return weightScreen;
    }
}
