package sec03.exam04_outter_class_ref;

public class Outter {
        String field = "Outter-field";
        void method() {
                System.out.println("Outter-method");
        }

        class Nested {
                String field = "Nested-field";
                void method() {
                        System.out.println("Nested-method");
                }

                void print() {
                        System.out.println(field);
                        System.out.println(this.field);
                        System.out.println(Outter.this.field);

                        method();
                        this.method();
                        Outter.this.method();
                }
        }
}