package sec02.exam04_default_method;

public interface RemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;

	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// public을 붙이지 않더라도 compile 과정에서 자동으로 붙는다.
	// java 8에서 새로 추가된 기능이다.
	default void setMute(boolean mute) {
		if(mute)	{ System.out.println("무음 처리합니다."); }
		else		{ System.out.println("무음 해제합니다."); }
	}
}
