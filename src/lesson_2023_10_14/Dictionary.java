package lesson_2023_10_14;

import java.util.Map;
import java.util.TreeMap;

public class Dictionary {
    private Map<String, Map<String,String>> dictionary;

    public Dictionary(String lang) {
        dictionary = new TreeMap<>();
        dictionary.put(lang, new TreeMap<>());
    }

    public void input(String lang, String original, String translation) {
        dictionary.get(lang).put(original, translation);
    }

    public void output(String lang, String original) {
        System.out.println("Перевод слова \'" + original + "\': " + dictionary.get(lang).get(original));
    }

}