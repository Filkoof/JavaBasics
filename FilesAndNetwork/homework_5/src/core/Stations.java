package core;

import java.util.Arrays;

public class Stations {
    private final String number;
    private final String[] name;

    public Stations(String number, String[] name){
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String[] getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Номер линии: " + number +
                "Имя станции: " + Arrays.toString(name) + "\n";
    }
}
