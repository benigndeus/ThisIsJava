package sec05.exam01_treeset;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample2 {
    public static void main(String[] args) {
        TreeSet<Integer> scores = new TreeSet<>();
        scores.add(new Integer(87));
        scores.add(new Integer(98));
        scores.add(75);
        scores.add(95);
        scores.add(80);

        NavigableSet<Integer> descendingSet =  scores.descendingSet();
        for (Integer score : descendingSet) {
            System.out.print(score + " ");
        }
        System.out.println();

        // descendingSet을 두 번 실행하게 되면 내림차순이 유지되는 것이 아닌 오름차순으로 변경된다.
        // 내림차순으로 정리하는 것이 아닌 실행될 Set의 순서를 역순으로 리턴하는 것이다.
        NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
        for (Integer score : ascendingSet) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
}