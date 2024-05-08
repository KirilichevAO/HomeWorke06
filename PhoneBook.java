//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами,
//их необходимо считать, как одного человека с разными телефонами.
//Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создание HashMap для хранения имени и списка телефонных номеров
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Входные данные (имена и телефонные номера)
        String[][] entries = {
                {"Александр", "89239999933"},
                {"Ольга", "89119999922"},
                {"Елена", "89229999999"},
                {"Александр", "89239999922"},
                {"Александр", "89239999911"},
                {"Ольга", "89119999922"}
        };

        // Заполнение телефонной книги
        for (String[] entry : entries) {
            String name = entry[0];
            String phoneNumber = entry[1];

            // Если имя уже есть в телефонной книге, добавляем номер к существующему списку
            if (phoneBook.containsKey(name)) {
                List<String> phoneNumbers = phoneBook.get(name);
                phoneNumbers.add(phoneNumber);
            } else { // Иначе создаем новую запись
                List<String> phoneNumbers = new ArrayList<>();
                phoneNumbers.add(phoneNumber);
                phoneBook.put(name, phoneNumbers);
            }
        }

        // Создание списка записей (имя, количество телефонов) для сортировки
        List<Map.Entry<String, List<String>>> entriesList = new ArrayList<>(phoneBook.entrySet());

        // Сортировка списка по убыванию количества телефонов
        Collections.sort(entriesList, new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> entry1, Map.Entry<String, List<String>> entry2) {
                return entry2.getValue().size() - entry1.getValue().size();
            }
        });

        // Вывод отсортированных записей
        for (Map.Entry<String, List<String>> entry : entriesList) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers.size() + " phone(s) - " + phoneNumbers);
        }
    }
}
