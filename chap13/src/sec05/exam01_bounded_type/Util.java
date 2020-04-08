package sec05.exam01_bounded_type;

public class Util {
    /* 제한된 타입 파라미터
     * T에는 Number 클래스의 자식 타입만 올 수 있다. */
    public static <T extends Number> int compare(T t1, T t2) {
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();

        /* v1 < v2 -> -1
         * v1 > v2 -> +1 */
        return Double.compare(v1, v2);
    }
}