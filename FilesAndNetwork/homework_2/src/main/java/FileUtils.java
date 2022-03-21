import com.google.common.io.Files;

import java.io.*;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        File source = new File(sourceDirectory);
        File destination = new File(destinationDirectory);

        if(source.isDirectory()){
            if(!destination.exists()){
                destination.mkdir();
            }

            String files[] = source.list();

            for (String file : files) {
                File srcFile = new File(source, file);
                File destFile = new File(destination, file);

                copyFolder(srcFile.getPath(),destFile.getPath());
            }

        } else {
            InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(destination);

            byte[] buffer = new byte[1024];

            int length;
            while ((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
        }
    }
}

