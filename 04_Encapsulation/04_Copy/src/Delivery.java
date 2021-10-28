public class Delivery {
    private final Dimensions dimension;
    private final int weight;
    private final String address;
    private final boolean canFlip;
    private final String registrationNumber;
    private final boolean delicate;

    public Delivery(Dimensions dimensions,
                    int weight,
                    String address,
                    boolean canFlip,
                    String registrationNumber,
                    boolean delicate) {
        this.dimension = dimensions;
        this.weight = weight;
        this.address = address;
        this.canFlip = canFlip;
        this.registrationNumber = registrationNumber;
        this.delicate = delicate;
    }

    public Dimensions getDimensions() {
        return dimension;
    }

    public Delivery setDimensions(Dimensions dimensions) {
        return new Delivery(dimensions, weight, address , canFlip, registrationNumber, delicate);
    }

    public int getWeight() {
        return weight;
    }

    public Delivery setWeight(int weight) {
        return new Delivery(dimension, weight, address , canFlip, registrationNumber, delicate);
    }

    public String getAddress() {
        return address;
    }

    public Delivery setAddress(String address) {
        return new Delivery(dimension, weight , address , canFlip, registrationNumber, delicate);
    }

    public boolean getCanFlip() {
        return canFlip;
    }

    public Delivery setCanFlip(boolean canFlip) {
        return new Delivery(dimension, weight, address, canFlip, registrationNumber, delicate);
    }

    public boolean getDelicate() {
        return delicate;
    }

    public Delivery setDelicate(boolean delicate) {
        return new Delivery(dimension, weight, address, canFlip, registrationNumber, delicate);
    }




}