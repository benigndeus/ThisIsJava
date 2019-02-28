package sec08.exam02_abstract_method;

public class Dog extends Animal {
	public Dog() { this.kind = "포유류"; }
	
	// Abstract Method는 반드시 하위 클래스에서 재정의(Override) 해야 한다.
	@Override
	public void sound() { System.out.println("멍멍"); }
}
