package sec04.exam01_overriding;

public class Computer extends Calculator {
	/* Override 메소드 재정의 시 Tip
	 * Menu - Source - Override/Implement Methods... 활용
	 * ctrl+Space 시 목록이 뜨는데, 거기서 사용할 항목 선택 */
	@Override
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}
}
