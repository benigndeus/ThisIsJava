package sec07.exam01_promotion;

/* 선언된 클래스의 상속 관계
 *    A
 * ┌──┴──┐
 * B     C
 * │     │
 * D     E
 * */

public class PromotionExample {
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b1 = d;
		C c1 = e;
		
		/* A←B←D && A←C←E 이므로 아래와 같이 선언될 수 없다.
		B b2 = c;
		C c2 = d;
		*/
	}
}
