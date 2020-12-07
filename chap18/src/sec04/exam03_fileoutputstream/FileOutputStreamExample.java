package sec04.exam03_fileoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamExample {
    public static void main(String[] args) throws Exception {
        String originalFileName = "C:/Users/user/benigndeus/Projects/Chapter18/src/sec04/exam03_fileoutputstream/FileOutputStreamExample.java";
        String targetFileName = "C:/Temp/minion.jpg";

        FileInputStream fis = new FileInputStream(originalFileName);
        FileOutputStream fos = new FileOutputStream(targetFileName);

        int readByteNo;
        byte[] readBytes = new byte[100];
        while ((readByteNo = fis.read(readBytes)) > 0) {
            fos.write(readBytes, 0, readByteNo);
            System.out.println("readByteNo: " + readByteNo);
        }

        fos.flush();
        fis.close();
        fos.close();

        System.out.println("복사가 잘 되었습니다.");
    }
}
