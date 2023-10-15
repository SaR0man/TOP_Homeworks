package lesson_2023_10_15;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Dictionary {
    private Map<String, Map<String, List<String>>> dictionary;

    {
        dictionary = new TreeMap<>();
//        dictionary.put()
    }

    public boolean addLanguage(String language) {
        language = language.toLowerCase();
        if (dictionary.containsKey(language))
            return false;
        dictionary.put(language, new TreeMap<>());
        return true;
    }

    public void printLanguage() {
        int count = 1;
        for (String language : dictionary.keySet()) {
            System.out.println(count++ + ") " + language);
        }
    }

    public boolean removeLanguage(String language) {
        language = language.toLowerCase();
        if (dictionary.containsKey(language)) {
            dictionary.remove(language);
            return true;
        }
        return false;
    }
    public boolean addCard(String language, String original, List<String> translation) {
        language = language.toLowerCase();
        original = original.toLowerCase();
//        translation = translation.toLowerCase();
        if (dictionary.containsKey(language))
            if (dictionary.get(language).containsKey(original))
                return false;
        dictionary.get(language).put(original, translation);
        return true;
    }
}

public class Classwork {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        System.out.println(dictionary.addLanguage("en-ru"));
        System.out.println(dictionary.addLanguage("En-ru"));
        System.out.println(dictionary.addLanguage("ru-en"));
        System.out.println(dictionary.removeLanguage("ru-en"));
//        System.out.println(dictionary.addCard("ru-en", "Land", "Земля"));

        dictionary.printLanguage();

    }

}
