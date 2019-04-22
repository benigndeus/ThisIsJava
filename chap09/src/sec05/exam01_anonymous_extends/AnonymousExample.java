package sec05.exam01_anonymous_extends;

public class AnonymousExample {
        public static void main(String[] args) {
                Anonymous anonymous = new Anonymous();

                anonymous.field.wake();

                anonymous.method1();

                anonymous.method2(new Person() {
                        void study() {
				System.out.println("Study hard.");
			}
	
			@Override
			void wake() {
				System.out.println("Wake up at 8.");
				study();
			}
                });
        }
}