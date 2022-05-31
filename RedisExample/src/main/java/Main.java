import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Jedis jedis = new Jedis();
    public static Map<String, Double> usersMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= 20; i++) {
            usersMap.put(String.valueOf(i) , (double) (new Date().getTime() / 1000));
            Thread.sleep(1000);
        }

        for (;;) {
            usersMap.entrySet().forEach(users -> {
                jedis.zadd("Users", Double.parseDouble(String.valueOf((users.getValue()))), String.valueOf(users.getKey()));
            });

            for (int i = 1; i <= usersMap.size(); i++) {
                if (randomInt() < 3) {
                    donate();
                }

                System.out.println("— На главной странице показываем пользователя " +
                        jedis.zrange("Users", i - 1, i - 1));
                Thread.sleep(1000);
            }
        }
    }

    public static int randomInt() {
        return 1 + (int) (Math.random() * 20);
    }

    public static void donate() {
        String userDonat = String.valueOf(randomInt());
        System.out.println("> Пользователь " + userDonat + " оплатил платную услугу");
        jedis.zrem("Users", userDonat);
    }
}
