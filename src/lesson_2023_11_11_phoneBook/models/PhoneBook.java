package lesson_2023_11_11_phoneBook.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    ////// --= Поле =--
    private List<Contact> phoneBook;

    ////// --= Блок инициализации =--
    {
        this.phoneBook = new ArrayList<>();
    }

    ////// --= Методы =--
    //// стартовый баннер
    public static void starter() {
        System.out.println("========================");
        System.out.println("--= ТЕЛЕФОННАЯ КНИГА =--");
        mainMenu();  // переход на метод основного меню
    }

    //// основное меню
    public static void mainMenu() {
        String action;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("========================");
            System.out.println("1 - Добавить новый контакт");
            System.out.println("2 - Вывести список контактов");
            System.out.println("0 - Завершить программу");
            System.out.print(">_");

            action = scanner.nextLine();

            if (action.equals("1")) {
                if (addContact())
                    System.out.println(">> контакт успешно добавлен!");
                else
                    System.out.println(">> что-то пошло не так...");
            }
            else if (action.equals("0")) {
                System.out.println(">> завершение программы");
                break;
            }
            else
                System.out.println(">> некорректный ввод!");

        } while (true);
    }

    //// добавление нового контакта
    public static boolean addContact() {
        Contact contact = new Contact();
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        String actionAdd;

        do {
            System.out.print("Введите фамилию >_");
            actionAdd = scanner.nextLine();
            if (!actionAdd.isBlank()) {
                contact.setLastName(actionAdd);
                break;
            }
            else
                System.out.println(">> поле не может быть пустым!");
        } while (true);

        do {
            System.out.print("Введите имя >_");
            actionAdd = scanner.nextLine();
            if (!actionAdd.isBlank()) {
                contact.setFirstName(actionAdd);
                flag = true;  // для теста!
                break;
            }
            else
                System.out.println(">> поле не может быть пустым!");
        } while (true);



        return flag;
    }

}
