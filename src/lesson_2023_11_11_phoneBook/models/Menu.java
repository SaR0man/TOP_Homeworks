package lesson_2023_11_11_phoneBook.models;

import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    public void mainMenu() {

        PhoneBook phoneBook = new PhoneBook();

        System.out.println("====================================");
        System.out.println("*   Программа 'Телефонная книга'   *");

        Scanner scanner = new Scanner(System.in);
        String action;

        while (true) {
            System.out.println("=========== ГЛАВНОЕ МЕНЮ ===========");
            System.out.println("1 - Добавить контакт");
            System.out.println("2 - Вывести содержимое книги");
            System.out.println("3 - Удалить контакт");
            System.out.println("4 - Записать содержимое книги в файл");
            System.out.println("5 - Редактировать контакт");
            System.out.println("6 - Поиск по книге");
            System.out.println("9 - Загрузить тестовую книгу");
            System.out.println("0 - Завершить программу");
            System.out.print(">_");

            action = scanner.nextLine();

            if (action.equals("1")) {
                phoneBook.addContact();
            } else if (action.equals("2")) {
//                phoneBook.readBook();
                while (true) {
                    System.out.print("Сортировать: 1 по имени, 2 по фамилии, 3 по возрасту (возрастание), 4 по возрасту (убывание), 5 по ID >_");
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
                    }
                    if (sortSwitch.equals("5")) {
                        phoneBook.readByID();
                        break;
                    } else
                        System.out.println(">> некорректный ввод!");
                }
            } else if (action.equals("3")) {
                Scanner scanner1 = new Scanner(System.in);
                while (true) {
                    phoneBook.readByID();
                    System.out.print("Введите id контакта для удаления: >_");
                    int delID = scanner1.nextInt();
                    if (phoneBook.delete(delID))
                        break;
                }
            } else if (action.equals("4")) {
                phoneBook.writeToFile();
            }

            else if (action.equals("5")) {
                Scanner scanner1 = new Scanner(System.in);
                phoneBook.readByID();
                System.out.print("Введите id контакта для редактирования: >_");
                int editById = scanner1.nextInt();
                phoneBook.editing(editById);
            }

            else if (action.equals("9")) {
                phoneBook.enterTestBook();
            } else if (action.equals("0")) {
                System.out.println(">> завершение программы");
                break;
            } else
                System.out.println(">> некорректный ввод!");

        }
    }

}


