package sec03.exam03_return;

public class MyFunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunctionalInterface fi;

        /* 실행문 2개 */
        fi = (x, y) -> {
            int result = x + y;
            return result;
        };
        System.out.println(fi.method(1, 2));

        /* 리턴문만 있더라도 중괄호 생략이 안 되는데? */
        fi = (x, y) -> { return x + y; };
        System.out.println(fi.method(3, 4));

        /* 구현하고자 하는 메소드가 리턴문만 가진다면 중괄호와 'return'을 생략 가능 */
        fi = (x, y) -> x + y;
        System.out.println(fi.method(5, 6));

        /* 리턴값이 있는 메소드만으로도 호출 가능 */
        fi = (x, y) -> sum(x, y);
        System.out.println(fi.method(7, 8));
    }

    public static int sum(int x, int y) {
        return x + y;
    }
}