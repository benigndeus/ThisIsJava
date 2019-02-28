package sec08.exam03_method_call;

public class Calculator {
	
	int plus(int x, int y) {
		return x + y;
	}
	
	double divide(int x, int y) {
		return (double)x / y;
	}
	
	double avg(int x, int y) {
		double sum = plus(x, y);
		return sum / 2;
	}
	
	// execute : v, 실행하다.
	void execute() {
		double result = avg(7, 10);
		println("실행결과 : " + result);
	}
	
	void println(String message) {
		System.out.println(message);
	}

}
