package sec05.exam01_anonymous_extends;

public class Anonymous {
        // Anonymous child Object
        Person field = new Person() {
                void work() {
                        System.out.println("Go to work.");
                }

                @Override
                void wake() {
                        System.out.println("Wake up at 6.");
                        work();
                }
        };

        void method1() {
                Person localVar = new Person() {
			void walk() {
				System.out.println("Have a walk.");
			}
	
			@Override
			void wake() {
				System.out.println("Wake up at 7.");
				walk();
			}
		};
		
		localVar.wake();
	}
	
	void method2(Person person) {
		person.wake();
	}
}