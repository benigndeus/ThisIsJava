package sec14.exam01_getter_setter;

public class Car {
	
	private int speed;
	private boolean stop;
	/* menu - Source - Generate Getter and Setters... */
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if(speed < 0) {
			this.speed = 0;
			return;
		} else {
			this.speed = speed;
		}
	}
	
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
		if(stop == true) {
			speed = 0;
		}
	}
	
	// 위 기능을 사용한 후에 getter&setter를 원하는 코드로 변경하면 된다.
	
	/* eclipse에 getter&setter를 자동으로 생성해주는 기능이 있다.
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if(speed < 0) {
			this.speed = 0;
			return;
		} else {
			this.speed = speed;
		}
	}
	
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	*/
	
}
