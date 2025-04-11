import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGame(String addressURL, GameProgress gameProgress) {

        try (FileOutputStream fos = new FileOutputStream(addressURL);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String addressArchive, String[] saves) {
        int x = 0;
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(addressArchive))) {
            for (String save : saves) {
                x++;
                FileInputStream fis = new FileInputStream(save);
                ZipEntry entry = new ZipEntry("save" + x + ".dat");
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
