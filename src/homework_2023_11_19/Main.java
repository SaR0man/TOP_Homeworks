package homework_2023_11_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
           1) Дана коллекция строк { "a1","a2","a3","a2","a2","a5","a1"} вернцть количество вхождений объекта "а1" c помощью streamApi
           2) Найти элемент в коллекции равный "a3" или вывести "ошибку"
           3) Вернуть последний элемент коллекции или "empty" если коллекция пуста
           4) Вернуть два элемента начиная со второго элемента коллекции
           5) Из коллекции имен убрать все повторения и найти среднию длинну имен
           6) Отсортировать коллекцию строк по убыванию и убрать дубликаты
           7) Вернуть сумму нечетных чисел или 0
 */

public class Main {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>(Arrays.asList("a1", "a2", "a3", "a2", "a2", "a5", "a1"));

        System.out.println("----------------------------------");
        System.out.println("Дано: " + stringList.toString());

        // 1) вернцть количество вхождений объекта "а1"
        System.out.println("1) Число строк \'a1\' = "
                + stringList.stream().filter(s -> s.equals("a1")).count());

        // 2) Найти элемент в коллекции равный "a3" или вывести "ошибку"
        System.out.println("2) Найти \'a3\': "
                + stringList.stream().filter(str -> str.contains("a3")).findFirst().orElse("error"));;

        // 3) Вернуть последний элемент коллекции или "empty" если коллекция пуста
        System.out.println("3) Последний элемент коллекции: "
                + stringList.stream().reduce((e1, e2) -> e2).orElse("empty"));

        // 4) Вернуть два элемента начиная со второго элемента коллекции
        System.out.println("4) Два элемента начиная со второго элемента коллекции: "
                + stringList.stream().skip(1).limit(2).collect(Collectors.toList()));

        // 5) Из коллекции имен убрать все повторения и найти среднюю длину имен
        System.out.print("5) Средняя длина уникальных элементов в коллекции ");
        List<String> stringResult = stringList.stream().distinct().collect(Collectors.toList());
        System.out.print(stringResult.toString() + " = ");
        System.out.println((stringResult.stream().mapToInt(str -> str.length()).sum()) / 2);

        // 6) Отсортировать коллекцию строк по убыванию и убрать дубликаты
        System.out.println("6) Сортированный список уникальных элементов: "
                + stringList.stream().distinct().sorted().collect(Collectors.toList()));

        // 7) Вернуть сумму нечетных чисел или 0
        System.out.print("7) Сумма нечетных чисел = ");
        int result = stringList.stream().mapToInt(str -> Integer.parseInt(str.substring(1))).filter(str -> str % 2 != 0).sum();
        System.out.println(result);

    }
}
