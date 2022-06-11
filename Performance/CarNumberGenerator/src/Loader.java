public class Loader {

    public static void main(String[] args) {
        char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

        long start = System.currentTimeMillis();
        int coreCount = Runtime.getRuntime().availableProcessors();

        StringBuilder builder = null;

        for (int regionCode = 1; regionCode < 100; regionCode++) {
            builder = new StringBuilder();
            for (int number = 1; number < 1000; number++) {
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {

                            builder.append(firstLetter)
                                    .append(padNumber(number, 3))
                                    .append(secondLetter)
                                    .append(thirdLetter)
                                    .append(padNumber(regionCode, 2))
                                    .append('\n');
                        }
                    }
                }
            }
        }
        for (int i = 0; i < coreCount; i++) {
            int fileNumber = i + 1;
            WriteToFile write = new WriteToFile("res/numbers" + fileNumber + ".txt", start, builder.toString());
            new Thread(write).start();
        }
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder numberStr = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr.insert(0, '0');
        }

        return numberStr.toString();
    }
}
