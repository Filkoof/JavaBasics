import com.fasterxml.jackson.databind.ObjectMapper;
import core.Metro;

import java.io.File;
import java.io.IOException;

public class ToJson {
    public static ObjectMapper objectMapper = new ObjectMapper();
    public static String path = "C:/Users/Professional/IdeaProjects/java_basics/FilesAndNetwork/homework_5/resources/map.json";

    public static void makeJson(){

        try {
//            objectMapper.writerWithDefaultPrettyPrinter()
//                    .writeValue(new File(path), new Metro(ParseHtml.lineArray, ParseHtml.stationsMap));
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), ParseHtml.connectionsArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
