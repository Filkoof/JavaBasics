import core.Connections;
import core.Line;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParseHtml {

    public static Map<String, String[]> stationsMap = new LinkedHashMap<>();
    public static Line[] lineArray;
    public static ArrayList<Connections> connectionsArrayList = new ArrayList<>();

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

    public static void makeConnections(Document doc){
        Elements connections = doc.select(".single-station span.t-icon-metroln");

        for (Element connection : connections) {
            String station = connection.attr("title");
            int stationFirstIndex = station.indexOf('«');
            int stationLastIndex = station.lastIndexOf('»');

            String line = connection.attr("class");
            int lineIndex = line.lastIndexOf('-');

            Connections connectionsAdd = new Connections(line.substring(lineIndex + 1),
                    station.substring(stationFirstIndex + 1,stationLastIndex));
            connectionsArrayList.add(connectionsAdd);
        }
    }
}
