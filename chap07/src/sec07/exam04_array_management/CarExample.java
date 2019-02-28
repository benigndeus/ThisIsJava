package sec07.exam04_array_management;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i=1; i<=10; i++) {
			int problemLocation = car.run();
			
			if(problemLocation != 0) {	// Tire가 펑크났을 경우
				System.out.println(car.tires[problemLocation - 1].location +
						"HankookTire로 교체");
				car.tires[problemLocation - 1] = // Tire Type 변환
						new HankookTire(car.tires[problemLocation - 1].location, 15);
			}
			
			System.out.println("---------------------------------");
		}
	}
}
