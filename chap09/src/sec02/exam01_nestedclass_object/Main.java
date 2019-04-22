package sec02.exam01_nestedclass_object;

public class Main {
        public static void main(String[] args) {
             /* ------------------------------------------------------
                 To construct the Inner Class(instance member class),
                 construct the Outer Class first.
                ------------------------------------------------------ */
                A a = new A();

                A.B b = a.new B();
                b.field1 = 3;
                b.method1();
        
             /* ---------------------------------------------------------
                 When construct a Static Member Class,
                 it is not necessary to construct the Outer Class first.
                 A Static Member does not need an Instance Object.
                --------------------------------------------------------- */
                A.C c = new A.C();
                c.field1 = 3;
                c.method1();
                A.C.field2 = 3;
                A.C.method2();

                a.method();
        }
}