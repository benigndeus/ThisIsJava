package sec03.exam03_local_class_access;

public class Outter {
        // Before Java7
        public void method1(final int arg) {
		final int localVariable = 1;
		// arg = 100; (x)
		// localVariable = 100 (x)
		class Inner {
			void method() {
			     /* -----------------------------------------------------------
				 When 'final' is attached to a variable,
				 the variable belongs to the local variable of the method.
				----------------------------------------------------------- */
				// int arg = 10;
				// int localVariable = 1;
				int result = arg + localVariable;
			}
		}
	}
	
	// After Java8
	public void method2(int arg) {
		int localVariable = 1;
		// arg = 100; (x)
		// localVariable = 100 (x)
		class Inner {
		     /* -------------------------------------------------
			 If 'final' is not attached to a variable,
			 the variable belongs to the field in the class.
			 And the variable has the property of 'final'.
			------------------------------------------------- */
			// int arg = 10;
			// int localVariable = 1;
			void method() {
				int result = arg + localVariable;
			}
		}
	}
}