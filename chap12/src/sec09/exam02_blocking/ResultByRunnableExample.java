import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByRunnableExample {
	public static void main(String[] args) {
		/* Runnable 객체는 리턴값이 없지만 해당 내용은 외부 객체를 사용하여
		 * 유의미한 코딩이 되도록 작성하는 방법의 예시다. */

		ExecutorService executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);

		System.out.println("[작업 처리 요청]");

		class Task implements Runnable {
			Result result;

			Task(Result result) { // 생성자
				this.result = result;
			}

			@Override
			public void run() {
				int sum = 0;
				for (int i = 1; i <= 10; i++) {
					sum += i;
				}
				result.addValue(sum);
			}
		};

		// 공유 객체(외부 객체)
		Result result = new Result();
		// 두 개의 작업을 정의
		Runnable task1 = new Task(result);
		Runnable task2 = new Task(result);

		Future<Result> future1 = executorService.submit(task1, result);
		Future<Result> future2 = executorService.submit(task2, result);

		try {
			result = future1.get();
			result = future2.get();
			System.out.println("[처리 결과] " + result.accumValue);
			System.out.println("[작업 처리 완료]");
		} catch (Exception e) {
			System.out.println("[실행 예외 발생] " + e.getMessage());
		}
		
		executorService.shutdown();
	}
}

class Result {
	int accumValue;
	synchronized void addValue(int value) {
		accumValue += value;
	}
}