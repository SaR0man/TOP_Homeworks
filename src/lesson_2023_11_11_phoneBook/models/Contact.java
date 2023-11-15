package lesson_2023_11_11_phoneBook.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Contact {
    public Contact() {
    }

    public Contact(String lastName, String firstName, String patronymic, Gender gender, int[] birth, String phoneNumber, Type type) {
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

    //// вычисляем возраст контакта
    public int age(int[] birth) {
        int age = 0;
        LocalDate now = LocalDate.now();  // узнаём текущую дату (в формате YYYY-MM-DD)
        LocalDate birthDate = LocalDate.of(birth[2], birth[1], birth[0]);  // приводим значения массива birth к формату LocalDate (в формате YYYY-MM-DD)
        age = (int) ((int) ChronoUnit.DAYS.between(birthDate, now) / 365.25);  // вычисляем разницу между датой рождения и текущей датой в годах
        return age;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender=" + gender +
                ", birth=" + birth[2] + "." + birth[1] + "." + birth[0] +
                ", age=" + age(birth) +
                ", phoneNumber=" + phoneNumber +
                ", type=" + type +
                ", id=" + id +
                '}';
    }
}
