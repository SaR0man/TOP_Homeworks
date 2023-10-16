package lesson_2023_10_15_homework;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();  // создаем собственно объект библиотеки
        System.out.println(library.addDict("en-ru"));  // добавляем первый словарь
        System.out.println(library.addDict("En-Ru"));  // для проверки добавляем словарь-дубликат
        System.out.println(library.addDict("ru-ru"));  // добавляем бесполезный словарь :-)
        System.out.println(library.removeLang("ru-ru"));  // удаляем бесполезный словарь
        System.out.println("=========================");
        System.out.println(library.addCard("en-ru", "word", "слово"));
        System.out.println(library.addCard("en-ru", "time", "время"));
        System.out.println(library.addCard("en-ru", "home", "дом"));
        System.out.println(library.addCard("en-ru", "cat", "кот"));
        System.out.println(library.addCard("en-ru", "cat", "кошка"));
        System.out.println(library.addCard("en-ru", "land", "земля"));
        library.printDictionaries();
        library.printCards("en-ru");


//        dictionary.input("en-ru", "word", "слово");
//        dictionary.input("en-ru", "time", "время");
//        dictionary.input("en-ru", "home", "дом");
//        dictionary.input("en-ru", "hand", "рука");
//        dictionary.input("en-ru", "land", "земля");

    }
}
