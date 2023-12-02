package lesson_2023_11_11_phoneBook.models;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PhoneBook {

    ////// --= Поле класса =--

    private List<Contact> phoneBook = new ArrayList<>();

    ////// --= Методы =--

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
        System.out.println("================================================");
        List<Contact> results = phoneBook.stream().sorted((x, y) -> Integer.valueOf(x.getId()).compareTo(Integer.valueOf(y.getId()))).toList();
        results.forEach(contact -> System.out.println(contact.toString()));
    }

    //// удаляем контакт
    public boolean delete(int ID) {
        int finalID = ID - 1;
        System.out.println("_ пробуем удалить контакт с ID " + ID);
        if (phoneBook.stream().anyMatch(x -> x.getId() == ID)) {
//            System.out.println("_ нашли в книге ID " + finalID);
            System.out.println("_ вроде нашли искомый " + phoneBook.stream().filter(x -> x.getId() == ID).findFirst().get());  // возвращает всю запись
//            System.out.println("_ вроде нашли искомый " + phoneBook.stream().filter(x -> x.getId() == ID));  // возвращает ссылку

//            phoneBook.remove(phoneBook.stream().filter(x -> x.getId() == ID).findFirst());  // не работает
//            phoneBook.remove(phoneBook.stream().filter(x -> x.getId() == ID));  // не работает
//            phoneBook
            Optional<Integer> index = phoneBook.stream()
                            .map(Contact::getId)
                                    .filter(i -> i == ID)
                                            .findFirst();
            System.out.println("_ как будто индекс равен " + index.get() + "!");
            System.out.println(">> контакт с id " + ID + " удален!");
            return true;
        } else {
            System.out.println(">> такого контакта не существует!");
            return false;
        }
    }

//    @Override
//    public String toString() {
//        return "PhoneBook{" +
//                "phoneBook=" + phoneBook +
//                '}';
//    }

    //// ввод тестовой телефонной книги
    public void enterTestBook() {
        phoneBook.add(0, new Contact("Феодосия", "+7222333444", Type.HOME, "", "", null, null));
        phoneBook.add(1, new Contact("Иван", "+7333444555", Type.WORK, "Федорович", "Крузенштерн", Sex.MALE, null));
        phoneBook.add(2, new Contact("Клементина", "+7111222333", Type.MOBILE, "Агаповна", "Хронобегова", Sex.FEMALE, LocalDate.of(1964,01,21)));
        phoneBook.add(3, new Contact("Варфоломей", "+7444555666", Type.MOBILE, "Галактионович", "Староверов", Sex.MALE, LocalDate.of(2010,11,27)));
        System.out.println(">> тестовая книга добавлена!");
    }

}
