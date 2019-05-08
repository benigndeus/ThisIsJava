package sec03.exam01_try_catch_finally;

public class TryCatchFinallyRuntimeExceptionExample {
        public static void main(String[] args) {
                String data1 = null;
                String data2 = null;

                try{
                        data1 = args[0];
                        data2 = args[1];
                } catch(ArrayIndexOutOfBoundsException e) {
                        System.out.println("Arguments are not enough.");
                        System.out.println("[How to work]");
                        System.out.print("java TryCatchFinallyRuntimeExceptionExample ");
                        System.out.println("value1 value2");
                        return;
                }

                try {
                        int value1 = Integer.parseInt(data1);
                        int value2 = Integer.parseInt(data2);
                        int result = value1 + value2;
                        System.out.println(data1 + " + " + data2 + " = " + result);
                } catch(NumberFormatException e) {
                        System.out.println("Can not change a variable into integer.");
                } finally {
                        System.out.println("Do it again.");
                }
                
        }
}