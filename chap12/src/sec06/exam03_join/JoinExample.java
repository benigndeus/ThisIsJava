public class JoinExample {
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();

		/* 여기서 main thread가 잠시 멈춰 줘야 sumThread가 역할을 제대로 한다. */
		try {
			sumThread.join();
		} catch (InterruptedException e) { }
		
		System.out.println(sumThread.getSum());
	}
}