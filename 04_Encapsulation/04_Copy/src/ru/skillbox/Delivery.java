package ru.skillbox;

import java.awt.*;

public class Delivery {
    private final Dimension dimensions;
    private final int weight;
    private final String address;
    private final String canFlip;
    private final String registrationNumber;
    private final String delicate;

    public Delivery(int dimensions,
                    int weight,
                    String address,
                    String canFlip,
                    String registrationNumber,
                    String delicate) {
        this.dimensions = Dimension.getVolume;
        this.weight = weight;
        this.address = address;
        this.canFlip = canFlip;
        this.registrationNumber = registrationNumber;
        this.delicate = delicate;
    }

    public int getDimensions() {
        return dimensions;
    }

    public Delivery setDimensions(int dimensions) {
        return new Delivery(dimensions, weight, address , canFlip, registrationNumber, delicate);
    }

    public int getWeight() {
        return weight;
    }

    public Delivery setWeight(int weight) {
        return new Delivery(dimensions, weight, address , canFlip, registrationNumber, delicate);
    }

    public String getAddress() {
        return address;
    }

    public Delivery setAddress(String address) {
        return new Delivery(dimensions, weight , address , canFlip, registrationNumber, delicate);
    }

    public String getCanFlip() {
        return canFlip;
    }

    public Delivery setCanFlip(String canFlip) {
        return new Delivery(dimensions, weight, address, canFlip, registrationNumber, delicate);
    }

    public String getDelicate() {
        return delicate;
    }

    public Delivery setDelicate(String delicate) {
        return new Delivery(dimensions, weight, address, canFlip, registrationNumber, delicate);
    }




}
