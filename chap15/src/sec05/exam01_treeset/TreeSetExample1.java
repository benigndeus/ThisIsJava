package sec05.exam01_treeset;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample1 {
    public static void main(String[] args) {
        TreeSet<Integer> scores = new TreeSet<>();

        /* 어차피 그냥 숫자를 입력해도 자동박싱이 일어나 Integer 객체로 저장된다. */
        scores.add(new Integer(87));
        scores.add(new Integer(98));
        scores.add(75);
        scores.add(95);
        scores.add(80);

        Integer score = null;

        score = scores.first(); /* 가장 왼쪽에 있는 객체를 리턴 */
        System.out.println("가장 낮은 점수: " + score);

        score = scores.last(); /* 가장 오른쪽에 있는 객체 리턴 */
        System.out.println("가장 높은 점수: " + score + "\n");

        score = scores.lower(new Integer(95)); /* 95에서 바로 작은 객체 */
        System.out.println("95점 아래 점수: " + score);

        score = scores.higher(new Integer(95)); /* 95에서 바로 큰 객체 */
        System.out.println("95점 위의 점수: " + score);

        score = scores.floor(new Integer(95)); /* 95가 있다면 95 리턴, 없다면 95보다 작은 객체 리턴 */
        System.out.println("95점 이거나 바로 아래 점수: " + score);

        score = scores.ceiling(new Integer(85)); /* 85가 있다면 85 리턴, 없다면 85보다 큰 객체 리턴 */
        System.out.println("85점 이거나 바로 위 점수: " + score);

        /* while (!scores.isEmpty()) {
            score = scores.pollFirst(); // TreeSet에서 가장 작은 값이 제거되면서 score에 저장
            System.out.println(score + "(남은 객체 수: " + scores.size() + ")");
        } */

        /* while (!scores.isEmpty()) {
            score = scores.pollLast(); // TreeSet에서 가장 큰 값이 제거되면서 score에 저장
            System.out.println(score + "(남은 객체 수: " + scores.size() + ")");
        } */

        // TreeSet에서 객체를 지우지 않고 유지한다.
        Iterator<Integer> iterator = scores.iterator();
        while (iterator.hasNext()) {
            int s = iterator.next();
            //iterator.remove();   // 읽은 객체를 지우고 싶을 경우 사용. pollFirst()와 비슷한 방법
            System.out.println(s + "(남은 객체 수: " + scores.size() + ")");
        }
    }
}