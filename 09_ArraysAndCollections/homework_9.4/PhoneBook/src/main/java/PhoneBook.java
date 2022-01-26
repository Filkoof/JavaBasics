import java.util.*;

public class PhoneBook {

    TreeMap<String, String> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {

        if (checkName(name) && checkPhone(phone)) {
         phoneBook.put(phone, name);
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
        TreeSet<String> contacts = new TreeSet<>();

        if (!phoneBook.isEmpty()) {
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                if (phoneBook.containsValue(entry.getValue())) {
                    ArrayList<String> numbers = new ArrayList<>();
                    for (String key : phoneBook.keySet()) {
                        if (phoneBook.get(key).equals(entry.getValue())) {
                            numbers.add(key);
                        }
                    }
                    contacts.add(entry.getValue() + " - " + String.join(", ", numbers));
                }
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
