import java.awt.*;

import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        // 1. Установка
        Creator dir = new Creator();
        dir.createFolder("C:/Users/fende/Games/src");
        dir.createFolder("C:/Users/fende/Games/res");
        dir.createFolder("C:/Users/fende/Games/savegames");
        dir.createFolder("C:/Users/fende/Games/temp");
        dir.createFolder("C:/Users/fende/Games/src/main");
        dir.createFolder("C:/Users/fende/Games/src/test");
        dir.createFolder("C:/Users/fende/Games/res/drawables");
        dir.createFolder("C:/Users/fende/Games/res/vectors");
        dir.createFolder("C:/Users/fende/Games/res/icons");

        dir.createFile("C:/Users/fende/Games/src/main/Main.java");
        dir.createFile("C:/Users/fende/Games/src/main/Utils.java");
        dir.createFile("C:/Users/fende/Games/temp/temp.txt");

        // Берём текст из экземпляра класса StringBuilder и записываем его в файл temp.txt с помощью класса FileWriter.
        String text = Creator.sb.toString();
        try (FileWriter writer = new FileWriter("C:/Users/fende/Games/temp/temp.txt", false)) {
            writer.write(text);
            writer.append('\n');
            writer.append('!');
            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

//        2. Сохранение
        GameProgress gameProgress1 = new GameProgress(98, 35, 25, 123.23);
        GameProgress gameProgress2 = new GameProgress(95, 24, 27, 125.56);
        GameProgress gameProgress3 = new GameProgress(89, 56, 34, 157.45);

        String[] saves = {
                "C:/Users/fende/Games/savegames/save1.dat",
                "C:/Users/fende/Games/savegames/save2.dat",
                "C:/Users/fende/Games/savegames/save3.dat",
        };
        gameProgress1.saveGame(saves[0], gameProgress1);
        gameProgress2.saveGame(saves[1], gameProgress2);
        gameProgress3.saveGame(saves[2], gameProgress3);

        GameProgress.zipFiles("C:/Users/fende/Games/savegames/zip.zip", saves);

        dir.deleteFile(saves[0]);
        dir.deleteFile(saves[1]);
        dir.deleteFile(saves[2]);
    }
}
