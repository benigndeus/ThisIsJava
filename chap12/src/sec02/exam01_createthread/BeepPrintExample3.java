import java.awt.Toolkit;

public class BeepPrintExample3 {
	public static void main(String[] args) {
		// How 1 (클래스)
		/* Thread thread = new BeepThread(); */

		// How 2 (익명객체)
		Thread thread = new Thread() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i=0; i<5; i++) {
					toolkit.beep();
					try { Thread.sleep(500); } catch(final Exception e) { } // 소리가 뭉치지 않게 하기 위해 잠시 쉬어 준다.
				}
			}	
		};

		// Thread Start
		thread.start();

		// Do print 'Beep' five times
		for (int i=0; i<5; i++) {
			System.out.println("BEEP");
			try { Thread.sleep(500); } catch(Exception e) { } // 잠시 쉬어 준다.
		}
	}
}