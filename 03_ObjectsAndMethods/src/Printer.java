public class Printer {
    public String queue = " ";
    public int pendingPagesCount = 0;
    public int totalCountPagesAllTime = 0;


    public static void main(String[] args) {


    }


    public append(String text) {
        queue = queue + text;

    }

    public append(String text, String name) {
        queue = name + "\n" + text;
    }

    public append(String text, String name, int pages) {
        queue = name + "\n" + text + pages + "стр.";
        pendingPagesCount = pendingPagesCount + pages;
        totalCountPagesAllTime = totalCountPagesAllTime + pendingPagesCount + pages;

    }

    public clear() {
        queue = " ";
    }

    public print(String allInfo) {
        System.out.println(allInfo);
        if (queue.isEmpty()) {
            System.out.println("Введите данные");
        } else {
            System.out.println(queue);
            queue = " ";
        }
    }

    public int getPendingPagesCount() {
        return pendingPagesCount;
    }

    public int getTotalCountPagesAllTime() {
        return totalCountPagesAllTime;
    }

}