package lesson_2023_11_11_phoneBook.models;

import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    public void mainMenu() {

        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        String action;

        while (true) {
            System.out.println("===== ГЛАВНОЕ МЕНЮ =====");
            System.out.println("1 - Добавить контакт");
            System.out.println("2 - Вывести содержимое книги");
            System.out.println("4 - Записать содержимое книги в файл");
            System.out.println("9 - Загрузить тестовую книгу");
            System.out.println("0 - Завершить программу");
            System.out.print(">_");

            action = scanner.nextLine();

            if (action.equals("1")) {
                phoneBook.addContact();
            } else if (action.equals("2")) {
//                phoneBook.readBook();
                while (true) {
                    System.out.print("Сортировать: 1 - по имени, 2 - по фамилии, 3 - по возрасту (возрастание), 4 - по возрасту (убывание) >_");
                    String sortSwitch = scanner.nextLine();
                    if (sortSwitch.equals("1")) {
                        phoneBook.readByName();
                        break;
                    }
                    if (sortSwitch.equals("2")) {
                        phoneBook.readByLastname();
                        break;
                    }
                    if (sortSwitch.equals("3")) {
                        phoneBook.readByAge();
                        break;
                    }
                    if (sortSwitch.equals("4")) {
                        phoneBook.readByAgeRevers();
                        break;
                    } else
                        System.out.println(">> некорректный ввод!");
                }
            } else if (action.equals("4")) {
                System.out.println("Здесь будет производиться запись содержимого книги в файл");
            } else if (action.equals("9")) {
                phoneBook.enterTestBook();
            } else if (action.equals("0")) {
                System.out.println(">> завершение программы");
                break;
            } else
                System.out.println(">> некорректный ввод!");

        }
    }

}

