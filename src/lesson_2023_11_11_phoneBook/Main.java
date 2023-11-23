package lesson_2023_11_11_phoneBook;

import lesson_2023_11_11_phoneBook.models.Contact;
import lesson_2023_11_11_phoneBook.models.PhoneBook;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        String action;

        while (true) {
            System.out.println("1 - Добавить контакт");
            System.out.println("2 - Вывести содержимое книги");
            System.out.println("0 - Завершить программу");
            System.out.print(">_");

            action = scanner.nextLine();

            if (action.equals("1")) {
                phoneBook.addContact();
            }
            else if (action.equals("2")) {
                phoneBook.readBook();
            }
            else if (action.equals("0")) {
                System.out.println("Завершение программы");
                break;
            }
            else
                System.out.println("> некорректный ввод!");
        }



    }
}
