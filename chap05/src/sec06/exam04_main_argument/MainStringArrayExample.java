package sec06.exam04_main_argument;

public class MainStringArrayExample {

	public static void main(String[] args) {

		// System.out.println("배열의 길이 : " + args.length);
		// 명령 프롬프트에서 문자열을 바로 대입하거나
		// Run Configurations에서 Arguments를 대입하여 실행할 수 있다.
		
		if(args.length != 2) {
			System.out.println("프로그램의 사용법");
			System.out.println("java sec06.exam04_main_argument.MainStringArrayExample num1 num2");
			System.exit(0);
		}
		
		String strNum1 = args[0];
		String strNum2 = args[1];
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);

	}

}
