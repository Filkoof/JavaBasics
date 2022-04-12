import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static String path = "C:/Users/Professional/IdeaProjects/java_basics/FilesAndNetwork/homework_5/resources/map.json";

    public static void main(String[] args) throws IOException {
        ParseHtml.parseToObjects("https://skillbox-java.github.io/");
        ToJson.makeJson();
        readJson();
    }

    private static void readJson() {
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            stationsAmount(stationsObject);

            JSONArray connectionsArray = (JSONArray) jsonData.get("connections");
            connectionsAmount(connectionsArray);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void stationsAmount(JSONObject stationsObject) {
        stationsObject.keySet().forEach(lineNumberObject -> {
            String lineNumber = ((String) lineNumberObject);
            JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
            System.out.println("На линии: " + lineNumber + " - " +  stationsArray.size() + " станций");
        });
    }

    private static void connectionsAmount(JSONArray connectionsArray) {
        System.out.println("\nКоличество переходов: " + connectionsArray.size());
    }


    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(builder::append);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
