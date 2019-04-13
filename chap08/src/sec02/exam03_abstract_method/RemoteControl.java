package sec02.exam03_abstract_method;

public interface RemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	/* It is automatically recognized as abstract method
	even if 'public abstract' is not attached as below. */
	void turnOn();
	void turnOff();
	void setVolume(int volume);
}
