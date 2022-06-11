import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteToFile implements Runnable {

    private final String fileName;
    private final String numbers;
    private final long start;

    public WriteToFile(String fileName, long start, String numbers) {
        this.fileName = fileName;
        this.start = start;
        this.numbers = numbers;
    }

    @Override
    public void run() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        writer.write(numbers);

        writer.flush();
        writer.close();
        System.out.println("Finished : " + (System.currentTimeMillis() - start) + "ms");
    }
}
