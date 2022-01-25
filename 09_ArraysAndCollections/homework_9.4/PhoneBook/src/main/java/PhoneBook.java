import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {

    TreeMap<String, String> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {

        if (checkName(name) && checkPhone(phone)){
            if (phoneBook.containsValue(phone)) {
                phoneBook.put(phone, phoneBook.get(name));
            } else {
                phoneBook.put(phone, name);
            }
        }
        // проверьте корректность формата имени и телефона (отдельные методы для проверки)
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getContactByPhone(String phone) {

        if (phoneBook.containsValue(phone)){
            System.out.println("Надо вывести связку ключ + значение");
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку\
        return "";
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

        for (Map.Entry<String, String> entry : phoneBook.entrySet()){
            String phone = entry.getKey();
            String name = entry.getValue();
            for (Map.Entry<String, String> entry1 : phoneBook.entrySet()){
                String phone1 = entry1.getKey();
                String name1 = entry1.getValue();

                String contact;
                if (name == name1){
                    contact = name + " - " + phone + " - " + phone1;
                } else {
                    contact = name + " - " + phone;
                }
                contacts.add(contact);
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