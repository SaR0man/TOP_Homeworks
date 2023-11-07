package lesson_2023_10_29;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static String path = "workdir";  // домашний каталог

    //// метод формирует новый путь при переходе в каталог
    public static void newPath(String goToDir) {
        path += "/" + goToDir;
    }

    //// перегруженный метод формирует новый путь при выходе из каталога
    public static void newPath() {
        path = path.substring(0, path.lastIndexOf('/'));
    }

    //// создает каталог
    public static void newDir(String dirName) {
        File dir = new File(path + "/" + dirName);
        if (!dir.exists()) {
            dir.mkdir();
            System.out.println(">> каталог " + dirName + " успешно создан");
        } else
            System.out.println(">> такой путь уже существует!");
    }

    //// считывает содержимое каталога
    public static void readDir() {
        System.out.println(">> Содержимое каталога \'" + path + "\':");
        File file = new File(path);
        File[] files = file.listFiles();  // метод listFiles возвращает список объектов File, состоящий из содержимого каталога workDir, т.к. File - это и каталог, и файл
        if (files.length > 0) {  // если каталог имеет какое-либо наполнение
            for (File f : files) {  // проходимся по всем элементам списка files
                if (f.isDirectory())
                    System.out.println("<dir>.. " + f.getName());
                else if (f.isFile()) {
                    System.out.println("....... " + f.getName());
                }
            }
        } else
            System.out.println(">> каталог пустой");
    }

    //// переход в каталог
    public static void goToDir(String goToDir) {
        String newPath = path + "/" + goToDir;
        File file = new File(newPath);
        if (file.exists() && file.isDirectory())
            newPath(goToDir);  // методом newPath меняем путь на новый
        else
            System.out.println(">> такого пути не существует!");
    }

    //// удаление каталога
    public static void delDir(String delDir) {
        File file = new File(path + "/" + delDir);
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();

            if (files.length > 0) {  // если каталог имеет какое-либо наполнение
                for (File f : files)
                    f.delete();
                }

            file.delete();
            System.out.println(">> каталог " + delDir + " успешно удален");
        } else
            System.out.println(">> такого пути не существует!");
    }

    //// переименование каталога
    public static void renameDir(String oldNameDir) {
        File file = new File(path + "/" + oldNameDir);
        if (file.exists() && file.isDirectory()) {
            System.out.print("Введите новое имя каталога >_");
            Scanner scanner = new Scanner(System.in);
            String newNameDir = scanner.nextLine();
            file.renameTo(new File(path + "/" + newNameDir));
        }
        else
            System.out.println(">> путь \'" + file + "\' не найден!");
    }

    //// создать файл .txt
    public static void createTxt(String txtName) throws IOException {
        File file = new File(path + "/" + txtName + ".txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println(">> файл \'" + txtName + "\' успешно создан");
        } else
            System.out.println(">> путь \'" + file + "\' не корректный!");
    }

    //// записать текст в файл .txt
    public static void writeTxt(String txtName) {

    }


    public static void main(String[] args) {
        try {
            File file = new File("workdir");
            if (!file.exists()) {
                file.mkdir();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        String action;

        do {  //* КОРНЕВОЕ МЕНЮ *\\
            System.out.println("********************");
            System.out.println("1 - Работа с папками");
            System.out.println("2 - Работа с файлами");
            System.out.println("0 - Закончить работу");
            System.out.print(">> путь: " + path + " >_");

            action = scanner.nextLine();

            if (action.equals("1")) {

                do {  //* РАБОТА С КАТАЛОГАМИ *\\
                    System.out.println("*******************");
                    System.out.println("1 - Создать каталог");
                    System.out.println("2 - Вывести содержимое каталога");
                    System.out.println("3 - Перейти в каталог");
                    System.out.println("4 - Выйти из текущего каталога");
                    System.out.println("5 - Переименовать каталог");
                    System.out.println("6 - Удалить каталог");
                    System.out.println("0 - Выйти из этого меню");
                    System.out.print(">> путь: " + path + " >_");

                    action = scanner.nextLine();

                    if (action.equals("1")) {
                        System.out.print("Введите наименование каталога >_");
                        String dirName = scanner.nextLine();
                        newDir(dirName);
                    } else if (action.equals("2")) {
                        readDir();
                    } else if (action.equals("3")) {
                        System.out.print("Введите имя каталога для перехода в него >_");
                        String goToDir = scanner.nextLine();
                        goToDir(goToDir);
                    } else if (action.equals("4")) {
                        if (!path.equals("workdir")) {
                            newPath();
                        } else
                            System.out.println(">> в рамках учебной программы выйти из workdir нельзя!");
                    } else if (action.equals("5")) {
                        System.out.print("Введите имя каталога для переименования >_");
                        String oldNameDir = scanner.nextLine();
                        renameDir(oldNameDir);
                    } else if (action.equals("6")) {
                        System.out.print("Введите имя каталога для удаления >_");
                        String delDir = scanner.nextLine();
                        delDir(delDir);
                    } else if (action.equals("0")) {
                        break;
                    } else
                        System.out.println(">> некорректный ввод.");
                }
                while (true);
            }

            else if (action.equals("2")) {

                do {   //* РАБОТА С ФАЙЛАМИ *\\
                    System.out.println("*************");
                    System.out.println("1 - Файл .txt");
                    System.out.println("2 - Файл .xml");
                    System.out.println("0 - Выйти из этого меню");
                    System.out.print(">> путь: " + path + " >_");

                    action = scanner.nextLine();

                    if (action.equals("1")) {

                        do {  //* РАБОТА С ФАЙЛОМ .TXT *\\
                            System.out.println("*************");
                            System.out.println("1 - Создать файл .txt");
                            System.out.println("2 - Сделать запись в файл .txt");
                            System.out.println("3 - Считать содержимое из файла .txt");
                            System.out.println("4 - Удалить файл .txt");
                            System.out.println("0 - Выйти из этого меню");
                            System.out.print(">> путь: " + path + " >_");

                            action = scanner.nextLine();

                            if (action.equals("1")) {
                                System.out.print("Введите имя файла >_");
                                String txtName = scanner.nextLine();
                                try {
                                    createTxt(txtName);
                                } catch (IOException e) {
                                    System.out.println(e.getMessage());;
                                }
                            }

                            else if (action.equals("2")) {
                                System.out.print("Введите имя файла >_");
                                String txtName = scanner.nextLine();
                                writeTxt(txtName);
                            }

                            else if (action.equals("0")) {
                                break;
                            }
                            else
                                System.out.println(">> некорректный ввод.");

                        } while (true);

                    }
                    else if (action.equals("0")) {
                        break;
                    } else
                        System.out.println(">> некорректный ввод.");

                }
                while (true);
            }

            else if (action.equals("0")) {
                System.out.println(">> программа завершена");
                break;
            } else
                System.out.println(">> некорректный ввод.");


    }
        while (true);
    }
}