package lesson_2023_10_15_homework;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();  // создаем собственно объект библиотеки
        System.out.println(library.addDict("en-ru"));  // добавляем англо-русский словарь
        System.out.println(library.addDict("En-Ru"));  // для проверки добавляем словарь-дубликат
        System.out.println(library.addDict("ru-ru"));  // добавляем бесполезный словарь :-)
        System.out.println(library.removeLang("ru-ru"));  // удаляем бесполезный словарь
        System.out.println("=========================");
        System.out.println(library.addCard("en-ru", "word", "слово"));
        System.out.println(library.addCard("en-ru", "Word", "слово"));  // для тестирования попытка ввести некорректное слово-original
        System.out.println(library.addCard("en-ru", "time", "время"));
        System.out.println(library.addCard("en-ru", "home", "дом"));
        System.out.println(library.addCard("en-ru", "cat", "кот"));
        System.out.println(library.addCard("en-ru", "cat", "кошка"));
        System.out.println(library.addCard("en-ru", "land", "земля"));
        System.out.println(library.addCard("en-ru", "hand", "рука"));
        library.addDict("ru-en");  // создаем русско-английский словарь
        ArrayList<String> tempTrans = new ArrayList<>();  // создаем коллекцию для нескольких значений перевода
        tempTrans.add("house");
        tempTrans.add("home");
        library.addCard("ru-en", "дом", tempTrans);  // используем метод, принимающий сразу коллекцию переводов слова
        library.addCard("ru-en", "кот", "cat");

        library.printDictionaries();
        library.printDict();
        System.out.println("=========================");
        library.addCard("ru-en", "голова", "*** ошибочная запись ***");  // для теста вводим словарную карточку с некорректным переводом
        library.printCards("ru-en");
        System.out.println("удаляем некорректную словарную карточку");
        System.out.println(library.removeCard("ru-en", "голова"));
        library.printCards("ru-en");
        library.addCard("ru-en", "голова", "*** ошибочная запись ***");  // для теста вводим словарную карточку с некорректным переводом
        library.addCard("ru-en", "дом","*** ошибочная запись ***");  // добавляем некорректное слово-перевод в коллекцию слов-переводов
        library.printCards("ru-en");
        System.out.println(library.removeTrans("ru-en", "голова", "*** ошибочная запись ***"));
        library.printCards("ru-en");
        System.out.println(library.removeTrans("ru-en", "дом","*** ошибочная запись ***"));
        library.printCards("ru-en");
        library.printContains("en-ru", "ha");
    }
}
