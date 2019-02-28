package sec08.exam04_overloading;

public class CalculatorExample {

	public static void main(String[] args) {

		Calculator myCalc = new Calculator();
		
		// parameter가 integer이지만 auto-cast 되어 double형으로 적용된다.
		double result1 = myCalc.areaRectangle(10);
		double result2 = myCalc.areaRectangle(10, 20);
		
		System.out.println("정사각형의 넓이 : " + result1);
		System.out.println("직사각형의 넓이 : " + result2);

	}

}
