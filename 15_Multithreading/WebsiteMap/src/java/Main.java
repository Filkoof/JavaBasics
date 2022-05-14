import java.io.IOException;

public class Main {
    private static final String URL = "https://skillbox.ru/";
    private static final String DST = "data/siteMap.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        ParseHtml.readHtml(URL, 0);
        ParseHtml.writeFile(DST);
    }
}
