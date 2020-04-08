package sec02.exam01_arraylist;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("홀길동", "신용권", "감자바");
        for(String name : list1) {
            System.out.println(name);
        }

        /* 정석은 asList(new Integer(1), new Integer(2), new Integer(3)); */
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        for(/* Integer */ int value : list2) {
            System.out.println(value);
        }
    }
}