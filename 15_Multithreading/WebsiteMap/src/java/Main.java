import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static final String URL = "https://skillbox.ru/";
    private static final String DST = "data/siteMap.txt";
    private static final int PAGE_LEVEL = 0;

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ParseHtml.readHtml(URL,PAGE_LEVEL);
        List<String> urls = ParseHtml.urlList;

        MyRecursiveAction app = new MyRecursiveAction(URL, DST, PAGE_LEVEL, urls);

        pool.invoke(app);
    }
}
