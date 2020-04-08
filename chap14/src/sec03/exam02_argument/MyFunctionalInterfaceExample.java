package sec03.exam02_argument;

public class MyFunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunctionalInterface fi;

        /* 실행문 2개 */
        fi = (x) -> {
            int result = x * 5;
            System.out.println(result);
        };
        fi.method(1);

        /* 실행문 1개 중괄호 생략 가능 */
        fi = (x) -> System.out.println(x * 5);
        fi.method(2);

        /* 매개변수가 하나라면 괄호 생략 가능 */
        fi = x -> System.out.println(x * 5);
        fi.method(3);
    }
}