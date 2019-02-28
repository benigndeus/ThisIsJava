package sec10.exam04_singleton;

public class SingletonExample {

	public static void main(String[] args) {

		/* Singleton Class이므로 new 연산자를 사용할 수 없다.
		 Singleton obj1 = new Singleton();
		 Singleton obj2 = new Singleton(); 
		 */
		
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("같은 Singleton Object입니다.");
		} else {
			System.out.println("다른 Singleton Object입니다.");
		}

	}

}
