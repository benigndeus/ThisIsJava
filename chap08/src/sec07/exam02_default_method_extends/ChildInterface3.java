package sec07.exam02_default_method_extends;

public interface ChildInterface3 extends ParentInterface {
        
        // 추상 메소드로 부모의 메소드를 재정의 했다.
        // default가 사라진 것을 확인할 수 있다.
        @Override
        void method2();

        public void method3();
}