package sec03.exam01_no_argument_no_return;

public class MyFunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunctionalInterface fi;

        /* 실행문 2개 */
        fi = () -> {
            String str = "method call 1";
            System.out.println(str);
        };
        fi.method();

        /* 실행문 1개 */
        fi = () -> { System.out.println("method call 2"); };
        fi.method();

        /* 실행문이 하나라면 중괄호 생략 가능 */
        fi = () -> System.out.println("method call 3");
        fi.method();

        /* 익명 객체 선언하여 사용하는 방법 */
        fi = new MyFunctionalInterface(){
            @Override
            public void method() {
                System.out.println("method call 4");
            }
        };
        fi.method();
    }
}