package sec07.exam02_default_method_extends;

public interface ChildInterface2 extends ParentInterface {
        
        // interface이기 때문에 default를 생략하면 안 된다.
        @Override
        default void method2() {
                System.out.println("ChildInterface2-method2()");
        }

        public void method3();
}