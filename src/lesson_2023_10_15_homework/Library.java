package lesson_2023_10_15_homework;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Library {
    ////// --= Поле класса =--
    private Map<String, Map<String, List<String>>> library;  // library - библиотека словарей в формате словаря Map
    ////// --= Блок инизиализации =--
    /*
    Создает новый объект TreeMap и сохраняет его в переменной this.dictionary.
    TreeMap - это реализация интерфейса Map, который представляет собой структуру данных, позволяющую хранить пары ключ-значение.
    Значок < > после TreeMap указывает, что этот TreeMap будет использовать универсальные типы (generics), что позволяет ему работать с различными типами ключей и значений.
    В данном случае мы используем TreeMap, потому что он обеспечивает эффективное хранение и извлечение элементов на основе их порядка сортировки.
     */
    {
        this.library = new TreeMap<>();
    }
    ////// --= Методы класса =--
    //// Метод для добавления словаря
    public boolean addLang(String dictionary) {  // возвращает true или false, принимает наименование словаря
        dictionary = dictionary.toLowerCase();  // всегда приводим наименования к нижнему регистру
        if (library.containsKey(dictionary)) {  // проверяем: нет ли уже такого словаря
            return false;  // если есть, то ничего не делать и вернуть false
        }
        library.put(dictionary, new TreeMap<String, List<String>>());  // иначе поместить в библиотеку переданный словарь, где dictionary || в TreeMap. dictionary - это ключ, а new TreeMap<String, List<String>>() - значение.
        return true;
    }

}
