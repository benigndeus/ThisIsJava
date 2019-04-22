package sec03.exam02_field_method_access;

public class A {
        // Instance Member
        int field1;
        void method1() { }

        // Static Member
        static int field2;
        static void method2() { }

        // Inner Classes
                // Instance Class
        class B {
                void method() {
                        field1 = 10;
                        method1();

                        field2 = 10;
                        method2();
                }
        }

                // Static Class
        static class C {
                void method() {
                        // field1 = 10;
                        // method1();

                        field2 = 10;
                        method2();
                }
        }
}