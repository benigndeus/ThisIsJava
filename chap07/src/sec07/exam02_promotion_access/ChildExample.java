package sec07.exam02_promotion_access;

public class ChildExample {
	public static void main(String[] args) {
		Child child = new Child();
		
		Parent parent = child;
		parent.method1();
		parent.method2();
		
		// Type이 Parent이므로 Child에만 정의된 method3()에는 접근할 수 없다.
		// parent.method3();
	}
}
