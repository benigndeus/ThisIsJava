package sec02.exam05_static_method;

public interface RemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;

	void turnOn();
	void turnOff();
	void setVolume(int volume);

	default void setMute(boolean mute) {
		if(mute)	{ System.out.println("무음 처리합니다."); }
		else		{ System.out.println("무음 해제합니다."); }
	}
	
	// public을 붙이지 않더라도 compile 과정에서 자동으로 붙는다.
	static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
}
