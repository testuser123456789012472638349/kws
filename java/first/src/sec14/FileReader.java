package sec14;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Administrator\\Desktop\\spring.txt";
        FileInputStream fis = new FileInputStream(path);

        int data = 0;

        while((data = fis.read()) != -1) {
            char c = (char)data;
            System.out.print(c);
        }

        fis.close();

        System.out.println();
        System.out.println("=====================");
        System.out.println();

        FileInputStream fis2 = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis2, "UTF-8");
        while((data = isr.read()) != -1) {
            char c = (char)data;
            System.out.print(c);
        }
    }
}
