import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class ParseHtml {
    public static List<String> urlList = new LinkedList<>();
    public static List<String> checkList = new LinkedList<>();


    public static void writeFile(String dst) throws IOException {
        Files.write(Path.of(dst), urlList);
    }

    public static void readHtml(String url, int pageLevel) throws IOException, InterruptedException {
        Document doc = Jsoup.connect(url).get();

        Elements elements = doc.select("a[href]");
        String subUrl;

        Thread.sleep(150);

        for (Element element : elements) {
            subUrl = element.attr("abs:href");

            if (subUrl.startsWith(url) && !subUrl.endsWith("#") && !subUrl.endsWith(".pdf") && !checkList.contains(subUrl)) {
                checkList.add(subUrl);
                urlList.add("\t".repeat(pageLevel) + subUrl);

                readHtml(subUrl, pageLevel + 1);
            }
        }
    }
}
