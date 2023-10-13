package lesson_2023_10_08;

import java.util.ArrayList;
import java.util.List;

interface MyFunctional {
    boolean test(int num);
}

public class Homework {
    public static int sumAll(List<Integer> arr, MyFunctional predicate1, MyFunctional predicate2){
        int sum = 0;
        for (int num:arr) {
            if (predicate1.test(num) && predicate2.test(num)){
                sum+=num;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        System.out.print("Контрольный вывод массива: ");
        for (int i = 0; i < 10; i++) {
            arr.add(i + 1);  // заполняем удобными для восприятия значениями от 1 до 10
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        System.out.println("Сумма: " + sumAll(arr, n -> n > 2, n -> n < 5));
    }
}
