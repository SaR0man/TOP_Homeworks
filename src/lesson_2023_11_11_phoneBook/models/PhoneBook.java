package lesson_2023_11_11_phoneBook.models;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PhoneBook {

    ////// --= Поле класса =--

    private List<Contact> phoneBook = new ArrayList<>();

    ////// --= Методы =--

    //// создание контакта и добавление его в телефонную книгу
    public void addContact() {
        phoneBook.add(Contact.create());
    }

    //// выводим все контакты по имени
    public void readByName() {
        System.out.println("===== Список контактов по имени =====");
        List<Contact> results = phoneBook.stream().sorted((x, y) -> x.getFirstName().compareTo(y.getFirstName())).toList();
        results.forEach(contact -> System.out.println(contact.toString()));
    }

    //// выводим все контакты по фамилии
    public void readByLastname() {
        System.out.println("===== Список контактов по фамилии =====");
        List<Contact> results = phoneBook.stream().sorted((x, y) -> x.getLastname().compareTo(y.getLastname())).toList();
        results.forEach(contact -> System.out.println(contact.toString()));
    }

    //// выводим все контакты по возрасту (возрастание)
    public void readByAge() {
        System.out.println("== Список контактов по возрасту (по возрастанию) ==");
        List<Contact> results = phoneBook.stream().sorted((x, y) -> Integer.valueOf(x.getAge()).compareTo(Integer.valueOf(y.getAge()))).toList();
        results.forEach(contact -> System.out.println(contact.toString()));
    }

    //// выводим все контакты по возрасту (убывание)
    public void readByAgeRevers() {
        System.out.println("== Список контактов по возрасту (по убыванию) ==");
        List<Contact> results = phoneBook.stream().sorted((x, y) -> Integer.valueOf(y.getAge()).compareTo(Integer.valueOf(x.getAge()))).toList();
        results.forEach(contact -> System.out.println(contact.toString()));
    }

    //// выводим все контакты ID
    public void readByID() {
        System.out.println("====== Список абонентов по ID ======");
        List<Contact> results = phoneBook.stream().sorted((x, y) -> Integer.valueOf(x.getId()).compareTo(Integer.valueOf(y.getId()))).toList();
        results.forEach(contact -> System.out.println(contact.toString()));
    }

    //// удаляем контакт
    public boolean delete(int contactId) {
        if (phoneBook.stream().anyMatch(x -> x.getId() == contactId)) {

            for (int i = 0; i < phoneBook.size(); i++) {
                int index = phoneBook.get(i).getId();

                if (index == contactId) {
                    phoneBook.remove(i);
                    break;
                }
            }

            System.out.println(">> контакт с id " + contactId + " удален!");
            return true;
        } else {
            System.out.println(">> такого контакта не существует!");
            return false;
        }
    }

    //// запись телефонной книги в файл
    public void writeToFile() {
        try {
            File file = new File("Phonebook.txt");
            file.createNewFile();

            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write("===== Список абонентов по ID =====\n");
            List<Contact> results = phoneBook.stream().sorted((x, y) -> Integer.valueOf(x.getId()).compareTo(Integer.valueOf(y.getId()))).toList();
            results.forEach(contact -> {
                try {
                    fileWriter.write(contact.toString() + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            fileWriter.flush();
            fileWriter.close();
            System.out.println(">> содержимое книги сохранено в файл 'Phonebook.txt'");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //// редактируем контакт
    public void editing(int contactId) {
        if (phoneBook.stream().anyMatch(x -> x.getId() == contactId)) {

            for (int i = 0; i < phoneBook.size(); i++) {
                int index = phoneBook.get(i).getId();

                if (index == contactId) {
                    Scanner newData = new Scanner(System.in);
                    System.out.println("-------- Редактирование контакта " + contactId + " --------");

                    System.out.print("* Текущее имя: " + phoneBook.get(i).getFirstName());
                    System.out.print(". Enter - оставить; или ввести новое имя >_");
                    String data = newData.nextLine();
                    if (!data.isBlank()) phoneBook.get(i).setFirstName(data);

                    System.out.print("* Текущий номер: " + phoneBook.get(i).getPhoneNumber());
                    System.out.print(". Enter - оставить; или ввести новый номер телефона >_");
                    data = newData.nextLine();
                    if (!data.isBlank()) phoneBook.get(i).setPhoneNumber(data);

                    System.out.print("* Текущий тип номера: \'" + phoneBook.get(i).getType().getType() + "\'");
                    System.out.print(". Enter - оставить; или ввести новый тип:\n1-Мобильный, 2-Домашний, 3-Рабочий, 4-Факс >_");
                    data = newData.nextLine();
                    if (!data.isBlank()) {
                        while (true) {
                            if (data.equals("1")) {
                                phoneBook.get(i).setType(Type.MOBILE);
                                break;
                            } else if (data.equals("2")) {
                                phoneBook.get(i).setType(Type.HOME);
                                break;
                            } else if (data.equals("3")) {
                                phoneBook.get(i).setType(Type.WORK);
                                break;
                            } else if (data.equals("4")) {
                                phoneBook.get(i).setType(Type.FAX);
                                break;
                            } else System.out.println(">> ввод некорректный!");
                        }
                    }

                    System.out.print("* Текущее отчество: ");
                    if (phoneBook.get(i).getPatronymic().isBlank() || phoneBook.get(i).getPatronymic() == null)
                        System.out.print("не заполнено");
                    else
                        System.out.print(phoneBook.get(i).getPatronymic());
                    System.out.print(". Enter - оставить; 0-удалить; или ввести новое отчество >_");
                    data = newData.nextLine();
                    if (data.equals("0")) {
                        phoneBook.get(i).setPatronymic("");
                    }
                    else if (!data.isBlank() && !data.equals("0")) phoneBook.get(i).setPatronymic(data);

                    System.out.print("* Текущая фамилия: ");
                    if (phoneBook.get(i).getLastname().isBlank() || phoneBook.get(i).getLastname() == null)
                        System.out.print("не заполнено");
                    else
                        System.out.print(phoneBook.get(i).getLastname());
                    System.out.print(". Enter - оставить; 0-удалить; или ввести новую фамилию >_");
                    data = newData.nextLine();
                    if (data.equals("0")) {
                        phoneBook.get(i).setLastname("");
                    }
                    if (!data.isBlank() && !data.equals("0")) phoneBook.get(i).setLastname(data);

                    System.out.print("* Текущий пол абонента: ");
                    if (phoneBook.get(i).getSex() == Sex.ZERO || phoneBook.get(i).getSex() == null)
                        System.out.print("не заполнено");
                    else
                        System.out.print("\'" + phoneBook.get(i).getSex().getSex() + "\'");
                    System.out.print(". Enter - оставить; или ввести новый пол:\n1-Мужской, 2-Женский >_");
                    data = newData.nextLine();
                    if (!data.isBlank()) {
                        while (true) {
                            if (data.equals("1")) {
                                phoneBook.get(i).setSex(Sex.MALE);
                                break;
                            } else if (data.equals("2")) {
                                phoneBook.get(i).setSex(Sex.FEMALE);
                                break;
                            } else System.out.println(">> ввод некорректный!");
                        }
                    }

                    System.out.print("* Текущая дата рождения: ");
                    if (phoneBook.get(i).getBirthday().equals(LocalDate.of(0, 1, 1)) || phoneBook.get(i).getBirthday() == null)
                        System.out.print("не заполнено");
                    else
                        System.out.print(phoneBook.get(i).getBirthday().getDayOfMonth() + "." + phoneBook.get(i).getBirthday().getMonthValue() + "." + phoneBook.get(i).getBirthday().getYear());
                    System.out.print(". Enter - оставить; или ввести дату рождения в формате \"dd.MM.yyyy\" >_");
                    data = newData.nextLine();
                    if (!data.isBlank()) phoneBook.get(i).setBirthday(LocalDate.parse(data, DateTimeFormatter.ofPattern("dd.MM.yyyy")));

                    break;
                }
            }

        } else {
            System.out.println(">> такого контакта не существует!");
        }
    }

    //// разводящий по поиску по маске
    public void findMask(String sample) {
        System.out.println("_ работает метод phoneBook.findMask:");
        sample = sample.toLowerCase();

        if (sample.contains("_"))  // если в запросе присутствует "_"
            findUnderscore(sample);

        else if (sample.contains("*"))  // если в запросе присутствует "*"
            findStar(sample);

        else findSample(sample);  // если подстановочные знаки отсутствуют
    }

    //// поиск контакта по запросу без подстановочных символов
    public void findSample(String sample) {
        System.out.println("_ работает поиск по запросу без подстановочных символов:");
        phoneBook.stream().filter(o -> o.getFirstName().toLowerCase().contains(sample)).forEach(System.out::println);
        phoneBook.stream().filter(o -> o.getPatronymic().toLowerCase().contains(sample)).forEach(System.out::println);
        phoneBook.stream().filter(o -> o.getLastname().toLowerCase().contains(sample)).forEach(System.out::println);
        phoneBook.stream().filter(o -> o.getPhoneNumber().toLowerCase().contains(sample)).forEach(System.out::println);
    }

    //// поиск контакта по запросу с символом '_'
    public void findUnderscore(String sample) {
        System.out.println("_ работает поиск по запросу с символом '_':");
        String workString;

        for (int x = 0; x < phoneBook.size(); x++) {
            workString = phoneBook.get(x).getFirstName().toLowerCase();
            System.out.println(workString);  // ОТЛАДОЧНОЕ
            if (workString.length() == sample.length()) {
                System.out.println("_ начинаем работать со словом " + workString);
                for (int i = 0, j = 0; i < workString.length(); i++) {
                    System.out.println("_ берем у образца букву " + sample.charAt(i));
                    if (sample.charAt(j) == '_' || sample.charAt(j) == workString.charAt(i)) {
                        System.out.println("_ " + sample.charAt(j) + " сравниваем с " + workString.charAt(i));
                        j++;
                        if (i == workString.length() - 1) {
                            System.out.println("_ найдено совпадение!");
                            System.out.println(phoneBook.get(x).toString());
                        }
                    }
                }
            }
        }

        for (int x = 0; x < phoneBook.size(); x++) {
            workString = phoneBook.get(x).getLastname().toLowerCase();
            System.out.println(workString);  // ОТЛАДОЧНОЕ
            if (workString.length() == sample.length()) {
                System.out.println("_ начинаем работать со словом " + workString);
                for (int i = 0, j = 0; i < workString.length(); i++) {
                    System.out.println("_ берем у образца букву " + sample.charAt(i));
                    if (sample.charAt(j) == '_' || sample.charAt(j) == workString.charAt(i)) {
                        System.out.println("_ " + sample.charAt(j) + " сравниваем с " + workString.charAt(i));
                        j++;
                        if (i == workString.length() - 1) {
                            System.out.println("_ найдено совпадение!");
                            System.out.println(phoneBook.get(x).toString());
                        }
                    }
                }
            }
        }

        for (int x = 0; x < phoneBook.size(); x++) {
            workString = phoneBook.get(x).getPatronymic().toLowerCase();
            System.out.println(workString);  // ОТЛАДОЧНОЕ
            if (workString.length() == sample.length()) {
                System.out.println("_ начинаем работать со словом " + workString);
                for (int i = 0, j = 0; i < workString.length(); i++) {
                    System.out.println("_ берем у образца букву " + sample.charAt(i));
                    if (sample.charAt(j) == '_' || sample.charAt(j) == workString.charAt(i)) {
                        System.out.println("_ " + sample.charAt(j) + " сравниваем с " + workString.charAt(i));
                        j++;
                        if (i == workString.length() - 1) {
                            System.out.println("_ найдено совпадение!");
                            System.out.println(phoneBook.get(x).toString());
                        }
                    }
                }
            }
        }

        for (int x = 0; x < phoneBook.size(); x++) {
            workString = phoneBook.get(x).getPhoneNumber().toLowerCase();
            System.out.println(workString);  // ОТЛАДОЧНОЕ
            if (workString.length() == sample.length()) {
                System.out.println("_ начинаем работать со словом " + workString);
                for (int i = 0, j = 0; i < workString.length(); i++) {
                    System.out.println("_ берем у образца букву " + sample.charAt(i));
                    if (sample.charAt(j) == '_' || sample.charAt(j) == workString.charAt(i)) {
                        System.out.println("_ " + sample.charAt(j) + " сравниваем с " + workString.charAt(i));
                        j++;
                        if (i == workString.length() - 1) {
                            System.out.println("_ найдено совпадение!");
                            System.out.println(phoneBook.get(x).toString());
                        }
                    }
                }
            }
        }

    }

    //// поиск контакта по запросу с символом '*'
    public void findStar(String sample) {
        System.out.println("_ работает поиск по запросу с символом '*':");
    }

    //// ввод тестовой телефонной книги
    public void enterTestBook() {
        phoneBook.add(0, new Contact("Феодосия", "+7222333444", Type.HOME, "", "", Sex.ZERO, LocalDate.of(0,1,1)));
        phoneBook.add(1, new Contact("Иван", "+7333444555", Type.WORK, "Федорович", "Крузенштерн", Sex.MALE, LocalDate.of(0,1,1)));
        phoneBook.add(2, new Contact("Клементина", "+7111222333", Type.MOBILE, "Агаповна", "Хронобегова", Sex.FEMALE, LocalDate.of(1964,01,21)));
        phoneBook.add(3, new Contact("Варфоломей", "+7444555666", Type.MOBILE, "Галактионович", "Староверов", Sex.MALE, LocalDate.of(2010,11,27)));
        System.out.println(">> тестовая книга добавлена!");
    }

}
