package sec08.exam01_abstract_class;

public class PhoneExample {
	public static void main(String[] args) {
		// abstract class 이므로 실행 클래스에서 직접적으로 생성할 수 없다.
		//Phone phone = new Phone("홍길동");
		
		SmartPhone smartPhone = new SmartPhone("홍길동");
		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();
	}
}
