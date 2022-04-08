package core;

import java.util.Map;

public class Metro {
    private Line[] lines;
    private Map<String, String[]> stations;


    public Metro(Line[] lines, Map<String, String[]> stations) {
        this.lines = lines;
        this.stations = stations;
    }

    public Line[] getLines() {
        return lines;
    }

    public Map<String, String[]> getStations() {
        return stations;
    }
}
