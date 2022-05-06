import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    private static final int newWidth = 300;


    public static void main(String[] args) {
        String srcFolder = "C:\\src";
        String dstFolder = "C:\\dst";

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();

        int coreCount = Runtime.getRuntime().availableProcessors();
        ArrayList<File[]> allFiles = new ArrayList<>();

        for (int i = 0; i < coreCount; i++) {
            File[] files1 = new File[(i == coreCount - 1) ?
                    Objects.requireNonNull(files).length - files.length / coreCount * coreCount + files.length / coreCount :
                    Objects.requireNonNull(files).length / coreCount];
            System.arraycopy(files, i * (files.length / coreCount), files1, 0, files1.length);
            allFiles.add(files1);
        }

        for (File[] file : allFiles) {
            System.out.println(file.length);
            ImageResizer resizer = new ImageResizer(file, newWidth, dstFolder);
            new Thread(resizer).start();
        }
    }
}
