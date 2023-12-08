package lesson_2023_11_11_phoneBook;

import lesson_2023_11_11_phoneBook.models.Contact;
import lesson_2023_11_11_phoneBook.models.PhoneBook;
import lesson_2023_11_11_phoneBook.models.Menu;

/*
PhoneBook
Модель (id,name,surname,fathername,phone,bith,age , gender,Type(Mob,Home,Fax))
Добавление  // ........................................ 1, 9
Удаление  // ............................................. 3
Редактирование  // ....................................... 5
Поиск  // ................................................ 6
     * - 0 и больше символов
     _ - 1 символ
    - F*   -> Farid , Fedya , F
    - F*Z  -> FaaasoakdofkowZ FZ
    - F _ _ id -> Farid , Fozid
    Фильтрация
Сортировка  // ........................................... 2
Сохранение было! (в фаил формат любой , txt,xml,json)  //  4
 */

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.mainMenu();
    }
}