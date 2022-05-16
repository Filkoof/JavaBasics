import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class ParseHtml {

    public static final String URL = "https://skillbox.ru/";
    public static final List<String> STOP_WORDS = Arrays.asList("instagram", ".pdf", "twitter", "facebook", "utm", "vkontakte");

    public static Set<String> readHtml(String pageUrl) throws InterruptedException {
        Thread.sleep(150);
        Set<String> urls = new HashSet<>();

        try {
            Document doc = Jsoup.connect(pageUrl).get();
            Elements elements = doc.select("a[href]");

            for (Element element : elements) {
                String url = element.attr("abs:href");
                int backslashCount = 0;

                for (char symbol : url.toCharArray()){
                    if (symbol == '/') backslashCount++;
                }

                if (STOP_WORDS.stream().noneMatch(url::contains)) {
                    if (url.startsWith("http") && url.contains("skillbox.ru")) {
                        synchronized (Main.siteMapSet) {
                            if (!Main.siteMapSet.contains(url)) {
                                if (backslashCount - 3 <= 0) {
                                    urls.add(url);
                                    Main.siteMapSet.add(url);
                                } else {
                                    String s = "\t".repeat(backslashCount - 3) + url;
                                    urls.add(s);
                                    Main.siteMapSet.add(s);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return urls;
    }
}
