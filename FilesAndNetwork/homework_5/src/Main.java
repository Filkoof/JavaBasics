import java.io.IOException;

public class Main {
    public static HtmlToJson htmlToJson = new HtmlToJson();

    public static void main(String[] args) throws IOException {
        HtmlToJson.parseHtml("https://skillbox-java.github.io/");
    }
}
