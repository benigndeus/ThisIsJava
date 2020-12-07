package sec02.exam04_writer_write;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample2 {
    public static void main(String[] args) throws Exception{
        Writer writer = new FileWriter("outputTest.txt");
        char[] data = "홍길동".toCharArray();

        writer.write(data);

        writer.flush();
        writer.close();
    }
}
