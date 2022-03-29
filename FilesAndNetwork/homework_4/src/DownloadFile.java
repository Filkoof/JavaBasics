import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;

public class DownloadFile {

    public static void downloadImages(String url, String savePath) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("img");

        for (Element element : elements) {
            File image = new File(element.attr("abs:src"));

            URL imageUrl = new URL(element.attr("abs:src"));
            InputStream input = imageUrl.openStream();
            OutputStream output = new BufferedOutputStream(
                    new FileOutputStream(Paths.get(savePath) + image.getName()));

            byte[] buffer = new byte[2048];

            while (input.read(buffer) != -1){
                output.write(buffer);
            }
            output.close();
            input.close();
        }
    }
}
