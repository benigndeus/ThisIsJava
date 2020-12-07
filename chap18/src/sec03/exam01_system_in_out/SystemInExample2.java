package sec03.exam01_system_in_out;

import java.io.InputStream;

/* 안타깝게도 이 예제는 적어도 vscode에서는 제대로 작동하지 않는다.
 * InputStream은 오직 1 byte만 읽어들이므로 2 또는 3 byte인 한글은 인식하지 못한다.
 * 참고: https://st-lab.tistory.com/41 */
public class SystemInExample2 {
    public static void main(String[] args) throws Exception {
        InputStream is = System.in;

        byte[] datas = new byte[100];

        System.out.print("이름: ");
        int nameBytes = is.read(datas);
        String name = new String(datas, 0, nameBytes-2);

        System.out.print("하고 싶은 말: ");
        int commentBytes = is.read(datas);
        String comment = new String(datas, 0, commentBytes-2);

        System.out.println("입력한 이름: " + name);
        System.out.println("입력한 하고 싶은 말: " + comment);

        is.close();
    }
}
