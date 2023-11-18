package lesson_2023_11_11_phoneBook.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

enum Gender {
    MALE, FEMALE
}

enum Type {
    MOBILE, HOME, WORK, FAX
}

public class Contact {

    ////// --= ПОЛЯ ==--

    private  static int count;
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    Gender gender;
    private String phoneNumber;
    Type type;
    private int[] birth = new int[3];
    private Map<String, Type> phoneNumberAndType = new HashMap<>();

////// --= КОНСТРУКТОРЫ =--

    public Contact() {
    }
    public Contact(String lastName, String firstName, String patronymic, Gender gender, int[] birth, Map phoneNumberAndType) { // backup: String phoneNumber, Type type
        this.id = ++count;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.gender = gender;
        this.birth = birth;
//        this.phoneNumber = phoneNumber;
//        this.type = type;
        this.phoneNumberAndType = phoneNumberAndType;
    }

    ////// --= ГЕТТЕРЫ, СЕТТЕРЫ =--


    public int getId() { return id; }

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

//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public Type getType() {
//        return type;
//    }
//
//    public void setType(Type type) {
//        this.type = type;
//    }

    public Map<String, Type> getPhoneNumberAndType() {
        return phoneNumberAndType;
    }

    public void setPhoneNumberAndType(Map<String, Type> phoneNumberAndType) {
        this.phoneNumberAndType = phoneNumberAndType;
    }

    ////// --= МЕТОДЫ =--

    //// создаем контакт
    public boolean create(Contact contact) {
//        Contact contact = new Contact();
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        String actionAdd;

        while (true) {
            System.out.print("Введите имя >_");
            actionAdd = scanner.nextLine();
            if (!actionAdd.isBlank()) {
                contact.setFirstName(actionAdd);
                break;
            }
            else
                System.out.println(">> поле не может быть пустым!");
        }

        while (true) {
            System.out.print("Введите фамилию >_");
            actionAdd = scanner.nextLine();
            if (!actionAdd.isBlank()) {
                contact.setLastName(actionAdd);
                flag = true;  // для тестирования!
                break;
            }
            else
                System.out.println(">> поле не может быть пустым!");
        }

        return flag;
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
