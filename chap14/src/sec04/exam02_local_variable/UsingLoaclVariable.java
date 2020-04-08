package sec04.exam02_local_variable;

public class UsingLoaclVariable {
    void method(int arg) {
        int localVar = 40;

        /* 로컬 변수와 매개변수는 묵시적으로 final 특성을 가짐 */
        // arg = 10; -> 매개변수 값 변경 불가
        // localVar = 20; -> 지역변수 값 변경 불가


        MyfunctionalInterface fi = () -> {
            System.out.println("arg: " + arg);
            System.out.println("localVar: " + localVar);
        };

        fi.method();
    }
}