package lesson_2023_11_11_phoneBook.models;

public class Person {
    public Person() {
    }

    public Person(String lastName, String firstName, String patronymic, Gender gender, String phoneNumber, Type type) {
        this.id = ++count;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    private  static int count;
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    Gender gender;
    private String phoneNumber;
    Type type;

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

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender=" + gender +
                ", phoneNumber=" + phoneNumber +
                ", type=" + type +
                ", id=" + id +
                '}';
    }
}
