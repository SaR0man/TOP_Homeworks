package lesson_2023_11_11_phoneBook.models;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {

    ////// --= Поле класса =--

    private List<Contact> phoneBook = new ArrayList<>();

    ////// --= Методы =--

//    public void create() {
//        PhoneBook phoneBook = new PhoneBook();
//
//    }

    public void addContact() {
        phoneBook.add(Contact.create());
    }

    //// выводим все контакты
    public void readBook() {
        System.out.println("===== Содержание телефонной книги =====");
        for ( Contact contact : phoneBook) {
            System.out.println(contact.toString());
        }
        System.out.println("........................................");
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook +
                '}';
    }
}
