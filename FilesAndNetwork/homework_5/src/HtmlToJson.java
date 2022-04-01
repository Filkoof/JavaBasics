import core.Line;
import core.Stations;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HtmlToJson {

    public static Map<String, Line[]> linesMap = new HashMap<>();
    public static Map<String, Stations> stationsMap = new HashMap<>();

    public static void parseHtml(String url) throws IOException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        makeLines(doc);
        makeStations(doc);
    }

    public static void makeLines(Document doc) {
        Elements lines = doc.select(".js-metro-line");
        for (Element line : lines) {
            Line lineAdd = new Line(line.attr("data-line"), line.text());
            Line[] lineArray = new Line[lines.size()];

            Arrays.fill(lineArray, lineAdd);

            linesMap.put("lines",lineArray);
        }
    }

    public static void makeStations(Document doc) {
        Elements stations = doc.select(".js-metro-stations");
        for (Element station : stations) {
            String[] stationsArray = new String[stations.size()];

            Arrays.fill(stationsArray, station.getElementsByAttributeValue("class", "name").text());

            Stations stationsAdd = new Stations(station.attr("data-line"), stationsArray);

            stationsMap.put("stations",stationsAdd);
        }
    }
}
