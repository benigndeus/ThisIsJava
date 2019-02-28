package sec11.exam01_final;

public class PersonExample {

	public static void main(String[] args) {

		Person p1 = new Person("123456-1234567", "계백");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		/* final field의 값은 프로그램 실행 도중 변경할 수 없다.
		p1.nation = "USA";
		p1.ssn = "987654-9876543";
		*/
		
		p1.name = "지호";
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		

	}

}
