package lesson_2023_11_11_phoneBook.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    public Person() {
    }

    public Person(String lastName, String firstName, String patronymic, Gender gender, int[] birth, String phoneNumber, Type type) {
        this.id = ++count;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.gender = gender;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    private  static int count;
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    Gender gender;
    public enum Gender {
        MALE, FEMALE
    }
    private String phoneNumber;
    Type type;

    public enum Type {
        MOBILE, HOME, WORK, FAX
    }

    private int[] birth = new int[3];

    public int[] getBirth() {
        return birth;
    }

    public void setBirth(int[] birth) {
        this.birth = birth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    //// вычисляем возраст абонента
    public int age() {
        int age = 0;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender=" + gender +
                ", birth=" + birth[0] + "." + birth[1] + "." + birth[2] +
                ", phoneNumber=" + phoneNumber +
                ", type=" + type +
                ", id=" + id +
                '}';
    }
}
