package lesson_2023_10_21;

import java.util.*;

public class Library {
    ////// --= Поле класса =--
    private Map<String, Map<String, List<String>>> library;  // библиотека словарей в формате словаря Map
    private List<Integer> numerator;  // коллекция для хранения перемешанных индексов для работы с wordTrans и wordOrigin
    private List<String> wordTrans;  // коллекция всех слов-переводов всей библиотеки
    private List<String> wordOrigin;  // коллекция оригинальных слов, соответствующих словам-переводам в wordTrans

    ////// --= Блок инициализации =--
    {
        this.library = new TreeMap<>();
        this.numerator = new ArrayList<>();
        this.wordTrans = new ArrayList<>();
        this.wordOrigin = new ArrayList<>();

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
    public boolean removeDict(String dictionary) {
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
        if (library.containsKey(dictionary)) {  // если библиотека содержит переданный словарь...
            if (library.get(dictionary).containsKey(original)) {  // ... и если словарь содержит такой ключ...
                if (library.get(dictionary).get(original).contains(translation)) {  // ... и содержит такой перевод
                    return false;
                } else {  // если такого translation переданного original нет, то заносим значение
                    library.get(dictionary).get(original).add(translation);
                    return true;
                }
            } else {  // если словарь не содержит такой ключ (словарную карточку)...
                ArrayList<String> list = new ArrayList<String>();  // ... создаем
                list.add(translation);
                library.get(dictionary).put(original, list);
                return true;
            }
        } else {  // если библиотека НЕ содержит переданный словарь
            if (addDict(dictionary)) {  // если метод addDict(dictionary) вернул true
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

    //// Метод для сверки содержимого имеющейся коллекции слов-переводов и новой коллекции слов-переводов
    private List<String> addNewWord(List<String> currentWordArr, List<String> newWordArr) {
        for (String newWord : newWordArr) {
            if (!currentWordArr.contains(newWord)) {  // если слова из новой коллекции нет в коллекции имеющихся слов-переводов...
                currentWordArr.add(newWord);  // ... добавляем его в нее
            }
        }
        return currentWordArr;
    }

    //// Перегруженный метод addCard добавляет словарную карточку, если значений перевода несколько
    public boolean addCard(String dictionary, String original, List<String> translation) {  // передается название словаря, оригинальное слово и коллекция слов-переводов
        dictionary = dictionary.toLowerCase();
        original = original.toLowerCase();
        translation = toLowerCase(translation);  // с помощью метода toLowerCase(List<String> list) приводим записи коллекции к нижнему регистру
        if (library.containsKey(dictionary)) {  // если библиотека уже содержит такой словарь...
            if (library.get(dictionary).containsKey(original)) {  // ... и если словарь уже содержит такое оригинальное слово
                List<String> tempArr = library.get(dictionary).get(original);  // создаем коллекцию строк tempArr (имеющихся слов-переводов) для сравнения их с новыми предлагаемыми словами-переводами
                List<String> newTempArr = addNewWord(tempArr, translation);  // вызов метода addNewWord по добавлению новых слов из translation в tempArr и присвоение результата его работы в коллекцию newTempArr
                if (newTempArr.size() != tempArr.size()) {
                    library.get(dictionary).put(original, newTempArr);  // поместить в переданный словарь переданное оригинальное слово и коллекцию новых слов-переводов
                    return true;
                }
                return false;
            } else {  // ... и если словарь еще не содержит такое оригинальное слово
                library.get(dictionary).put(original, translation);  // поместить в переданный словарь переданные оригинальное слово и коллекцию слов-переводов
                return true;
            }
        } else {  // если библиотека еще не содержит такой словарь
            if (addDict(dictionary))  //  добавить такой словарь методом addDict, и если true...
                return addCard(dictionary, original, translation);  // ... добавить словарную карточку методом addCard и вернуть успех или неуспех этой операции
            else return false;
        }
    }

    //// Метод выводит имеющиеся словари
    public void printAllDicts() {
        System.out.println("--------------------------");
        System.out.println("Имеются следующие словари:");
        int count = 1;
        for (String dictionary : library.keySet()) {  // простой перебор имеющихся ключей в библиотеке
            System.out.println(count++ + ") " + dictionary);
        }
    }

    //// Метод выводит содержимое всех имеющихся словарей
    public void printLibrary() {
        int count = 1;
//        System.out.println();
        for (String newKey : library.keySet()) {  // перебор всех словарей библиотеки
            System.out.println("-------------------------");
            System.out.println(count++ + ") Содержимое словаря " + newKey + ":");
            for (String original : library.get(newKey).keySet()) {  // перебор всех ключей (оригинальных слов) в словаре
                System.out.print(original + " - ");
                List<String> get = library.get(newKey).get(original);
                for (int i = 0; i < get.size(); i++) {
                    String translation = get.get(i);  // перебор всех слов-переводов в коллекциях original
                    System.out.print(translation);
                    if (i < get.size() - 1) System.out.print(", ");  // запятые ставим там, где они нужны
                }
                System.out.println();
            }
        }
    }

    //// TODO ДЗ: метод выводит содержимое конкретного словаря
    public void printCards(String dictionary) {
        dictionary = dictionary.toLowerCase();
        System.out.println("-------------------------");
        System.out.println("Содержимое словаря " + dictionary + ":");
        int count = 1;
        for (String original : library.get(dictionary).keySet()) {  // перебор всех ключей (оригинальных слов) в словаре
            System.out.print(count++ + ") " + original + " - ");
            List<String> get = library.get(dictionary).get(original);
            for (int i = 0; i < get.size(); i++) {
                String translation = get.get(i);  // перебор всех слов-переводов в коллекциях original
                System.out.print(translation);
                if (i < get.size() - 1) System.out.print(", ");  // запятые ставим там, где они нужны
            }
            System.out.println();
        }
    }


    //// TODO ДЗ: Метод удаляет словарную карточку
    public boolean removeCard(String dictionary, String original) {
        dictionary = dictionary.toLowerCase();
        original = original.toLowerCase();
        if (library.containsKey(dictionary)) {  // если переданный словарь имеется в библиотеке...
            if (library.get(dictionary).containsKey(original)) {  // ... и если словарь содержит такое оригинальное слово...
                library.get(dictionary).remove(original);  // ... то удаляем его
                return true;
            }
        }
        return false;
    }

    //// TODO ДЗ: Метод удаляет слово-перевод
    public boolean removeTrans(String dictionary, String original, String translation) {
        original = original.toLowerCase();
        dictionary = dictionary.toLowerCase();
        translation = translation.toLowerCase();
        if (library.containsKey(dictionary)) {  // если библиотека содержит переданный словарь...
            if (library.get(dictionary).containsKey(original)) {  // ... и если словарь содержит такой ключ...
                if (library.get(dictionary).get(original).contains(translation)) {  // ... и содержит такой перевод
                    int size = library.get(dictionary).get(original).size();
//                    System.out.println("Слов-переводов в слове \'" + translation + "\': " + size);
                    if (size < 2) {  // если слово-перевод только одно...
                        library.get(dictionary).remove(original);  // ... удаляем словарную карточку полностью
                    } else {
                        library.get(dictionary).get(original).remove(translation);  // иначе удаляем только слово-перевод
                    }
                    return true;
                }
            }
        }
        return false;
    }

    //// TODO ДЗ: Метод выводит все словарные карточки указанного словаря, начинающиеся на переданный образец
    public void printContains(String dictionary, String sample) {
        dictionary = dictionary.toLowerCase();
        sample = sample.toLowerCase();
        System.out.println("Словарные карточки словаря " + dictionary + ", начинающиеся с " + sample + ":");
        int count = 0;
        for (String original : library.get(dictionary).keySet()) {  // перебор всех слов-ключей переданного словаря
            if (original.startsWith(sample)) {  // если слово-ключ начинается с образца...
                count++;
                System.out.print(original + " - ");
                List<String> get = library.get(dictionary).get(original);
                for (int i = 0; i < get.size(); i++) {
                    String translation = get.get(i);  // перебор всех слов-переводов в коллекциях original
                    System.out.print(translation);
                    if (i < get.size() - 1) System.out.print(", ");  // запятые ставим там, где они нужны
                }
                System.out.println();
            }
        }
        if (count == 0) System.out.println("Слов, начинающихся с \'" + sample + "\' не найдено");
    }

    //// TODO ДЗ: метод-тренажер
    public void train() {
        for (String newKey : library.keySet()) {  // перебор всех словарей библиотеки
            for (String original : library.get(newKey).keySet()) {  // перебор всех ключей (оригинальных слов) в словаре
                for (String translation : library.get(newKey).get(original)) {
                    wordTrans.add(translation);
                    wordOrigin.add(original);
                }
            }
        }
//        System.out.println(wordTrans);
//        System.out.println(wordOrigin);
        int size = wordTrans.size();
        for (int i = 0; i < size; i++) {
            numerator.add(i);
        }
        Collections.shuffle(numerator);
//        System.out.println(numerator);


        System.out.println("Вводите перевод каждого слова, или нажмите 1 для выхода.");
        boolean switcher = true;
        while (switcher) {
            for (int i : numerator) {
                System.out.print(wordTrans.get(i) + " = ");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if (input.equals("1")) {
                    System.out.println("Работа тренажера завершена.");
                    switcher = false;
                    break;
                } else if (input.equalsIgnoreCase(wordOrigin.get(i))) System.out.println("Верно!");
                else System.out.println("Неверно!");
//                if (!switcher) break;
            }
        }
    }
}
