package sec05.exam02_final_method;

public class Car {
	public int speed;
	
	public void speedUp() { speed += 1; }
	
	public final void stop() {
		System.out.println("Â÷¸¦ ¸ØÃã");
		speed = 0;
	}
}
