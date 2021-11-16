public class Keyboard {
    final private KeyboardType type;
    final private boolean backlight;
    final double weightKeyboard;

    public Keyboard(KeyboardType type, boolean backlight, double weightKeyboard) {
        this.type = type;
        this.backlight = backlight;
        this.weightKeyboard = weightKeyboard;
    }
}
