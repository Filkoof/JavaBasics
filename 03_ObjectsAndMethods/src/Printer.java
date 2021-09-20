public class Printer {
    public String queue = " ";
    public int pendingPagesCount = 0;
    public int totalCountPagesAllTime = 0;

    public append(String text) {
        queue = "Текст документа: " + text + "\n";

    }

    public append(String text, String name) {
        queue = "Название документа: " + name + "\n" + "Текст документа: " + text;
    }

    public append(String text, String name, int pages) {
        queue = name + "\n" + text + " " + pages + "стр.";
        pendingPagesCount = pendingPagesCount + pages;
        totalCountPagesAllTime = totalCountPagesAllTime + pages;

    }

    public clear() {
        queue = " ";
    }

    public print(String queue) {
        System.out.println(queue);
        if (queue.isEmpty()) {
            System.out.println("Введите данные");
        } else {
            System.out.println(queue);
            queue = " ";
            pendingPagesCount = 0;
        }
    }

    private int getPendingPagesCount() {
        return pendingPagesCount;
    }

    private int getTotalCountPagesAllTime() {
        return totalCountPagesAllTime;
    }

}