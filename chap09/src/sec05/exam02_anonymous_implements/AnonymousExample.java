package sec05.exam02_anonymous_implements;

public class AnonymousExample {
        public static void main(String[] args) {
                Anonymous anonymous = new Anonymous();

                anonymous.field.turnOn();
                anonymous.field.turnOff();

                anonymous.method1();

                anonymous.method2(new RemoteControl() {
                        @Override
                        public void turnOn() {
                                System.out.println("Turn on the SmartTV.");
                        }

                        @Override
                        public void turnOff() {
                                System.out.println("Turn off the SmartTV.");
                        }
                });
        }
}