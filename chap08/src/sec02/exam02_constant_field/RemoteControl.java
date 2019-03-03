package sec02.exam02_constant_field;

public interface RemoteControl {
	// 아래와 같이 public static final을 붙이지 않더라도,
	// 자동으로 상수로 적용됨을 알 수 있다.
	// interface에서는 필드 선언 시 반드시 초기값을 지정한다.
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	/* interface에서는 static 블록을 사용할 수 없다.
	static {
		
	}
	*/
}
