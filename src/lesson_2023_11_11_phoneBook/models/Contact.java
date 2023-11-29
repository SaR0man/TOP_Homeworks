package lesson_2023_11_11_phoneBook.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

enum Type {  // тип телефонного номера
    MOBILE("моб."), HOME("дом."), WORK("раб."), FAX("факс");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() { return type; }
}

enum Sex {  // пол абонента
    MALE("муж."), FEMALE("жен.");

    private String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() { return sex; }
}

public class Contact {

    ////// --= ПОЛЯ ==--

    private static int count = 1;
    private int id;
    private String firstName;
    private String phoneNumber;
    Type type = Type.MOBILE;
    private String patronymic;
    private String lastname = "";
    Sex sex;
    private LocalDate birthday = LocalDate.of(0, 1, 1);
    private int age;

    ////// --= Конструкторы =--

    public Contact() {
        this.id = count++;
    }
    public Contact(String firstName, String phoneNumber, Type type, String patronymic, String lastname, Sex sex, LocalDate birthday) {
        this.id = count++;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.patronymic = patronymic;
        this.lastname = lastname;
        this.sex = sex;
        this.birthday = birthday; // LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.age = userAge();
    }

    ////// --= Блок инициализации =--

    {
        birthday = LocalDate.of(0,1,1);
    }

    ////// --= Геттеры и сеттеры =--

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPatronymic() { return patronymic; }

    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public Sex getSex() { return sex; }

    public void setSex(Sex sex) { this.sex = sex; }

    public LocalDate getBirthday() { return birthday; }

    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    ////// --= Методы =--

    //// создаем новый контакт
    public static Contact create() {
        Contact contact = new Contact();
        Scanner scanner = new Scanner(System.in);

        // меню по созданию контакта
        while (true) {
            System.out.println("=======================================");
            System.out.println("Обязательные поля: имя и номер телефона");
            System.out.print("Введите имя >_");
            String newFirstName = scanner.nextLine();

            if (!newFirstName.isBlank()) {
                contact.setFirstName(newFirstName);
                break;
            }
            else
                System.out.println(">> поле обязательное, и не может быть пустым!");
        }

        while (true) {
            System.out.print("Введите номер телефона >_");
            String newPhoneNumber = scanner.nextLine();

            if (!newPhoneNumber.isBlank()) {
                contact.setPhoneNumber(newPhoneNumber);
                break;
            }
            else
                System.out.println(">> поле обязательное, и не может быть пустым!");
        }

        String addAction;

        while (true) {
            System.out.println("===========================================");
            System.out.print("Вводить необязательные поля? 1-Да, 2-Нет >_");
            addAction = scanner.nextLine();

            if (addAction.equals("1")) {
                System.out.println("Остальные поля при желании можно оставить пустыми");
                while (true) {
                    System.out.print("Введите тип номера телефона: 1-Мобильный, 2-Домашний, 3-Рабочий, 4-Факс >_");
                    String newTypeNumber = scanner.nextLine();
                    if (newTypeNumber.isBlank() || newTypeNumber.equals("1")) {
                        contact.setType(Type.MOBILE);
                        break;
                    }
                    else if (newTypeNumber.equals("2")) {
                        contact.setType(Type.HOME);
                        break;
                    }
                    else if (newTypeNumber.equals("3")) {
                        contact.setType(Type.WORK);
                        break;
                    }
                    else if (newTypeNumber.equals("4")) {
                        contact.setType(Type.FAX);
                        break;
                    }
                    else
                        System.out.println(">> ввод некорректный!");
                }

                System.out.print("Введите отчество: >_");
                String newPatronymic = scanner.nextLine();
                contact.setPatronymic(newPatronymic);

                System.out.print("Введите фамилию: >_");
                String newLastname = scanner.nextLine();
                contact.setLastname(newLastname);

                while (true) {
                    System.out.print("Введите пол: 1-Мужчина, 2-Женщина >_");
                    String newSex = scanner.nextLine();
                    if (newSex.equals("1")) {
                        contact.setSex(Sex.MALE);
                        break;
                    }
                    else if (newSex.equals("2")) {
                        contact.setSex(Sex.FEMALE);
                        break;
                    }
                    else
                        System.out.println(">> ввод некорректный!");
                }

                System.out.print("Введите дату рождения в формате \"dd.MM.yyyy\": >_");
                String newBirthday = scanner.nextLine();
                if (newBirthday.isBlank())
                    contact.setBirthday(LocalDate.of(0,1,1));
                else
                    contact.setBirthday(LocalDate.parse(newBirthday, DateTimeFormatter.ofPattern("dd.MM.yyyy")));

                break;

            }
            else if (addAction.equals("2")) {
//                contact.setType(Type.MOBILE);
//                contact.setBirthday(LocalDate.of(0,1,1));
                break;
            }
            else
                System.out.println(">> ввод некорректный!");

        }

        return contact;
    }

    //// вычисляем возраст контакта
    public int userAge() {
        if (birthday == null) {
            setBirthday(LocalDate.of(0, 1, 1));
        }
        if (LocalDate.now().getDayOfYear() - birthday.getDayOfYear() < 0)
            return (LocalDate.now().getYear() - getBirthday().getYear() - 1);
        else
            return LocalDate.now().getYear() - getBirthday().getYear();
    }

    //// переопределенный toString

    @Override
    public String toString() {
        String info;

        info = id + ") Абонент: " + firstName;
        if (patronymic != null) {
            if (!patronymic.isBlank()) info += " " + patronymic;
        }
        if (lastname != null) {
            if (!lastname.isBlank()) info += " " + lastname;
        }
        if (sex != null) info += " (" + sex.getSex() + ")";
        info += ", номер: " + phoneNumber;
        if (type != null) info += " (" + type.getType() + ")";
        if (birthday != null && birthday.getYear() != 0) info += ", ДР: " + birthday.getDayOfMonth() + "." + birthday.getMonthValue() + "." + birthday.getYear()
                + " (возраст: " + userAge() + ")";
        info += ".";

        return info;
    }
}
