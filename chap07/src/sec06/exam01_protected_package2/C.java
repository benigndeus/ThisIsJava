package sec06.exam01_protected_package2;

// import sec06.exam01_protected_package1.*;
// package를 import해도 사용할 수 없다. 

public class C {
	public void method() {
		/* protected로 인해 다른 패키지에 있는 A Class를 사용할 수 없다.
		A a = new A();
		a.field = "value";
		a.method();
		*/
	}
}
