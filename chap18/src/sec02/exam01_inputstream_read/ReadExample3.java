package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample3 {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("test.txt");
        int readByteNo;
        byte[] readBytes = new byte[8];
        
        // read(byte[] b, int off, int len): 매개값으로 주어진 배열의 2번 인덱스부터 길이 3만큼의 바이트를 입력받아 저장한다.
        readByteNo = is.read(readBytes, 2, 3);
        for (int i=0; i<readBytes.length; i++) {
            System.out.println(readBytes[i]);
        }

        System.out.println("읽은 바이트 수: " + readByteNo);
        System.out.print("배열에 저장된 바이트:");
        for (int i=0; i<readBytes.length; i++) System.out.print(" " + (char)readBytes[i]);

        is.close();
    }
}
