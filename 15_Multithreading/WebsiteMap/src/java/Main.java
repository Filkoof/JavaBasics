import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static final String DST = "data/siteMap.txt";
    static final Set<String> siteMapSet = new LinkedHashSet<>();

    public static void main(String[] args) throws InterruptedException {
        new ForkJoinPool().invoke(new RecursiveParseHtml(ParseHtml.readHtml(ParseHtml.URL)));

        ParseHtml.readHtml(ParseHtml.URL);
        for (String url : siteMapSet) {
            System.out.println(url);
        }

        try {
            Files.write(Path.of(DST), siteMapSet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
