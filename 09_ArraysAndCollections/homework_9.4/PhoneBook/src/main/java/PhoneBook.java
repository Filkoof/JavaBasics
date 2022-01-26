import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {

    TreeMap<String, String> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {

        if (checkName(name) && checkPhone(phone)) {
            if (phoneBook.containsValue(phone)) {
                phoneBook.put(phone, phoneBook.get(name));
            } else {
                phoneBook.put(phone, name);
            }
        }
    }

    public String getContactByPhone(String phone) {
        String contacts = "";
        if (phoneBook.containsValue(phone)){
            System.out.println("Надо вывести связку ключ + значение");
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку\
        return contacts;
    }

    public Set<String> getContactByName(String name) {

        if (phoneBook.containsKey(name)){
            System.out.println("Надо вывести связку ключ + значение");
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        return new TreeSet<>();

    }

    public Set<String> getAllContacts() {
        TreeSet <String> contacts = new TreeSet<>();

        if (!phoneBook.isEmpty()) {
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                contacts.add(entry.getValue() + " - " + entry.getKey());
                System.out.println(contacts);
            }
        }
        return contacts;
    }

    public boolean checkName (String name) {
        String regex = "[А-Яа-я]+";

        return name.matches(regex);
    }

    public boolean checkPhone (String phone) {
        String regex = "([7-8]?)[0-9]{9,10}";

        return phone.matches(regex);
    }
}
