public class A {
        A() { System.out.println("Object A is created."); }

        class B {
                int field1;

                B() { System.out.println("Object B is created."); }

                void method1() { System.out.println("B's method1() is executed."); }
        }

        static class C {
                int field1;
                static int field2;

                C() { System.out.println("Object C is created."); }

                void method1() { System.out.println("C's method1() is executed."); }
                static void method2() { System.out.println("C's method2() is executed."); }
        }

        void method() {
                class D {
                        int field1;

                        D() { System.out.println("Object D is created."); }

                        void method1() {
                                System.out.println("d.field1 = " + this.field1 + ", D's method1() is executed.");
                        }

                        // A Local Class cannot have a Static Member.
                        // static int field2;
                        // static void method2() {}
                }

                D d = new D();
                d.field1 = 3;
                d.method1();
        }
}