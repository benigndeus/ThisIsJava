public class ProduceThread extends Thread {
	private DataBox dataBox;

	public ProduceThread(DataBox dataBox) {
		this.setName("ProducerThread");
		this.dataBox = dataBox;
	}

	@Override
	public void run() {
		for(int i=1; i<=3; i++) {
			String data = "Data-" + i;
			dataBox.setData(data);
		}
	}
}