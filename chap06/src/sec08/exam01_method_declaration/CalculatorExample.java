package sec08.exam01_method_declaration;

public class CalculatorExample {

	public static void main(String[] args) {

		Calculator myCalc = new Calculator();
		myCalc.powerOn();
		
		int result1 = myCalc.plus(10, 20);
		System.out.println("result1 : " + result1);
		
		byte x = 10;
		byte y = 4;
		double result2 = myCalc.divide(x, y);
		// Calculator Class에서 자동타입변환이 발생한다.
		// variable x, y가 byte type이나 divide method가 받는 parameter는 integer type이다.
		System.out.println("result2 : " + result2);

	}

}
