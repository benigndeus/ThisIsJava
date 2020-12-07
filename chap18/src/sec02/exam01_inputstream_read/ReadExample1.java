package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample1 {
    public static void main(String[] args) throws Exception {
        // 주어진 경로에 test.txt 파일을 생성하고 "abcde" 입력 후 저장
        InputStream is = new FileInputStream("test.txt");
        int readByte;
        while ((readByte = is.read()) != -1) {
            System.out.println(/* (char)을 사용하여 casting 하면 문자로 출력 가능 */readByte);
        }

        is.close(); // stream을 사용했으면 꼭 close()를 해주자.
    }
}
