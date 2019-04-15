package sec02.exam01_nestedclass_object;

public class A {
        A() {
                System.out.println("Object A is created.");
        }

        class B {
                int field1;

                B() {
                        System.out.println("Object B is created.");
                }

                void method1() {
			System.out.println("B's method1() is executed.");
                }
        }
}