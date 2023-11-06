package lesson_2023_10_29;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static String path = "workdir";  // текущий каталог
    public static void newPath(String goToDir) {
        path += "/" + goToDir;
    }
    public static void main(String[] args) {
        try {
            File file = new File("workdir");
            if (!file.exists()) {
                file.mkdir();
            }
            String path = file + "\\";
            System.out.println(path);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        String action;

        do {
            System.out.println("*******************");
            System.out.println("1 - Создать каталог");
            System.out.println("2 - Содержимое каталога");
            System.out.println("3 - Перейти в каталог");
            System.out.println("4 - Выйти из каталога");
            System.out.println("5 - Переименовать каталог");
            System.out.println("6 - Удалить каталог");
            System.out.print(">> путь: " + path + " >_");

            action = scanner.nextLine();

            if (action.equals("1")) {
                System.out.print("Введите наименование каталога >_");
                String dirName = scanner.nextLine();
                File dir = new File(path + "/" + dirName);
                if (!dir.exists()) {
                    dir.mkdir();
                }
            }

            else if (action.equals("2")) {
                System.out.println(">> Содержимое каталога \'" + path + "\'");
                File file = new File(path);
                File[] files = file.listFiles();  // метод listFiles возвращает список объектов File, состоящий из содержимого каталога workDir, т.к. File - это и каталог, и файл
                for (File f : files) {  // проходимся по всем элементам списка files
                    if (f.isDirectory())
                        System.out.println("<dir> " + f.getName());
                    else if (f.isFile()) {
                        System.out.println("      " + f.getName());
                    }
                }

            }

            else if (action.equals("3")) {
                System.out.print("Введите имя каталога для перехода в него >_");
                String goToDir = scanner.nextLine();
                newPath(goToDir);
                File file = new File(path);
            }

            else if (action.equals("4")) {
                System.out.println("_нажата клавиша 4.");
            }

            else if (action.equals("5")) {
                System.out.println("_нажата клавиша 5.");
            }

            else if (action.equals("6")) {
                System.out.println("_нажата клавиша 6.");
            }

            else
                System.out.println(">> некорректный ввод.");
        }
        while (true);

    }
}
