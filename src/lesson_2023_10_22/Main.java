package lesson_2023_10_22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("======= СЛОВАРЬ =========");
        Scanner scanner = new Scanner(System.in);
        String action;
        Library library = new Library();  // создаем собственно объект библиотеки
        library.fillEnRu();
        do {
            System.out.println(".........................");
            System.out.println("1 Добавить словарь");
            System.out.println("2 Добавить словарную карточку");
            System.out.println("3 Добавить словарную карточку с переводом из несколько слов");
            System.out.println("4 Напечатать список словарей в библиотеке");
            System.out.println("5 Напечатать содержимое словаря");
            System.out.println("6 Удалить словарь");
            System.out.println("7 Поиск слова");
            System.out.println("8 Выход");
            System.out.print(">_");

            action = scanner.nextLine();

            if (action.equals("1")) {
                System.out.print("Введите направление словаря, например, \'en-ru\' >_");
                String dictionary = scanner.nextLine();
                System.out.println(library.addDict(dictionary));
                continue;
            }

            if (action.equals("2")) {
                library.printAllDicts();
                System.out.print("Введите номер словаря, в который добавляем словарную карточку >_");
                String choiceDict = scanner.nextLine();
                String lang = library.getDictByIndex(choiceDict);
                System.out.print("Введите оригинальное слово >_");
                String newOriginWord = scanner.nextLine();
                System.out.print("Введите слово-перевод >_");
                String newTransWord = scanner.nextLine();
                System.out.println(library.addCard(lang, newOriginWord, newTransWord));
                continue;
            }

            if (action.equals("3")) {
                library.printAllDicts();
                System.out.print("Введите номер словаря, в который добавляем словарную карточку >_");
                String choiceDict = scanner.nextLine();
                String lang = library.getDictByIndex(choiceDict);
                System.out.print("Введите оригинальное слово >_");
                String newOriginWord = scanner.nextLine();
                List<String> translation = new ArrayList<>();
                do {
                    System.out.print("Введите новое слово-перевод, или цифру 0 для выхода >_");
                    String transWord = scanner.nextLine();
                    if (transWord.equals("0")) break;
                    translation.add(transWord);
                } while (true);
                System.out.println(library.addCard(lang, newOriginWord, translation));
                continue;
            }

            if (action.equals("4")) {
                library.printAllDicts();
                continue;
            }

            if (action.equals("5")) {
                library.printAllDicts();
                System.out.print("Введите номер словаря для вывода его содержимого >_");
                String choiceDict = scanner.nextLine();
                String lang = library.getDictByIndex(choiceDict);
                library.printCards(lang);
                continue;
            }

            if (action.equals("6")) {
                library.printAllDicts();
                System.out.print("Введите номер словаря который нужно удалить >_");
                String choiceDict = scanner.nextLine();
                String remove = library.getDictByIndex(choiceDict);
                System.out.println(library.removeDict(remove));
                continue;
            }

            if (action.equals("7")) {
                int choiceDict = 0;
                boolean flag = true;
                while (flag) {
                    library.printAllDicts();
                    System.out.print("Введите номер словаря, в котором искать слово >_");
                    Scanner sc = new Scanner(System.in);
                    if (!sc.hasNextInt()) {
                        System.out.print("Будьте внимательнее! ");
                        continue;
                    }
                    choiceDict = sc.nextInt();
                    flag = false;
                }
                library.getDictByIndex(choiceDict);
                System.out.print("Введите поисковый запрос, используя подстановочные знаки \'_\' или \'*\' или без них >_");
                String findStar = scanner.nextLine();
                library.findMask(choiceDict, findStar);
                continue;
            }

            if (action.equals("8")) {
                System.out.println("Program completed");
                break;
            }
            else System.out.println("Некорректный ввод. Вводите команду в диапазоне 1-8: ");

        } while (true);

    }
}
