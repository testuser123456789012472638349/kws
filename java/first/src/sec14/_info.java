package sec14;

import java.io.*;
import java.util.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;


public class _info {
    public static void main(String[] args) throws IOException {
        String path = "C:/Test";
        String fname = "/test1.db";

        try {
            Files.createDirectories(Path.of(path));
        } catch(FileAlreadyExistsException e) {}
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        OutputStream os = new FileOutputStream(path + fname);
        byte a = 10;
        byte b = 20;
        byte c = 30;

        os.write(a);
        os.write(b);
        os.write(c);

        os.flush();
        os.close();

        InputStream is = new FileInputStream(path + fname);
        while (true) {
            int data = is.read();
            if(data == -1) break;
            System.out.println(data);
        }

        is.close();

    }
}

class CharacterConvertStreamExample {
    public static void main(String[] args) throws Exception {
        write("문자 변환 스트림1\n");
        write("문자 변환 스트림2\n");
        write("문자 변환 스트림3\n");
        System.out.println(read());
    }

    static void write(String str) throws Exception {
        String path = "C:/Temp/test1.txt";
        File file = new File(path);

        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        bw.write(str);
        bw.flush();
        bw.close();
    }

    static String read() throws Exception {
        String path = "C:/Temp/test1.txt";
        File file = new File(path);
        FileInputStream fos = new FileInputStream(file);
        Reader reader = new InputStreamReader(fos);

        char[] buffer = new char[100];
        int readCharNum = reader.read(buffer);
        reader.close();
        return new String(buffer, 0, readCharNum);
    }
}


class NonBufferVsBufferExample {
    public static void main(String[] args) throws Exception {
        String ofp1 = NonBufferVsBufferExample.class.getResource("n.png").getPath();

        String tfp1 = "C:/Temp/a.png";
        FileInputStream fis = new FileInputStream(ofp1);
        FileOutputStream fos = new FileOutputStream(tfp1);

        String tfp2 = "C:/Temp/b.png";
        FileInputStream fis2 = new FileInputStream(ofp1);
        FileOutputStream fos2 = new FileOutputStream(tfp2);
        BufferedInputStream bis = new BufferedInputStream(fis2);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);

        long nonBufferTime = copy(fis, fos);
        System.out.println("none buffer:\t" + nonBufferTime + "ns");

        long bufferTime = copy(bis, bos);
        System.out.println("use buffer:\t" + bufferTime + "ns");

        fis.close();
        fos.close();

        bis.close();
        bos.close();
    }

    static int data = -1;
    static long copy(InputStream is, OutputStream os) throws Exception {
        long start = System.nanoTime();
        while(true) {
            data = is.read();
            if(data == -1) break;
            os.write(data);
        }
        os.flush();
        long end = System.nanoTime();
        return (end - start);
    }
}

class ObjectStreamExample {
    public static void main(String[] args) throws Exception {
        writeList();
        BoardList list = readList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Board b : list) {
            System.out.println(b.getBno() + "\t" + b.getTitle() + "\t" + sdf.format(b.getData()));
        }
    }

    static void writeList() throws Exception {
        BoardList list = new BoardList();
        list.add(new Board(0, "title1", new Date()));
        list.add(new Board(1, "title2", new Date()));
        list.add(new Board(2, "title2", new Date()));

        FileOutputStream fos = new FileOutputStream("C:/Temp/board.db");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.flush();
        oos.close();
    }

    // @SuppressWarnings("unchecked")
    static BoardList readList() throws Exception {
        FileInputStream fis = new FileInputStream("C:/Temp/board.db");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // List<Board> list = (List<Board>)ois.readObject();

        Object obj = ois.readObject();
        BoardList list = null;
        if(obj instanceof BoardList) {
            list = (BoardList)obj;
        }
        ois.close();
        return list;
    }
}


class Board implements Serializable {
    private int bno;
    private String title;
    private Date data;

    public Board(int bno, String title, Date data) {
        this.bno = bno;
        this.title = title;
        this.data = data;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

class BoardList extends ArrayList<Board> {}