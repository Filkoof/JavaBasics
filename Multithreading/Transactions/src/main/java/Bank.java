import java.util.Map;
import java.util.Random;

public class Bank {
    private Map<String, Account> accounts;
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Account from = accounts.get(fromAccountNum);
        Account to = accounts.get(toAccountNum);

        synchronized (from) {
            synchronized (to){
                if (amount > 50_000 && isFraud(fromAccountNum, toAccountNum, amount)) {
                    from.setBlocked(true);
                    to.setBlocked(true);
                    System.out.println("Обнаружена подозрительная операция, счета " + from.getAccNumber() + " и " +
                            to.getAccNumber() + " замороженны.");
                } else {
                    if (getBalance(fromAccountNum) > amount) {
                        from.setMoney(from.getMoney() - amount);
                        to.setMoney(to.getMoney() + amount);
                        System.out.println("Перевод выполнен успешно.");
                    } else {
                        System.out.println("Недостаточно средств.");
                    }
                }
            }
        }
    }

    public long getBalance(String accountNum) {
        Account account = accounts.get(accountNum);
        return account.getMoney();
    }

    public long getSumAllAccounts() {
        long sum = 0;
        for (String key : accounts.keySet()){
            sum += accounts.get(key).getMoney();
        }
        return sum;
    }
}
