package sec02.exam01_arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(); // 기본적으로 9번 인덱스까지 임의로 생성함

        list.add("Java"); // 0번 인덱스에 저장됨
        list.add("JDBC"); // 1번 인덱스에 저장됨
        list.add("Servlet/JSP"); // 2번 인덱스에 저장됨
        list.add(2, "Database"); // 2번 인덱스에 있던 것이 3번 인덱스로 옮겨지고, 2번 인덱스에 삽입
        list.add("iBATIS"); // 4번 인덱스에 저장됨

        int size = list.size();
        System.out.println("총 객체 수: " + size);
        System.out.println();

        String skill = list.get(2);
        System.out.println("2: " + skill);
        System.out.println();

        for(int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(i + ": " + str);
        }
        System.out.println();

        list.remove(2);
        list.remove(2);
        list.remove("iBATIS");
        for(int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(i + ": " + str);
        }
    }
}