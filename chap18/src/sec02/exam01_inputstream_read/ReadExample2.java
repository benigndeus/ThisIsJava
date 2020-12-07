package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample2 {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("test.txt");
        int readByteNo;
        byte[] readBytes = new byte[3];
        String data = "";

        // read(byte[] a): a 배열의 길이 만큼 읽는다. 길이보다 적은 byte를 읽을 경우에는 이전에 입력된 값이 저장되어 있다.
        while ((readByteNo = is.read(readBytes)) != -1) {
            data += new String(readBytes, 0, readByteNo);
        }
        System.out.println(data);

        is.close();
    }
}
