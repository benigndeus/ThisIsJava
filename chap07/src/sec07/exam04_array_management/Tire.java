package sec07.exam04_array_management;

public class Tire {
	public int maxRotation;			// �ִ� ȸ����(Ÿ�̾� ����)
	public int accumulatedRotation;	// ���� ȸ����
	public String location;			// Ÿ�̾� ��ġ
	
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	public boolean roll() {
		++accumulatedRotation;	// ���� ȸ���� ����
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " Tire ���� : " +
					(maxRotation - accumulatedRotation) + "ȸ");
			return true;
		} else {
			System.out.println("*** " + location + " ��ũ ***");
			return false;
		}
	}
}