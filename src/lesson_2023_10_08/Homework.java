package lesson_2023_10_08;

import java.util.ArrayList;
import java.util.List;

interface MyFunctional {  ////// собственный аналог Predicate<Integer>
    boolean test(int num);
}

public class Homework {
    ////// метод складывает значения массива, диапазон которых ограничивается двумя predicate
    public static int sumAll(List<Integer> arr, MyFunctional predicate1, MyFunctional predicate2) {
        int sum = 0;
        for (int num : arr) {
            if (predicate1.test(num) && predicate2.test(num)) {
                sum += num;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        System.out.print("Контрольный вывод массива: ");
        for (int i = 0; i < 10; i++) {
            arr.add(i + 1);  // заполняем удобными для восприятия значениями от 1 до 10
            System.out.print(arr.get(i) + " ");  // выводим содержимое массива для контрольной визуализации
        }
        System.out.println();
        System.out.println("Сумма чисел от 4 до 6 включительно: " + sumAll(arr, n -> n >= 4, n -> n <= 6));
        System.out.println("Сумма четных чисел от 1 до 7: " + sumAll(arr, n -> n <= 7, n -> n % 2 == 0));
        System.out.println("Сумма всех нечетных чисел: " + sumAll(arr, n -> n > 0, n -> n % 2 != 0));
        System.out.println("Сумма всех чисел, кратных пяти: " + sumAll(arr, n -> n > 0, n -> n % 5 == 0));
    }
}
