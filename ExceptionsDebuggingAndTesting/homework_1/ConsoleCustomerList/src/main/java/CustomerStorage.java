import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        String phone = "([+]?[7-8]?)[0-9]{9,10}";
        String email = "[^\\s]+@[A-Za-z]+\\.[A-Za-z]{2,3}";

        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong command! Available command examples: \n" +
                    "add Василий Петров " +
                    "vasily.petrov@gmail.com +79215637722" );
        }
        else if (!components[INDEX_EMAIL].matches(email)){
            throw new IllegalArgumentException("Wrong email format! Available email format examples: \n" +
                    "vasily.petrov@gmail.com" );
        }
        else if (!components[INDEX_PHONE].matches(phone)){
            throw new IllegalArgumentException("Wrong phone format! Available phone format examples: \n" +
                    "+79215637722" );
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}