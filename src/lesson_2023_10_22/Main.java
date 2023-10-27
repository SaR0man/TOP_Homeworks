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

//            if (action.equals("7")) {
//                library.printAllDicts();
//                System.out.print("Введите номер словаря, в котором искать слово >_");
//                String choiceDict = scanner.nextLine();
//                String findDict = library.getDictByIndex(choiceDict);
//                System.out.print("Введите первые буквы искомого слова >_");
//                String findSample = scanner.nextLine();
//                library.printContains(findDict, findSample);
//                continue;
//            }

//            if (action.equals("7")) {
//                int choiceDict = 0;
//                boolean flag = true;
//                while (flag) {
//                    library.printAllDicts();
//                    System.out.print("Введите номер словаря, в котором искать слово >_");
//                    Scanner sc = new Scanner(System.in);
//                    if (!sc.hasNextInt()) {
//                        System.out.print("Будьте внимательнее! ");
//                        continue;
//                    }
//                    choiceDict = sc.nextInt();
//                    flag = false;
//                }
//                library.getDictByIndex(choiceDict);
//                System.out.print("Введите слово для поиска, используя маску \'_\' >_");
//                String findUnderscore = scanner.nextLine();
//                library.findUnderscore(choiceDict, findUnderscore);
//                continue;
//            }

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
                System.out.print("Введите слово для поиска, используя маску \'*\' >_");
                String findStar = scanner.nextLine();
                library.findStar(choiceDict, findStar);
                continue;
            }

            if (action.equals("8")) {
                System.out.println("Program completed");
                break;
            }
            else System.out.println("Некорректный ввод. Вводите команду в диапазоне 1-8: ");

        } while (true);


//        Library library = new Library();  // создаем собственно объект библиотеки
//        System.out.println("Добавляем словарь \'en-ru\': " + library.addDict("en-ru"));  // добавляем англо-русский словарь
//        System.out.println("Добавляем словарь \'En-Ru\': " + library.addDict("En-Ru"));  // для проверки добавляем словарь-дубликат
//        System.out.println("Добавляем словарь \'ru-ru\': " + library.addDict("ru-ru"));  // добавляем бесполезный словарь :-)
//        System.out.println("Удаляем словарь \'ru-ru\': " + library.removeDict("ru-ru"));  // удаляем бесполезный словарь
//        System.out.println("=========================");
//        System.out.println("В словарь \'en-ru\' добавляем словарную карточку \'word\' - \'слово\': " + library.addCard("en-ru", "word", "слово"));
//        System.out.println("В словарь \'en-ru\' добавляем словарную карточку \'Word\' - \'слово\': " + library.addCard("en-ru", "Word", "слово"));
//        // НАПОЛНЯЕМ СЛОВАРИ ДАЛЕЕ без вывода в консоль
//        library.addCard("en-ru", "time", "время");
//        library.addCard("en-ru", "home", "дом");
//        library.addCard("en-ru", "cat", "кот");
//        library.addCard("en-ru", "cat", "кошка");
//        library.addCard("en-ru", "land", "земля");
//        library.addCard("en-ru", "hand", "рука");
//        library.addDict("ru-en");  // создаем русско-английский словарь
//        ArrayList<String> tempTrans = new ArrayList<>();  // создаем коллекцию для нескольких значений перевода
//        tempTrans.add("house");
//        tempTrans.add("home");
//        library.addCard("ru-en", "дом", tempTrans);  // используем метод, принимающий сразу коллекцию переводов слова
//        library.addCard("ru-en", "кот", "cat");
//        System.out.println("=========================");
//        System.out.println("Выводим все словари:");
//        library.printAllDicts();
//        System.out.println("=========================");
//        System.out.println("Выводим содержимое всех словарей:");
//        library.printLibrary();
//        System.out.println("=========================");
//        System.out.println("Работа с удалением словарных карточек и удалением слов-переводов:");
//        library.addCard("ru-en", "голова", "*** ошибочная запись ***");  // для теста вводим словарную карточку с некорректным переводом
//        library.printCards("ru-en");
//        System.out.println("удаляем некорректную словарную карточку");
//        System.out.println(library.removeCard("ru-en", "голова"));
//        library.printCards("ru-en");
//        library.addCard("ru-en", "голова", "*** ошибочная запись ***");  // для теста вводим словарную карточку с некорректным переводом
//        library.addCard("ru-en", "дом","*** ошибочная запись ***");  // добавляем некорректное слово-перевод в коллекцию слов-переводов
//        library.printCards("ru-en");
//        System.out.println(library.removeTrans("ru-en", "голова", "*** ошибочная запись ***"));  // удаляем некорректное слово-перевод из словарной карточки с одним переводом
//        library.printCards("ru-en");
//        System.out.println(library.removeTrans("ru-en", "дом","*** ошибочная запись ***"));  // удаляем некорректное слово-перевод из словарной карточки с несколькими переводами
//        library.printCards("ru-en");
//        System.out.println("=========================");
//        library.printContains("en-ru", "h");
////        System.out.println("=========================");
////        library.train();
//        System.out.println("=========================");
//        System.out.println("Тестируем добавление в словарную карточку сначала одного слова, затем коллекции слов:");
//        library.addCard("en-ru", "child", "ребенок");
//        tempTrans.clear();
//        tempTrans.add("дитя");
//        tempTrans.add("малыш");
//        library.addCard("en-ru", "child", tempTrans);
//        library.printCards("en-ru");
//        library.printAllDicts();
//        Scanner scanner = new Scanner(System.in);
//        int index = scanner.nextInt();
//        System.out.println(library.getDictByIndex(index));

    }
}
