package lesson_2023_10_15_homework;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();  // создаем собственно объект библиотеки
        System.out.println(library.addDict("en-ru"));  // добавляем англо-русский словарь
        System.out.println(library.addDict("En-Ru"));  // для проверки добавляем словарь-дубликат
        System.out.println(library.addDict("ru-ru"));  // добавляем бесполезный словарь :-)
        System.out.println(library.removeLang("ru-ru"));  // удаляем бесполезный словарь
        System.out.println("=========================");
        System.out.println(library.addCard("en-ru", "word", "слово"));
        System.out.println(library.addCard("en-ru", "Word", "слово"));  // для тестирования некорректное слово-original
        System.out.println(library.addCard("en-ru", "time", "время"));
        System.out.println(library.addCard("en-ru", "home", "дом"));
        System.out.println(library.addCard("en-ru", "cat", "кот"));
        System.out.println(library.addCard("en-ru", "cat", "кошка"));
        System.out.println(library.addCard("en-ru", "land", "земля"));
        library.addDict("ru-en");  // создаем русско-английский словарь
        library.addCard("ru-en", "слово", "word");
        library.addCard("ru-en", "время", "time");
        ArrayList<String> tempTrans = new ArrayList<>();  // создаем коллекцию для нескольких значений перевода
        tempTrans.add("house");
        tempTrans.add("home");
        library.addCard("ru-en", "дом", tempTrans);  // используем метод, принимающий сразу коллекцию переводов слова
        library.addCard("ru-en", "кот", "cat");
        library.addCard("ru-en", "земля", "land");

        library.printDictionaries();
        library.printCards();


//        dictionary.input("en-ru", "word", "слово");
//        dictionary.input("en-ru", "time", "время");
//        dictionary.input("en-ru", "home", "дом");
//        dictionary.input("en-ru", "hand", "рука");
//        dictionary.input("en-ru", "land", "земля");

    }
}
