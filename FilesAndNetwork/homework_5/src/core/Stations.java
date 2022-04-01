package core;

public class Stations {
    private String number;
    private String[] name;

    public Stations(String number, String[] name){
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }
}
