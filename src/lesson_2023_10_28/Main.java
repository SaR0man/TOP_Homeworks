package lesson_2023_10_28;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void addDirAndFileInDir(String dirName, String fileName) {
        try {
            File dir = new File(dirName);
            if (!dir.exists())
                dir.mkdir();
            File file = new File(dir.getAbsolutePath() + "/" + fileName + ".txt");
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteDirAndFileInDir(String dirName, String fileName) {

        try {
            File dir = new File(dirName);
            if (dir.isDirectory()) {
                File file = new File(dir.getAbsolutePath(), fileName + ".txt");  // не забываем подставить расширение файла!
                if (file.isFile()) {
                    System.out.println("Файл удален? " + file.delete());
                }
                System.out.println("Директория удалена? " + dir.delete());
            }
            else
                System.out.println("Что-то пошло не так...");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        File workDir = new File("workdir");  // папка workdir является полигоном для работы с файлами и директориями
        if (!workDir.exists())
            workDir.mkdir();

        File dirName = new File(workDir.getAbsolutePath() + "/dir_");
        File fileName = new File("file_");
        int count = 10;

        for (int i = 0; i < count; i++) {
            String index = "" + i;
//            addDirAndFileInDir(dirName + index, fileName + index);
            deleteDirAndFileInDir(dirName + index, fileName + index);
        }

//        try {
//            File dir = new File("directory");
//            if (dir.exists()) {
//                System.out.println("Такая папка существует.");
//            } else {
//                dir.mkdir();
//                System.out.println("Папка успешно создана.");
//            }
//            File file = new File(dir.getAbsolutePath() + "/file.txt");
//            if (file.exists()) {
//                System.out.println("Такой файл уже существует.");
//            } else {
//                file.createNewFile();
//                System.out.println("Файл успешно создан.");
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
