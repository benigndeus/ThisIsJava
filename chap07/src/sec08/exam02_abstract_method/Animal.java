package sec08.exam02_abstract_method;

public abstract class Animal {
	public String kind;
	
	public void breathe() { System.out.println("숨을 쉽니다."); }
	
	// Abstract Method는 중괄호({}) 없이 작성하며 세미콜론(;)을 붙인다.
	public abstract void sound();
}
