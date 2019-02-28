package sec10.exam01_static_member;

public class CalculatorExample {

	public static void main(String[] args) {

		double result1 = 10 * 10 * Calculator.pi;
		// Java 자체에 Math 클래스의 pi를 사용하는 방법이 있다. -> Math.pi
		
		int result2 = Calculator.plus(10, 5);
		int result3 = Calculator.minus(10, 5);
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);

	}

}
