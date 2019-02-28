package sec07.exam02_field_initialize;

public class Korean {
	
	String nation = "대한민국";
	String name;
	String ssn;
	
	public Korean(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	
	/* 추천하지 않는 방식의 생성자 작성법이다. 웬만하면 위의 방식으로 작성한다.
	public Korean(String n, String s) {
		name = n;
		ssn = s;
	}
	*/

}
