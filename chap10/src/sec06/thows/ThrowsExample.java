package sec06.thows;

public class ThrowsExample {
        public static void main(String[] args) {
                try {
                        findClass();
                } catch (Exception e) {
                        System.out.println("Class doesn't exist.");
                }
        }

        public static void findClass() throws ClassNotFoundException {
                Class clazz = Class.forName("java.lang.String2");
        }
}