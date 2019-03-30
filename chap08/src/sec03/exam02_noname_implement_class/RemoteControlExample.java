package sec03.exam02_noname_implement_class;

public class RemoteControlExample {
	
	public static void main(String[] args) {
		
		RemoteControl rc = new RemoteControl() {
			@Override
			public void turnOff() { }
			
			@Override
			public void turnON() { }
			
			@Override
			public void setVolume(int volume) { }
		};
	}
}
