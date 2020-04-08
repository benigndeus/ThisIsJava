package sec03.exam01_hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {
    public static void main(String[] args) {
        Set<Member> set = new HashSet<>();

        set.add(new Member("홍길동", 30)); // A객체
        set.add(new Member("홍길동", 30)); // B객체
        /* A와 B는 분명 다른 객체이지만, 논리적으로 동등한 객체이다(동등객체).
           Set은 암시적으로 동등객체도 제외하고 저장한다. */

        System.out.println("총 객체 수: " + set.size());
    }
}