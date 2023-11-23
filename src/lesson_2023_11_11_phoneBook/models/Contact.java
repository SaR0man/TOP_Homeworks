package lesson_2023_11_11_phoneBook.models;

import java.util.*;

enum Type {
    MOBILE, HOME, WORK, FAX
}

public class Contact {
    ////// --= ПОЛЯ ==--

    private static int count = 1;
    private int id;
    private String firstName;
    Type type;
    private String phoneNumber;

    ////// --= Конструкторы =--

    public Contact() {
        this.id = count++;
    }

    ////// --= Блок инициализации =--



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
                while (true) {
                    System.out.print("Введите тип номера телефона или оставьте пустым: 1-Мобильный, 2-Домашний, 3-Рабочий, 4-Факс >_");
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
                break;
            }
            else if (addAction.equals("2")) {
                break;
            }
            else
                System.out.println(">> ввод некорректный!");

        }

//        System.out.println(contact.toString());  // !!! для тестирования !!!

        return contact;
    }

    //// переопределенный toString

    @Override
    public String toString() {
        String info = id + ") имя: " + firstName + ", номер: " + phoneNumber;
        if (type != null) {
            info += " (" + type + ")";
        }
        info += ".";
        return info;
    }
}
