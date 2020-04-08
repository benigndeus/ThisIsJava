import java.awt.Toolkit;

public class BeepThread extends Thread {
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i=0; i<5; i++) {
			toolkit.beep();
			try { Thread.sleep(500); } catch(final Exception e) { } // 소리가 뭉치지 않게 하기 위해 잠시 쉬어 준다.
		}
	}	
}