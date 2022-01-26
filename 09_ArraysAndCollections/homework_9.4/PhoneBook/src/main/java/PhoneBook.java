import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {

    TreeMap<String, String> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {

        if (checkName(name) && checkPhone(phone)) {
            if (phoneBook.containsKey(phone)) {
                phoneBook.put(phone, name);
            } else {
                phoneBook.put(phone, name.replace(name, name));
            }
        }
    }

    public String getContactByPhone(String phone) {
        String contacts = "";
        if (!phoneBook.isEmpty()){
            contacts = phoneBook.get(phone) + " - " + phone;
        }

        return contacts;
    }

    public Set<String> getContactByName(String name) {
        TreeSet <String> contacts = new TreeSet<>();
        if (!phoneBook.isEmpty()){
            contacts.add(name + " - " + phoneBook.firstKey());
        }

        return contacts;
    }

    public Set<String> getAllContacts() {
        TreeSet <String> contacts = new TreeSet<>();

        if (!phoneBook.isEmpty()) {
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                contacts.add(value + " - " + key);
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
