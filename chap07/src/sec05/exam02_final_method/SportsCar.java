package sec05.exam02_final_method;

public class SportsCar extends Car {
	@Override
	public void speedUp() {
		speed += 10;
	}
	
	/* final method는 오버라이딩 할 수 없다.
	@Override
	public void stop() {
		System.out.println("차를 멈춤");
		speed = 0;
	}
	*/
}
