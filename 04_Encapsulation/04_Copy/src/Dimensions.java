public class Dimensions {
    private final int width;
    private final int height;
    private final int length;

    public Dimensions(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public Dimensions setWidth(int width) {
        return new Dimensions(width, height, length);
    }

    public int getHeight() {
        return height;
    }

    public Dimensions setHeight(int height) {
        return new Dimensions(width, height, length);
    }

    public int getLength() {
        return height;
    }

    public Dimensions setLength(int length) {
        return new Dimensions(width, height, length);
    }

    public int getVolume() {
        return width * height * length;
    }

}