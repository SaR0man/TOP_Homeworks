package lesson_2023_11_11_phoneBook;

import lesson_2023_11_11_phoneBook.models.Gender;
import lesson_2023_11_11_phoneBook.models.Person;
import lesson_2023_11_11_phoneBook.models.Type;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Иванов", "Иван", "Иваныч", Gender.MALE, "+7 (910) 876-54-32", Type.MOBILE);
        System.out.println(person1.toString());
        Person person2 = new Person("Петров", "Петр", "Петрович", Gender.MALE, "+7 (905) 765-43-21", Type.MOBILE);
        System.out.println(person2.toString());

    }


}
