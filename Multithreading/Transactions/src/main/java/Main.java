public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        long balance = 200_000;
        int coreCount = Runtime.getRuntime().availableProcessors();

        for (int i = 1; i <= 1000; i++) {
            bank.fillAccounts(String.valueOf(i), new Account(String.valueOf(i), balance));
        }

        for (int i = 0; i < coreCount; i++) {
            new Thread(()-> {
                for (int j = 0; j <= 10_000; j++) {
                    try {
                        bank.transfer(String.valueOf(1 + (int) (Math.random() * 1000)),
                                String.valueOf(1 + (int) (Math.random() * 1000)),
                                10 + (long) (Math.random() * 55_000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }
}