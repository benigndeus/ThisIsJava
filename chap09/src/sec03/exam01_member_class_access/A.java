package sec03.exam01_member_class_access;

public class A {
        // Instance Fields
        B field1 = new B();
        C field2 = new C();

        // Instance Method's Local Variables
        void method1() {
                B var1 = new B();
                C var2 = new C();
        }

        // Static Fields
        // static B field3 = new B();
        static C field4 = new C();

        // Static Method's Local Variables
        static void method2() {
                // B var1 = new B();
                C var2 = new C();
        }

        // Inner Classes
        class B { }
        static class C { }
}