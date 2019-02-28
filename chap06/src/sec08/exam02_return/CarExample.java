package sec08.exam02_return;

public class CarExample {

	public static void main(String[] args) {

		Car myCar = new Car();
		
		// 연료 주입
		myCar.setGas(5);
		
		// 연료 확인
		boolean gasState = myCar.isLeftGas();
		if(gasState) {
			System.out.println("출발합니다.");
			myCar.run();
		}
		
		if(myCar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입하세요.");
		}

	}

}
