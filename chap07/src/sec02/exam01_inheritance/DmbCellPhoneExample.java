package sec02.exam01_inheritance;

public class DmbCellPhoneExample {
	public static void main(String[] args) {
		// Create DbmCellPhone Object
		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
		
		// inherited Fields from CellPhone Class
		System.out.println("모델 : " + dmbCellPhone.model);
		System.out.println("색상 : " + dmbCellPhone.color);
		
		// Field of DmbCellPhone Class
		System.out.println("채널 : " + dmbCellPhone.channel);
		
		// Call inherited Methods of CellPhone Class
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요");
		dmbCellPhone.receiveVoice("안녕하세요! 저는 홍길동인데요");
		dmbCellPhone.sendVoice("아~ 예 안녕하세요");
		dmbCellPhone.hangUp();
		
		// Call Methods of DmbCellPhone Class
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(12);
		dmbCellPhone.turnOffDmb();
	}
}
