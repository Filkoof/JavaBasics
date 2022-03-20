import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        File source = new File(sourceDirectory);

        File[] files = source.listFiles();
        for(File f : files) {
            if (f.isFile()){
                File destination = new File(destinationDirectory);
                try {
                    Files.copy(source, destination);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                File destination = new File(destinationDirectory + f.getName());
                destination.mkdir();
            }
        }
    }
}

