package sec07.exam01_why_default_method;

public interface MyInterface {
        public void method1();

        //public void method2();
        /* ──────────────────────────────────────────── *
         │ 나중에 추가한 method2()는 구현 객체에서      │
         │ 재정의 되어 있지 않기 때문에 구현 객체가     │
         │ 많을 경우 일일이 수정하는 번거로움이 생긴다. │
         │ 따라서 아래와 같이 default method를 사용한다.│
         * ──────────────────────────────────────────── */

         public default void method2() {
                System.out.println("MyInterface-method2() 실행");
         }
}