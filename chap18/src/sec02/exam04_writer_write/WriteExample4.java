package sec02.exam04_writer_write;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample4 {
    public static void main(String[] args) throws Exception{
        Writer writer = new FileWriter("outputTest.txt");

        String data = "안녕 자바 프로그램";
        // writer.write(data); // 문자열 전체 저장
        writer.write(data, 3, 2); // 지정된 offset부터 지정된 길이 만큼 저장

        writer.flush();
        writer.close();
    }
}
