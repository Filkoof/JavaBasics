import core.Station;
import core.Line;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class ParseHtml {

    public static Map<String, String[]> stationsMap = new LinkedHashMap<>();
    public static Line[] lineArray;
    public static ArrayList<ArrayList<Station>> connectionsArrayList = new ArrayList<>();

    public static void parseToObjects(String url) throws IOException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        makeLines(doc);
        makeStations(doc);
        makeConnections(doc);
    }

    public static void makeLines(Document doc) {
        Elements lines = doc.select(".js-metro-line");
        lineArray = new Line[lines.size()];
        int index = 0;

        for (Element line : lines) {
            Line lineAdd = new Line(line.attr("data-line"), line.text());

            for (int i = 0; i < lineArray.length; i++){
                lineArray[index] = lineAdd;
            }

            index++;
        }
    }

    public static void makeStations(Document doc) {
        Elements lines = doc.select(".s-depend-control-single");
        Elements stations = doc.select(".js-metro-stations");
        int index = 0;

        for (Element line : lines) {
            int fillIndex = 0;
            String[] stationsArray = new String[stations.get(index).select(".single-station span.name").size()];

            for (Element station : stations.get(index).select(".single-station span.name")) {
                stationsArray[fillIndex] = station.text();
                fillIndex++;
            }
            stationsMap.put(line.select(".js-metro-line").attr("data-line"), stationsArray);
            index++;
        }
    }

    public static void makeConnections(Document doc) {
        Elements lines = doc.select(".js-depend");
        Elements stations = doc.select(".js-metro-stations");
        ArrayList<Station> connectionsCheck = new ArrayList();

        int index = 0;

        for (Element line : lines) {
            String stationNumber = line.select(".js-metro-stations").attr("data-line");

            for (Element station : stations.get(index).select(".single-station")) {
                String stationName = station.select("span.name").text();

                if (!station.select("span.t-icon-metroln").isEmpty()) {
                    Elements connections = station.select("span.t-icon-metroln");
                    ArrayList<Station> connectionsAdd = new ArrayList<>();

                    Station stationFrom = new Station(stationNumber, stationName);
                    Station stationTo;

                    connectionsAdd.add(stationFrom);

                    for (Element connection : connections) {
                        String stationConnection = connection.attr("title");
                        int stationFirstIndex = stationConnection.indexOf('«');
                        int stationLastIndex = stationConnection.lastIndexOf('»');

                        String lineConnection = connection.attr("class");
                        int lineIndex = lineConnection.lastIndexOf('-');

                        stationTo = new Station(lineConnection.substring(lineIndex + 1),
                                stationConnection.substring(stationFirstIndex + 1, stationLastIndex));
                        connectionsAdd.add(stationTo);
                    }

                    connectionsArrayList.add(connectionsAdd);
                }
            }
            index++;
        }
    }
}

