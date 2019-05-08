package sec04.multi_catch;

public class CatchByExceptionExample {
        public static void main(String[] args) {
                try {
                        String data1 = args[0];
                        String data2 = args[1];
        
                        int value1 = Integer.parseInt(data1);
                        int value2 = Integer.parseInt(data2);
                        int result = value1 + value2;
        
                        System.out.println(data1 + " + " + data2 + " = " + result);
                } catch(ArrayIndexOutOfBoundsException e) {
                        System.out.println("Arguments are not enough.");
                        System.out.println("[How to work]");
                        System.out.print("java CatchByExceptionExample ");
                        System.out.println("value1 value2");
                } catch(NumberFormatException e) {
                        System.out.println("Can not change a variable into integer.");
                } finally {
                        System.out.println("Do it again.");
                }
        }
}