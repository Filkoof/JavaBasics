package core;

public class Connections {
    private String line;
    private String station;

    public Connections(String line, String station){
        this.line = line;
        this.station = station;
    }

    public String getLine() {
        return line;
    }

    public String getStation() {
        return station;
    }

    @Override
    public String toString() {
        return "Номер линии: " + line + " Переход на станцию:  " + station;
    }
}
