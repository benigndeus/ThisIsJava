package sec08.exam01_abstract_class;

public abstract class Phone {
	// Field
	public String owner;
	
	// Constructor
	public Phone(String owner) { this.owner = owner; }
	
	// Method
	public void turnOn()	{ System.out.println("폰 전원을 켭니다."); }
	public void turnOff()	{ System.out.println("폰 전원을 끕니다."); }
}
