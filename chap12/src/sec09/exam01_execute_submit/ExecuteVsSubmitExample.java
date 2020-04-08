import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteVsSubmitExample {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		for(int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);

					// 일부로 예외를 발생시켰을 경우
					/* int value = Integer.parseInt("삼"); */
				}
			};
	
			// execute()와 submit()의 차이점을 숙지하고 있을 것.
			// executorService.execute(runnable);
			executorService.submit(runnable);

			// 원래 try-catch 문으로 예외처리를 해야 하지만, main 메소드에서 JVM으로 예외를 throws 해줌.
			Thread.sleep(100);
		}

		executorService.shutdown();
	}
}