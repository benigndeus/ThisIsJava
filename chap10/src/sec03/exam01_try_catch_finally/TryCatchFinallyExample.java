package sec03.exam01_try_catch_finally;

public class TryCatchFinallyExample {
        public static void main(String[] args) {
                try {
                        Class clazz = Class.forName("java.lang.String2");
                        System.out.println("The class exists.");
                } catch (ClassNotFoundException e) {
                        System.out.println("There is no the class.");
                } finally {
                        System.out.println("exit.");
                }
        }
}