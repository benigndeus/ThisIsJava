package sec07.exam06_casting;

public class ChildExample {
	public static void main(String[] args) {
		Parent parent = new Child();
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		
		/* parent의 자료형이 Parent이므로 본체가 Child라고 하더라도,
		 * Child의 field를 사용할 수 없다.
		parent.field2 = "data2";
		parent.method3();
		*/
		
		// 아래와 같이 parent를 Casting 하고 사용하면 Child의 field 및 method 사용 가능.
		Child child = (Child) parent;
		child.field2 = "data2";
		child.method3();
	}
}
