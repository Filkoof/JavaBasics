public class Keyboard {
    private final KeyboardType type;
    private final boolean backlight;
    private final double weightKeyboard;

    public Keyboard(KeyboardType type, boolean backlight, double weightKeyboard) {
        this.type = type;
        this.backlight = backlight;
        this.weightKeyboard = weightKeyboard;
    }

    public boolean isBacklight(){
        return backlight;
    }

    public double getWeightKeyboard(){
        return weightKeyboard;
    }
}
