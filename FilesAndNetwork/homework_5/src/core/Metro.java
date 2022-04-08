package core;

import java.util.ArrayList;
import java.util.Map;

public class Metro {
    private final Line[] lines;
    private final Map<String, String[]> stations;
    private final ArrayList<ArrayList<Station>> connections;


    public Metro(Line[] lines, Map<String, String[]> stations,ArrayList<ArrayList<Station>> connections) {
        this.lines = lines;
        this.stations = stations;
        this.connections = connections;
    }

    public Line[] getLines() {
        return lines;
    }

    public Map<String, String[]> getStations() {
        return stations;
    }

    public ArrayList<ArrayList<Station>> getConnections() {
        return connections;
    }
}
