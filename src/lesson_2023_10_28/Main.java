package lesson_2023_10_28;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/* TODO Программа намеренно выполняет только одну выбранную операцию,
*   чтобы увидеть изменения в дереве проекта */

public class Main {
    public static void addDirAndFileInDir(String dirName, String fileName, String fileExtension) {
        try {
            File dir = new File(dirName);
            if (!dir.exists())
                dir.mkdir();
            File file = new File(dir.getAbsolutePath() + "/" + fileName + "." + fileExtension);
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteDirAndFileInDir(String dirName, String fileName, String fileExtension) {

        try {
            File dir = new File(dirName);
            if (dir.isDirectory()) {
                File file = new File(dir.getAbsolutePath(), fileName + "." + fileExtension);  // не забываем подставить расширение файла!
                if (file.isFile()) {
                    System.out.println("Файл удален? " + file.delete());
                }
                System.out.println("Директория удалена? " + dir.delete());
            } else
                System.out.println("Что-то пошло не так...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        File workDir = new File("workdir");  // папка workdir является полигоном для работы с файлами и директориями
        if (!workDir.exists())
            workDir.mkdir();

        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Создать файлы и папки");
        System.out.println("2 - Удалить файлы и папки");
        System.out.print(">_");
        Integer choice = scanner.nextInt();

        System.out.print("Введите наименование директории >_");
        scanner = new Scanner(System.in);
        String dir = scanner.nextLine();
        System.out.print("Введите имя файла >_");
        String file = scanner.nextLine();
        System.out.print("Введите расширение файла, например: txt>_");
        String fileExtension = scanner.nextLine();
        System.out.print("Введите счетчик операций >_");
        Integer count = scanner.nextInt();


        File dirName = new File(workDir.getAbsolutePath() + "/" + dir);
        File fileName = new File(file);

        for (int i = 0; i < count; i++) {
            String index = "" + i;
            if (choice == 1)
                addDirAndFileInDir(dirName + index, fileName + index, fileExtension);
            else
                deleteDirAndFileInDir(dirName + index, fileName + index, fileExtension);
        }

    }
}
