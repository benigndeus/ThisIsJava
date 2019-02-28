package sec13.exam03_field_method_access.package2;

import sec13.exam03_field_method_access.package1.*;

public class C {
	
	public C() {
		A a = new A();
		
		a.field1 = 1;
		
		// compile error. because of default&private constructor.
		//a.field2 = a.field3 = 1;
		
		a.method1();
		
		// compile error. because of default&private constructor.
		//a.method2();
		//a.method3();
	}

}
