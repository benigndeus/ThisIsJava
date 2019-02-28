package sec03.exam01_parent_constructor_call;

public class Student extends People {
	// Field
	public int studentNo;
	
	// Constructor
	public Student(String name, String ssn, int studentNo) {
		// 하위 클래스의 생성자에서 부모 생성자의 호출이 첫 줄로 와야 한다(super).
		super(name, ssn); 
		this.studentNo = studentNo;
		System.out.println("Student 객체 생성");
	}
}
