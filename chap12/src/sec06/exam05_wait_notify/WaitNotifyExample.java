public class WaitNotifyExample {
	public static void main(String[] args) {
		DataBox dataBox = new DataBox();

		ProduceThread producerThread = new ProduceThread(dataBox);
		ConsumerThread consumerThread = new ConsumerThread(dataBox);

		producerThread.start();
		consumerThread.start();
	}
}