package sec04.exam01_overriding;

public class ComputerExample {
	public static void main(String[] args) {
		int r = 10;
		
		Calculator calculator = new Calculator();
		System.out.println("원면적 : " + calculator.areaCircle(r));
		System.out.println();
		
		Computer compuer = new Computer();
		System.out.println("더 정확한 원면적 : " + compuer.areaCircle(r));
	}
}
