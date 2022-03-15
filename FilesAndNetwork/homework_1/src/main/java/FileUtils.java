import java.io.File;

public class FileUtils {

    public static long calculateFolderSize(String folder) {
        File file = new File(folder);

        if(file.isFile()){
            return file.length();
        }

        long sum = 0;
        File[] files = file.listFiles();
        for (File file1 : files){
            sum += calculateFolderSize(file1.getAbsolutePath());
        }

        return sum;
    }

    public static String getReadableSize(long size){
        int kilobyte = 1024;
        String[] sizeMultipliers = {"B","Kb","Mb","Gb","Tb"};

        for(int i = 0; i < sizeMultipliers.length; i++){
            double value = size / Math.pow(kilobyte, i);
            if (value < kilobyte){
                return Math.round(value) + sizeMultipliers[i];
            }
        }

        return "";
    }
}
