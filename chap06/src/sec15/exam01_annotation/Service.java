package sec15.exam01_annotation;

public class Service {
	
	@PrintAnnotation() // 괄호는 없어도 된다.
	public void method1() {
		System.out.println("실행 내용1");
	}
	
	@PrintAnnotation("*") // value default "-" 대신에 "*"를 대입.
	public void method2() {
		System.out.println("실행 내용2");
	}
	
	@PrintAnnotation(value="#", number=20) // value default "-" 대신에 "#"를, number default 15 대신에 20.
	public void method3() {
		System.out.println("실행 내용3");
	}
	

}
