import java.io.IOException;

public class Main {
    private static final String IMAGES_DIR = "images/";

    public static void main(String[] args) {
        try {
            DownloadFile.downloadImages("https://lenta.ru/", IMAGES_DIR);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
