package sec08.exam01_method_declaration;

public class Computer {
	
	public int sum1(int[] values) {
		
		int sum = 0;
		for(int i : values) {
			sum += i;
		}
		
		return sum;
		
	}
	
	int sum2(int ... values) {
		
		int sum = 0;
		for(int i : values) {
			sum += i;
		}
		
		return sum;
		
	}

}
