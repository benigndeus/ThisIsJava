package verify;

public class Exercise07 {

	public static void main(String[] args) {

		int max = 0;
		int[] array = { 1, 5, 3, 8, 2 };
		
		/* Jiho's Solution */
		for(int index : array)
			if(max < index)
				max = index;
		/*  ****** ******  */
		
		System.out.println("max : " + max);

	}

}
