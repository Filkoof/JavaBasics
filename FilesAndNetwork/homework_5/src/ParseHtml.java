import core.Line;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParseHtml {

    public static Map<String, Line[]> linesMap = new LinkedHashMap<>();
    public static Map<String, Map<String, String[]>> stationsMap = new LinkedHashMap<>();


    public static void parseToObjects(String url) throws IOException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        makeLines(doc);
        makeStations(doc);
    }

    public static void makeLines(Document doc) {
        Elements lines = doc.select(".js-metro-line");
        Line[] lineArray = new Line[lines.size()];
        int index = 0;

        for (Element line : lines) {
            Line lineAdd = new Line(line.attr("data-line"), line.text());

            for (int i = 0; i < lineArray.length; i++){
                lineArray[index] = lineAdd;
            }

            index++;
            linesMap.put("lines", lineArray);
        }
    }

    public static void makeStations(Document doc) {
        Map<String, String[]> map = new LinkedHashMap<>();

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
            map.put(line.select(".js-metro-line").attr("data-line"), stationsArray);
            stationsMap.put("stations", map);
            index++;
        }
    }
}
