import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Main {
    public static ObjectMapper mapper = new ObjectMapper();
    public static String path = "C:/Users/Professional/IdeaProjects/java_basics/FilesAndNetwork/homework_5/resources/map.json";

    public static void main(String[] args) throws IOException {
        ParseHtml.parseToObjects("https://skillbox-java.github.io/");
        ToJson.makeJson();
    }
}
