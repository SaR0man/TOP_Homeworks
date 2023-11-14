package lesson_2023_11_11_phoneBook;

import lesson_2023_11_11_phoneBook.models.Person;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person(
                "Иванов",
                "Иван",
                "Иваныч",
                Person.Gender.MALE,
                new int[]{24, 01, 1984},
                "+7 (910) 876-54-32",
                Person.Type.MOBILE);
        System.out.println(person1.toString());
        Person person2 = new Person("Петров",
                "Петр",
                "Петрович",
                Person.Gender.MALE,
                new int[]{30, 05, 1992},
                "+7 (905) 765-43-21",
                Person.Type.MOBILE);
        System.out.println(person2.toString());

    }


}
