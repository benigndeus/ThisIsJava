package sec02.exam03_reader_read;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample3 {
    public static void main(String[] args) throws Exception {
        Reader reader = new FileReader("test.txt");
        int readCharNo;
        char[] cbuf = new char[4];

        readCharNo = reader.read(cbuf, 1, 2);

        for (int i=0; i<cbuf.length; i++) {
            System.out.println(cbuf[i]);
        }
        System.out.println("읽은 바이트 수: " + readCharNo);

        reader.close();
    }
}
