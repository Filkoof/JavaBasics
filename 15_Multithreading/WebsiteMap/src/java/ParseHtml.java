import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ParseHtml {
    public static List<String> urlList = new ArrayList<>();
    private static List<String> checkList = new ArrayList<>();


    public static void writeFile(String dst, ArrayList urlList) throws IOException {
        Files.write(Path.of(dst), urlList);
    }

    public static void readHtml(String url, int pageLevel) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
