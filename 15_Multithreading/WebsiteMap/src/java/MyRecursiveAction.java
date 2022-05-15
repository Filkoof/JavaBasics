import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {

    String url;
    String dst;
    int pageLevel;
    ArrayList workload;

    private static final int THRESHOLD = 4;
    public MyRecursiveAction(String url, String dst, int pageLevel, ArrayList workload) {
        this.url = url;
        this.dst = dst;
        this.pageLevel = pageLevel;
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.size() > THRESHOLD) {
            ForkJoinTask.invokeAll(createSubtask());
        } else {
            processing((ArrayList) workload);
        }
    }

    private List<MyRecursiveAction> createSubtask() {
        List<MyRecursiveAction> subtask = new ArrayList<>();

        ArrayList partOne = (ArrayList) workload.subList(0, workload.size() / 2);
        ArrayList partTwo = (ArrayList) workload.subList(workload.size() / 2, workload.size());

        subtask.add(new MyRecursiveAction(this.url, this.dst, this.pageLevel, partOne));
        subtask.add(new MyRecursiveAction(this.url, this.dst, this.pageLevel, partTwo));

        return subtask;
    }

    private void processing(ArrayList urlList) {
        try {
            ParseHtml.writeFile(this.dst, urlList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
