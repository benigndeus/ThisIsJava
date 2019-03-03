package sec02.exam03_abstract_method;

public interface RemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	// 아래와 같이 public abstract를 붙이지 않아도 추상 메소드로 자동 인식한다.
	void turnOn();
	void turnOff();
	void setVolume(int volume);
}
