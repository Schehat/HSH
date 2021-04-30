import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Gruppe 03
 * @author Schehat
 * U17 Streams
 */
public class DetectZip {

    public static void main(String[] args) throws IOException {
        String error = "error";
        if (args.length != 1) {
            System.out.println(error);
            return;
        }
        FileInputStream fis = null;
        try {
            File file = new File(args[0]);
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println(error);
            return;
        }
        String a = Integer.toHexString(fis.read());
        String b = Integer.toHexString(fis.read());
        fis.close();
        if (!a.equals("50") || !b.equals("4b")) {
            System.out.println("no zip");
            return;
        }
        System.out.println("zip");
    }

}
