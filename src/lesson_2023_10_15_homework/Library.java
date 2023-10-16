package lesson_2023_10_15_homework;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

public class Library {
    ////// --= Поле класса =--
    private Map<String, Map<String, List<String>>> library;  // library - библиотека словарей в формате словаря Map

    ////// --= Блок инизиализации =--
    /*
    Создает новый объект TreeMap и сохраняет его в переменной this.library.
    TreeMap - это реализация интерфейса Map, который представляет собой структуру данных, позволяющую хранить пары ключ-значение.
    Значок < > после TreeMap указывает, что этот TreeMap будет использовать универсальные типы (generics), что позволяет ему работать с различными типами ключей и значений.
    В данном случае мы используем TreeMap, потому что он обеспечивает эффективное хранение и извлечение элементов на основе их порядка сортировки.
     */ {
        this.library = new TreeMap<>();
    }

    ////// --= Методы класса =--
    //// Метод для добавления словаря
    public boolean addDict(String dictionary) {  // возвращает true или false, принимает наименование словаря
        dictionary = dictionary.toLowerCase();  // приводим переданное наименование к нижнему регистру
        if (library.containsKey(dictionary)) {  // проверяем: нет ли уже такого словаря
            return false;  // если есть, то ничего не делать и вернуть false
        }
        library.put(dictionary, new TreeMap<String, List<String>>());  // иначе поместить в библиотеку переданный словарь, где dictionary - это ключ, а new TreeMap<String, List<String>>() - значение.
        return true;
    }

    //// Метод для удаления словаря
    public boolean removeLang(String dictionary) {
        dictionary = dictionary.toLowerCase();
        if (library.containsKey(dictionary)) {  // если в библиотеке есть такой словарь, то удалить
            library.remove(dictionary);
            return true;
        }
        return false;
    }

    //// Метод добавляет новую словарную карточку в словарь
    public boolean addCard(String dictionary, String original, String translation) {  // передается название словаря, оригинальное слово и слово-перевод
        original = original.toLowerCase();
        dictionary = dictionary.toLowerCase();
        translation = translation.toLowerCase();
        if (library.containsKey(dictionary)) {  // если библиотека содержит переданный словарь
            if (library.get(dictionary).containsKey(original)) {  //
                if (library.get(dictionary).get(original).contains(translation)) {
                    return false;
                } else {
                    library.get(dictionary).get(original).add(translation);
                    return true;
                }
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(translation);
                library.get(dictionary).put(original, list);
                return true;
            }
        } else {  // если библиотека НЕ содержит переданный словарь
            if (addDict(dictionary)) {  // если метод addDict(dictionary) вернул true
//                boolean isadd =
                return addCard(dictionary, original, translation);  // обращаемся к методу добавления словарной карточки и возвращаем результат операции
            } else {  // если метод addDict(dictionary) вернул false
                return false;
            }
        }
    }

    //// Метод-конвертер содержимого List<String> list в List<String> listArr с приведением всех записей в нижний регистр
    private List<String> toLowerCase(List<String> list) {  // метод приватный, т.к. мы к нему не обращаемся из Main, к нему прямой доступ не нужен
        List<String> listArr = new ArrayList<String>();  // Создает список с элементами типа String и сохраняет его в переменную listArr. Для этого используется класс ArrayList, который является подклассом класса List.
        for (String word : list) {  // каждая запись из переданного в метод list
            listArr.add(word.toLowerCase());  // добавляется в созданный выше listArr, при этом слова приводятся к нижнему регистру
        }
        return listArr;
    }

    ////
    public boolean addCard(String dictionary, String original, List<String> translation) {
        original = original.toLowerCase();
        dictionary = dictionary.toLowerCase();
        translation = toLowerCase(translation);  // с помощью метода toLowerCase(List<String> list) приводим записи коллекции к нижнему регистру
        if (library.containsKey(dictionary)) {  // если библиотека уже содержит такой словарь...
            if (library.get(dictionary).containsKey(original)) {  // ... и если словарь уже содержит такое оригинальное слово
                return false;
            } else {  // ... и если словарь еще не содержит такое оригинальное слово
                library.get(dictionary).put(original, translation);  // добавить в переданный словарь оригинальное слово и слово-перевод
                return true;
            }
        } else {  // если библиотека еще не содержит такой словарь
            if (addDict(dictionary))  //  добавить такой словарь, и если true...
                return addCard(dictionary, original, translation);  // ... добавить словарную карточку и вернуть успех или неуспех этой операции
            else return false;
        }
    }

    //// Метод выводит имеющиеся словари
    public void printDictionaries() {
        System.out.println("--------------------------");
        System.out.println("Имеются следующие словари:");
        int count = 1;
        for (String dictionary : library.keySet()) {  // простой перебор имеющихся ключей в библиотеке
            System.out.println(count++ + ") " + dictionary);
        }
    }

    //// Метод выводит содержание переданного словаря
    public void printCards(String key) {
        int count = 1;
        for (String newKey : library.keySet()) {
            System.out.println("-------------------------");
            System.out.println("Содержимое словаря " + newKey + ":");
            for (String word : library.get(newKey).keySet()) {
                System.out.print(word + " - ");
                for (String tr : library.get(newKey).get(word)) {
                    System.out.print(tr + ", ");
                }
                System.out.println();
            }
        }
    }
}