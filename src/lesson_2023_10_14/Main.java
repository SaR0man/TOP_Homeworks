package lesson_2023_10_14;

public class Main {
    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary("en-ru");
        dictionary.input("en-ru", "word", "слово");
        dictionary.input("en-ru", "time", "время");
        dictionary.input("en-ru", "home", "дом");
        dictionary.input("en-ru", "hand", "рука");
        dictionary.input("en-ru", "land", "земля");
//        dictionary.printDictionary();

    }
}