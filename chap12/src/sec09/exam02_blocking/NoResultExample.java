import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultExample {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);

		System.out.println("[작업 처리 요청]");
		Runnable runnable = new Runnable() {
		
			@Override
			public void run() {
				int sum = 0;
				for(int i = 1; i <= 10; i++) {
					sum += i;
				}
				System.out.println("[처리 결과] " + sum);
			}
		};

		// 지연 완료 객체 → main 스레드가 해당 작업이 완료될 때까지 정지된다.
		Future future = executorService.submit(runnable);

		try {
			future.get();
			System.out.println("[작업 처리 완료]");
		} catch (InterruptedException e) {
			// 스레드가 intterupt 되었을 때
		} catch (Exception e) {
			// 다른 예외가 발생했을 때
			System.out.println("[예외 발생] " + e.getMessage());
		}

		executorService.shutdown();
	}
}