package sec08.exam04_overloading;

public class CalculatorExample {

	public static void main(String[] args) {

		Calculator myCalc = new Calculator();
		
		// parameter�� integer������ auto-cast �Ǿ� double������ ����ȴ�.
		double result1 = myCalc.areaRectangle(10);
		double result2 = myCalc.areaRectangle(10, 20);
		
		System.out.println("���簢���� ���� : " + result1);
		System.out.println("���簢���� ���� : " + result2);

	}

}