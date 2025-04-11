import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Creator {

    static StringBuilder sb = new StringBuilder();
    private String date = String.format(String.valueOf(new Date()));

    public void createFolder(String addressURL) {
        File dir = new File(addressURL);
        if (dir.mkdir()) {
            sb.append(date).append(" Папка ").append(addressURL).append(" создана\n");
        } else {
            sb.append(date).append(" Папка ").append(addressURL).append(" не создана\n");
        }
    }

    public void createFile(String addressURL) {
        File file = new File(addressURL);
        try {
            if (file.createNewFile()) {
                sb.append(date).append(" Файл ").append(addressURL).append(" создан\n");
            } else {
                sb.append(date).append(" Файл ").append(addressURL).append(" не создан\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteFile(String addressURL) {
        File file = new File(addressURL);
        if (file.delete()) {
            System.out.println("Файл " + file.getName() + " удален");
        } else {
            System.out.println("Файл " + file.getName() + " не удален");
        }
    }
}