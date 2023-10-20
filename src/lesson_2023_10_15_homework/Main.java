package lesson_2023_10_15_homework;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();  // создаем собственно объект библиотеки
        System.out.println("Добавляем словарь \'en-ru\': " + library.addDict("en-ru"));  // добавляем англо-русский словарь
        System.out.println("Добавляем словарь \'En-Ru\': " + library.addDict("En-Ru"));  // для проверки добавляем словарь-дубликат
        System.out.println("Добавляем словарь \'ru-ru\': " + library.addDict("ru-ru"));  // добавляем бесполезный словарь :-)
        System.out.println("Удаляем словарь \'ru-ru\': " + library.removeLang("ru-ru"));  // удаляем бесполезный словарь
        System.out.println("=========================");
        System.out.println("В словарь \'en-ru\' добавляем словарную карточку \'word\' - \'слово\': " + library.addCard("en-ru", "word", "слово"));
        System.out.println("В словарь \'en-ru\' добавляем словарную карточку \'Word\' - \'слово\': " + library.addCard("en-ru", "Word", "слово"));
        // НАПОЛНЯЕМ СЛОВАРИ ДАЛЕЕ без вывода в консоль
        library.addCard("en-ru", "time", "время");
        library.addCard("en-ru", "home", "дом");
        library.addCard("en-ru", "cat", "кот");
        library.addCard("en-ru", "cat", "кошка");
        library.addCard("en-ru", "land", "земля");
        library.addCard("en-ru", "hand", "рука");
        library.addDict("ru-en");  // создаем русско-английский словарь
        ArrayList<String> tempTrans = new ArrayList<>();  // создаем коллекцию для нескольких значений перевода
        tempTrans.add("house");
        tempTrans.add("home");
        library.addCard("ru-en", "дом", tempTrans);  // используем метод, принимающий сразу коллекцию переводов слова
        library.addCard("ru-en", "кот", "cat");
        System.out.println("=========================");
        System.out.println("Выводим все словари:");
        library.printDictionaries();
        System.out.println("=========================");
        System.out.println("Выводим содержимое всех словарей:");
        library.printDict();
        System.out.println("=========================");
        System.out.println("Работа с удалением словарных карточек и удалением слов-переводов:");
        library.addCard("ru-en", "голова", "*** ошибочная запись ***");  // для теста вводим словарную карточку с некорректным переводом
        library.printCards("ru-en");
        System.out.println("удаляем некорректную словарную карточку");
        System.out.println(library.removeCard("ru-en", "голова"));
        library.printCards("ru-en");
        library.addCard("ru-en", "голова", "*** ошибочная запись ***");  // для теста вводим словарную карточку с некорректным переводом
        library.addCard("ru-en", "дом","*** ошибочная запись ***");  // добавляем некорректное слово-перевод в коллекцию слов-переводов
        library.printCards("ru-en");
        System.out.println(library.removeTrans("ru-en", "голова", "*** ошибочная запись ***"));  // удаляем некорректное слово-перевод из словарной карточки с одним переводом
        library.printCards("ru-en");
        System.out.println(library.removeTrans("ru-en", "дом","*** ошибочная запись ***"));  // удаляем некорректное слово-перевод из словарной карточки с несколькими переводами
        library.printCards("ru-en");
        System.out.println("=========================");
        library.printContains("en-ru", "h");
        System.out.println("=========================");
        library.train();
    }
}
