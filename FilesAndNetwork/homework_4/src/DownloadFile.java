import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Paths;

public class DownloadFile {

    public static void downloadImages(String url, String savePath) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("img");

        for (Element element : elements) {
            Paths.get(element.attr("abs:src"));

        }
    }
}
