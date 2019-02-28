package sec06.exam01_array_bylist;

public class ArrayCreateByValueExample2 {

	public static void main(String[] args) {

		int[] scores;
		//scores = { 83, 90 ,87 }; -> 컴파일 에러
		scores = new int[] { 83, 90, 87 };
		
		int sum1 = 0;
		for(int i=0; i<3; i++) {
			sum1 += scores[i];
		}
		
		System.out.println("총합 : " + sum1);
		
		//add({ 83, 90 ,87 }) -> 컴파일 에러
		//int sum2 = add(scores); -> 배열 자체를 매개변수로 사용 가능
		int sum2 = add(new int[] { 83, 90 ,87 });
		
		System.out.println("총합 : " + sum2);
		
		System.out.println("총합 : " + add(scores));

	}
	
	public static int add(int[] scores) {
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum += scores[i];
		}
		return sum;
	}

}
