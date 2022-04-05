import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ParseHtml.parseToObjects("https://skillbox-java.github.io/");
        ToJson.makeJson();
    }
}
