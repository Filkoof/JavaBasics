import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    private static String PATH = "data/mongo.csv";

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient( "127.0.0.1" , 27017);
        MongoDatabase database = mongoClient.getDatabase("local");
        MongoCollection<Document> collection = database.getCollection("Students");

        collection.drop();

        try {
            collection.insertMany(read(PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("— общее количество студентов в базе: " + collection.countDocuments() + "\n");

        BsonDocument queryOlderThan = BsonDocument.parse("{Age: {$gte: 40}}");
        List<Document> olderThan = new ArrayList<>();
        collection.find(queryOlderThan).forEach((Consumer<Document>) olderThan::add);
        System.out.println("— количество студентов старше 40 лет: " + olderThan.size() + "\n");

        BsonDocument queryYoungest = BsonDocument.parse("{Age:1}");
        System.out.println("— имя самого молодого студента: " + collection.find().sort(queryYoungest).first() + "\n");

        BsonDocument queryOldest = BsonDocument.parse("{Age:-1}");
        System.out.println("— список курсов самого старого студента: " + collection.find().sort(queryOldest).first() + "\n");
    }

    public static List<Document> read(String path) throws IOException {
        List<Document> documents = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(path));

        for (String line : lines) {
            String[] fragments = line.split("\"");

            String student = fragments[0];
            String courses = fragments[1];

            String[] nameSplitAge = student.split(",");
            String name = nameSplitAge[0];
            int age = Integer.parseInt(nameSplitAge[1]);

            String[] coursesSplit = courses.split(",");
            String course = "";
            for (int i = 0; i < coursesSplit.length; i++) {
                course = course.concat("," + '"' + coursesSplit[i] + '"');
            }
            course = course.replaceFirst(",","");

            Document document = new Document()
                    .append("Name", name)
                    .append("Age", age)
                    .append("Courses", course);
            documents.add(document);
        }
        return documents;
    }
}
