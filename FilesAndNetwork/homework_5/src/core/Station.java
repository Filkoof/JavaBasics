package core;

public class Station {
    private String line;
    private String station;

    public Station(String line, String station){
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
        return "Номер линии: " + line + " Имя станции:  " + station;
    }
}
