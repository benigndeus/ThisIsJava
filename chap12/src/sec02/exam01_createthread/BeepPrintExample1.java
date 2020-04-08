import java.awt.Toolkit;

public class BeepPrintExample1 {
	public static void main(String[] args) {
		// Do 'Beep' five times
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i=0; i<5; i++) {
			toolkit.beep();
			try { Thread.sleep(500); } catch(Exception e) { } // 소리가 뭉치지 않게 하기 위해 잠시 쉬어 준다.
		}

		// Do print 'Beep' five times
		for (int i=0; i<5; i++) {
			System.out.println("BEEP");
			try { Thread.sleep(500); } catch(Exception e) { } // 잠시 쉬어 준다.
		}
	}
}