package sec04.exam01_field;

public class UsingThis {
    public int outterField = 10;

    public class Inner {
        int innerField = 20;
        
        void method() {
            MyfunctionalInterface fi = () -> {
                System.out.println("outterField: " + outterField);
                System.out.println("outterField: " + UsingThis.this.outterField + " (using this)\n");

                System.out.println("innerField: " + innerField);
                System.out.println("innerField: " + this.innerField + " (using this)");
            };
            fi.method();
        }
    }
}