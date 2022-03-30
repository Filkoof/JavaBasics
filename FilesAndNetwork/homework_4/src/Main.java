import java.io.IOException;

public class Main {
    private static final String IMAGES_DIR = "C:\\Users\\Professional\\IdeaProjects\\java_basics\\FilesAndNetwork\\homework_4\\images";

    public static void main(String[] args) {
        try {
            DownloadFile.downloadImages("https://lenta.ru/", IMAGES_DIR);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
