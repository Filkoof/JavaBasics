import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.RecursiveTask;

public class RecursiveParseHtml extends RecursiveTask<Set<String>> {

    private Set<String> urlsMap;

    public RecursiveParseHtml(Set<String> urlsMap) {
        this.urlsMap = urlsMap;
    }

    @Override
    protected Set<String> compute() {
        List<RecursiveParseHtml> taskList = new ArrayList<>();
        Set<String> urls = new TreeSet<>();

        try {
            for (String recursiveLink : urlsMap) {
                RecursiveParseHtml task = new RecursiveParseHtml(ParseHtml.readHtml(recursiveLink));
                task.fork();
                taskList.add(task);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        for (RecursiveParseHtml task : taskList) {
//            urls.addAll(task.join());
//        }

        return urls;
    }
}
