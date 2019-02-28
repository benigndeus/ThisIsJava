package sec07.exam01_constructor_declaration;

public class CarExample {

	public static void main(String[] args) {

		//Car myCar = new Car();
		//위와 같이 할 경우 매개변수로 인해 컴파일 에러 발생
		Car myCar = new Car("검정", 3000);

	}

}
