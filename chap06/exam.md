# 6장 클래스
## 확인문제

1. 객체와 클래스에 대한 설명으로 틀린 것은 무엇입니까?  
  ① 클래스는 객체를 생성하기 위한 설계도(청사진)와 같은 것이다.  
  ② new 연산자로 클래스의 생성자를 호출함으로써 객체가 생성된다.  
  ③ 하나의 클래스로 하나의 객체만 생성할 수 있다.  
  ④ 객체는 클래스의 인스턴스이다.  

> 답 : 3  
하나의 클래스로 여러 개의 객체를 생성할 수 있다.  

---
2. 클래스의 구성 멤버가 아닌 것은 무엇입니까?  
  ① 필드(field)  
  ② 생성자(constructor)  
  ③ 메소드(method)  
  ④ 로컬 변수(local variable)  

> 답 : 4  
로컬 변수는 클래스의 멤버가 될 수 없다.  

---
3. 필드, 생성자, 메소드에 대한 설명으로 틀린 것은 무엇입니까?  
  ① 필드는 객체의 데이터를 저장한다.  
  ② 생성자는 객체의 초기화를 담당한다.  
  ③ 메소드는 객체의 동작 부분으로, 실행 코드를 가지고 있는 블록이다.  
  ④ 클래스는 반드시 필드와 메소드를 가져야 한다.  

> 답 : 4  
클래스는 생성자를 반드시 가져야 한다. 실제로 생성자를 코딩하지 않더라도 컴파일러가 생성자를 임의로 생성한다.  

---
4. 필드에 대한 설명으로 틀린 것은 무엇입니까?  
  ① 필드는 메소드에서 사용할 수 없다.  
  ② 인스턴스 필드 초기화는 생성자에서 할 수 있다.  
  ③ 필드는 반드시 생성자 선언 전에 선언되어야 한다.  
  ④ 필드는 초기값을 주지 않더라도 기본값으로 자동 초기화 된다.  

> 답 : 3  
필드는 생성자, 메소드의 순서에 상관없이 선언할 수 있다.  

---
5. 생성자에 대한 설명으로 틀린 것은 무엇입니까?
  ① 객체를 생성하려면 생성자 호출이 반드시 필요한 것은 아니다.  
  ② 생성자는 다른 생성자를 호출하기 위해 this()를 사용할 수 있다.  
  ③ 생성자가 선언되지 않으면 컴파일러가 기본 생성자를 추가한다.  
  ④ 외부에서 객체를 생성할 수 없도록 생성자에 private 접근 제한자를 붙일 수 있다.  

> 답 : 1  
객체를 생성하기 위해서는 반드시 생성자 호출이 필요하다. 단 static variable은 생성자 호출 없이 class에 접근할 수 있다.  

---
6. 메소드에 대한 설명으로 틀린 것은 무엇입니까?  
  ① 리턴값이 없는 메소드는 리턴 타입을 void로 해야 한다.  
  ② 리턴 타입이 있는 메소드는 리턴값을 지정하기 위해 반드시 return문이 있어야 한다.  
  ③ 매개값의 수를 모를 경우 "..."를 이용해서 매개 변수를 선언할 수 있다.  
  ④ 메소드의 이름은 중복해서 선언할 수 없다.  

> 답 : 4  
메소드의 이름은 중복해서 선언할 수 있다. Method Overloading.  

---
7. 메소드 오버로딩에 대한 설명으로 틀린 것은 무엇입니까?  
  ① 동일한 이름의 메소드를 여러 개 선언하는 것을 말한다.  
  ② 반드시 리턴 타입이 달라야 한다.  
  ③ 매개 변수의 타입, 수, 순서를 다르게 해야 한다.  
  ④ 매개값의 타입 및 수에 따라 호출될 메소드가 선택된다.  

> 답 : 2  
메소드의 리턴 타입은 Method Overloading과 관계없다.  

---
8. 인스턴스 멤버와 정적 멤버에 대한 설명으로 틀린 것은 무엇입니까?  
  ① 정적 멤버는 static으로 선언된 필드와 메소드를 말한다.  
  ② 인스턴스 필드는 생성자 및 정적 블록에서 초기화될 수 있다.  
  ③ 정적 필드와 정적 메소드는 객체 생성 없이 클래스를 통해 접근할 수 있다.  
  ④ 인스턴스 필드와 메소드는 객체를 생성하고 사용해야 한다.  

> 답 : 2
정적 블록(static {...})에서는 인스턴스 필드를 초기화할 수 없다.  

---
9. final 필드와 상수(static final)에 대한 설명으로 틀린 것은 무엇입니까?  
  ① final 필드와 상수는 초기값이 저장되면 값을 변경할 수 없다.  
  ② final 필드와 상수는 생성자에서 초기화될 수 있다.  
  ③ 상수의 이름은 대문자로 작성하는 것이 관례이다.  
  ④ 상수는 객체 생성 없이 클래스를 통해 사용할 수 있다.  

> 답 : 2  
상수는 생성자에서 초기화될 수 없다.  

---
10. 패키지에 대한 설명으로 틀린 것은 무엇입니까?  
  ① 패키지는 클래스드을 그룹화시키는 기능을 한다.  
  ② 클래스가 패키지에 소속되려면 패키지 선언을 반드시 해야 한다.  
  ③ import문은 다른 패키지의 클래스를 사용할 때 필요하다.  
  ④ mycompany 패키지에 소속된 클래스는 yourcompany에 옮겨 놓아도 동작한다.  

> 답 : 4  
yourcompany에 옮길 경우 패키지 선언을 수정해야 한다.  

---
11. 접근 제한에 대한 설명으로 틀린 것은 무엇입니까?  
  ① 접근 제한자는 클래스, 필드, 생성자, 메소드의 사용을 제한한다.  
  ② public 접근 제한은 아무런 제한 없이 해당 요소를 사용할 수 있게 한다.  
  ③ default 접근 제한은 해당 클래스 내부에서만 사용을 허가한다.  
  ④ 외부에서 접근하지 못하도록 하려면 private 접근 제한을 해야 한다.  

> 답 : 3  
default 접근 제한은 해당 패키지 내부에서 제한 없이 사용할 수 있게 한다. 여기서 설명하는 내용은 private에 해당한다.  

---
12. 다음 클래스에서 해당 멤버가 필드, 생성자, 메소드 중 어떤 것인지 빈칸을 채우세요.  
```java
public class Member {
	private String name;					// Field
	public Member(String name) {...}		// Constructor
	public void setName(String name) {...}	// Method
}
```

---
13. 현실 세계의 회원을 Member 클래스로 모델링하려고 합니다. 회원의 데이터로는 이름, 아이디, 패스워드, 나이가 있습니다. 이 데이터들을 가지는 Member 클래스를 선언해보세요.  

|데이터 이름|필드 이름|타입|
|-----------|---------|----|
|이름|name|문자열|
|아이디|id|문자열|
|패스워드|password|문자열|
|나이|age|정수|

【Member.java】
```java
public class Member {
    String name;
    String id;
    String password;
    int age;
}
```

---
14. 위에서 작성한 Member 클래스에 생성자를 추가하려고 합니다. 다음과 같이 Member 객체를 생성할 때 name 필드와 id 필드를 외부에서 받은 값으로 초기화하려면 생성자를 어떻게 선언해야 합니까?  

```java
Member user1 = new Member("홍길동", "hong");
Member user2 = new Member("강자바", "java");
```

【Member.java】
```java
public class Member {
	String name;
	String id;
	String password;
	int age;

	Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
}
```

---
15. MemberService 클래스에 login() 메소드와 logout() 메소드를 선언하려고 합니다. login() 메소드를 호출할 떄에는 매개값으로 id와 password를 제공하고, logout() 메소드는 id만 매개값으로 제공합니다. MemberService 클래스와 login(), logout() 메소드를 선언해보세요.  

> ① login() 메소드는 매개값 id가 "hong", 매개값 password가 "12345"일 경우에만 true로 리턴하고 그 이외의 값일 경우에는 false로 리턴하도록 하세요.  
② logout() 메소드의 내용은 "로그아웃 되었습니다."가 출력되도록 하세요.  

|리턴 타입|메소드 이름|매개 변수(타입)|
|---------|-----------|---------------|
|boolean|login|id(String), password(String)|
|void|logout|id(String)|

【MemberService.java】  
```java
public class MemberService {
	String id = "hong";
	String password = "12345";

	boolean login(String id, String password) {
		if(this.id==id && this.password==password)	{ return true; }
		else						{ return false; }
	}

	void logout(String id) {
		if(this.id==id) { System.out.println("로그아웃 되었습니다."); }
	}
}
```

> String은 equals() Method를 사용하여 그 내용을 비교한다. 다음은 개선한 답안이다. 강의에서는 logout() 에서 id 비교를 하지 않으나 이게 문제에서 원하는 방향인 것 같아서 유지했다.  
```java
public class MemberService {
	boolean login(String id, String password) {
		if(id.equals("hong") && password.equals("12345"))	{ return true; }
		else							{ return false; }
	}

	void logout(String id) {
    	if(this.id==id) { System.out.println("로그아웃 되었습니다."); }
    }
}
```

【MemberServiceExample.java】  
```java
public class MemberServiceExample {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
	boolean result = memberService.login("hong", "12345");

	if(result) {
		System.out.println("로그인 되었습니다.");
		memberService.logout("hong");
	} else {
		System.out.println("id 또는 password가 올바르지 않습니다.");
	}
    }
}
```

---
16. PrintExample 클래스에서 Printer 객체를 생성하고 println() 메소드를 호출해서 매개값을 콘솔에 출력하려고 합니다. println() 메소드의 매개값으로는 int, boolean, double, String 값을 줄 수 있습니다. Printer 클래스에서 println() 메소드를 선언해보세요.  

【Printer.java】  
```java
public class Printer {
	void println(int parameter)	{ System.out.println(parameter); }
	void println(boolean parameter)	{ System.out.println(parameter); }
	void println(double parameter)	{ System.out.println(parameter); }
	void println(String parameter)	{ System.out.println(parameter); }
}
```

【PrinterExample.java】  
```java
public class PrinterExample {
	public static void main(String[] args) {
		Printer printer = new Printer();
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");
	}
}
```

---
17. 16번 문제에서 Printer 객체를 생성하고 println() 메소드를 생성했습니다. Printer 객체를 생성하지 않고 PrinterExample 클래스에서 다음과 같이 호출하려면 Printer 클래스를 어떻게 수정하면 될까요?  

【Printer.java】  
```java
public class Printer {
	static void println(int value)		{ System.out.println(paramter); }
	static void println(boolean value)	{ System.out.println(paramter); }
	static void println(int value)		{ System.out.println(paramter); }
	static void println(String value)	{ System.out.println(paramter); }
}
```

【PrinterExample.java】  
```java
public class PrinterExample {
	public static void main(String[] args) {
		Printer.println(10);
		Printer.println(true);
		Printer.println(5.7);
		Printer.println("홍길동");
	}
}
```

---
18. ShopService 객체를 실글톤으로 만들고 싶습니다. ShopServiceExample 클래스에서 ShopService의 getInstance() 메소드로 싱글톤을 얻을 수 있도록 ShopService 클래스를 작성해보세요.  

【ShopService.java】  
```java
public class ShopService {
	private static ShopService singleton = new ShopService();
	private ShopService() {}
	static ShopService getInstance() { return singleton; }
}
```

【ShopServiceExample.java】  
```java
public class ShopServiceExample {
	public static void main(String[] args) {
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();

		if(obj1 == obj2)	{ System.out.println("같은 ShopService 객체입니다."); }
		else			{ System.out.println("다른 ShopService 객체입니다."); }
	}
}
```

---
19. 은행 계좌 객체인 Account 객체는 잔고(balance) 필드를 가지고 있습니다. balance 필드는 음수값이 될 수 없고, 최대 백만 원까지만 저장할 수 있습니다. 외부에서 balance 필드를 마음대로 변경하지 못하도록 하고, 0 <= balance <= 1,000,000 범위만 가질 수 있도록 Account 클래스를 작성해보세요.  

> ① Setter와 Getter를 이용하세요.  
② 0과 1,000,000은 MIN\_BALANCE와 MAX\_BALANCE 상수를 선언해서 이용하세요.  
③ Setter의 매개값이 음수이거나 백만 원을 초과하면 현재 balance 값을 유지하세요.  

【Account.java】  
```java
public class Account {
	private int balance;
	static final MIN_BALANCE = 0;
	static final MAX_BALANCE = 1000000;

	public int getBalance() { reuturn this.balance; }

	public void setBalance(int balance) {
		if	(balance < MIN_BALANCE)	{ this.balance = MIN_BALANCE; }
		else if	(balance > MAX_BALANCE)	{ this.balance = MAX_BALANCE; }
		else				{ this.balance = balance; }
	}
}
```

> 문제 해석을 바보같이 했다. 상수에 자료형도 안 적었다. 다음은 강의에서 진행한 코드이다.  

```java
public class Account {
	private int balance;
	public static final int MIN_BALANCE = 0;
	public static final int MAX_BALANCE = 1000000;
	
	public int getBalance() { return this.balance; }
	
	public void setBalance(int balance) {
		if(balance < Account.MIN_BALANCE || balance > Account.MAX_BALANCE) { return; }
		else {  this.balance = balance; }
	}
}
```

【AccountExample.java】
```java
public class AccountExample {
	public static void main(String[] args) {
		Account account = new Account();

		account.setBalance(10000);
		System.out.println("현재 잔고 : " + account.getBalance());
		account.setBalance(-100);
		System.out.println("현재 잔고 : " + account.getBalance());
		account.setBalance(2000000);
		System.out.println("현재 잔고 : " + account.getBalance());
		account.setBalance(300000);
		System.out.println("현재 잔고 : " + account.getBalance());
	}
}
```

---
20. 다음은 키보드로부터 계좌 정보를 입력받아서, 계좌를 관리하는 프로그램입니다. 실행 결과를 보고, 알맞게 BankApplication 클래스의 메소드를 작성해보세요.  

【계좌생성 실행결과】 ①  
```output
--------------------------------------------------------
1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료
--------------------------------------------------------
선택> 1
--------------
계좌생성
--------------
계좌번호 : 111-111
계좌주 : 홍길동
초기입금액 : 10000
결과 : 계좌가 생성되었습니다.
--------------------------------------------------------
1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료
--------------------------------------------------------
선택> 1
--------------
계좌생성
--------------
계좌번호 : 111-222
계좌주 : 강자바
초기입금액 : 20000
결과 : 계좌가 생성되었습니다.
```

【계좌목록 실행결과】 ②  
```output
--------------------------------------------------------
1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료
--------------------------------------------------------
선택> 2
--------------
계좌목록
--------------
111-111    홍길동    10000
111-222    강자바    20000
```

【예금 실행결과】 ③  
```output
--------------------------------------------------------
1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료
--------------------------------------------------------
선택> 3
--------------
예금
--------------
계좌번호 : 111-111
예금액 : 5000
결과 : 예금이 성공되었습니다.
```

【출금 실행결과】 ④  
```output
--------------------------------------------------------
1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료
--------------------------------------------------------
선택> 4
--------------
출금
--------------
계좌번호 : 111-222
출금액 : 3000
결과 : 출금이 성공되었습니다.
```

【계좌목록/종료 실행결과】 ⑤  
```output
--------------------------------------------------------
1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료
--------------------------------------------------------
선택> 2
--------------
111-111    홍길동    15000
111-222    강자바    17000
--------------------------------------------------------
1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료
--------------------------------------------------------
선택> 5
프로그램 종료
```

【Account.java】  
```java
public class Account {
	private String ano;
	private String owner;
	private int balance;

	public Account(String ano, String owner, int balance) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	public String	getAno()		{ return ano; }
	public void	setAno(String ano)	{ this.ano = ano; }
	public String	getOwner()		{ return owner; }
	public void	setOwner(String owner)	{ this.owner = owner; }
	public int	getBalance()		{ return balance; }
	public void	setBalance(int balance)	{ this.balance = balance; }
}
```

【BankApplication.java】  
```java
import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("--------------------------------------------------------");
			System.out.print("선택> ");
		
			int selectNo = scanner.nextInt();
		
			if	(selectNo == 1)	{ createAccount(); }
			else if	(selectNo == 2)	{ accountList(); }
			else if	(selectNo == 3) { deposit(); }
			else if	(selectNo == 4)	{ withdraw(); }
			else if	(selectNo == 5)	{ run = false; }
		}
		System.out.println("프로그램 종료");
	}

	// 계좌생성하기
	private static void createAccount() {
		// \n buffer delete
		scanner.nextLine();
		
		System.out.println("--------------");
		System.out.println("계좌생성");
		System.out.println("--------------");
	
		System.out.print("계좌번호 : ");
		String ano = scanner.nextLine();
	
		// 여기에 ln이 붙는 이유는 이클립스가 한글을 싫어하기 때문이다.
		System.out.println("계좌주 : ");
		String owner = scanner.nextLine();
	
		System.out.print("초기입금액 : ");
		int balance = scanner.nextInt();
		
		// \n buffer delete
		scanner.nextLine();
		
		// 진짜 이딴 식으로밖에 못 해? -> ㅇㅇ
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = new Account(ano, owner, balance);
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			}
			/* 이 부분은 논리적 오류가 있다. 99번 인덱스에 객체가 있으면 종료된다.
			 * 만약 중간에 있는 계좌가 삭제되었을 경우...
			 * 아니네, 어차피 0부터 도는 for문이니까 상관없을 듯.
			 */
			if(accountArray[accountArray.length-1] != null) {
				System.out.println("결과 : 계좌 생성 실패. 계좌 수 한도 100개.");
				break;
			}
		}
	}

	// 계좌목록보기
	private static void accountList() {
		// \n buffer delete
		scanner.nextLine();
		
		System.out.println("--------------");
			System.out.println("계좌목록");
			System.out.println("--------------");
		
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] != null) {
				System.out.printf("%s\t%s\t%d\n", 
					accountArray[i].getAno(), accountArray[i].getOwner(),
					accountArray[i].getBalance());
			}
		}
	}

	// 예금하기
	private static void deposit() {
		// \n buffer delete
		scanner.nextLine();
		
		System.out.println("--------------");
		System.out.println("예금");
		System.out.println("--------------");
		
		String ano;
		int money = 0;
		
		System.out.print("계좌번호 : ");
		ano = scanner.nextLine();
		
		if(findAccount(ano) != null) {
			money += findAccount(ano).getBalance();
			
			System.out.print("예금액 : ");
			money += scanner.nextInt();
			findAccount(ano).setBalance(money);
			
			System.out.println("결과 : 예금이 성공되었습니다.");
		} else { System.out.println("찾는 계좌가 없습니다. 계좌번호를 정확히 입력해주세요."); }
	}

	// 출금하기
	private static void withdraw() {
		// \n buffer delete
		scanner.nextLine();
		
		System.out.println("--------------");
		System.out.println("출금");
		System.out.println("--------------");
		
		String ano;
		int money = 0;
		
		System.out.print("계좌번호 : ");
		ano = scanner.nextLine();
		
		if(findAccount(ano) != null) {
			money += findAccount(ano).getBalance();
			
			System.out.print("출금액 : ");
			money -= scanner.nextInt();
			
			if(money < 0) {
				System.out.println("결과 : 계좌에 돈이 없습니다.");
				return;
			}
			
			findAccount(ano).setBalance(money);
			
			System.out.println("결과 : 출금이 성공되었습니다.");
		} else { System.out.println("찾는 계좌가 없습니다. 계좌번호를 정확히 입력해주세요."); }
	}

	// Account 배열에서 ano와 동일한 Account 객체 찾기
	private static Account findAccount(String ano) {
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i].getAno().equals(ano)) { return accountArray[i]; }
		}
		return null;
	}
}
```

> 위는 내가 강의를 듣기 전에 코딩한 것이다. 아래는 강의 내용과 내 코드를 섞었다. 강의에서는 Account객체를 직접 넘기지 않는 방향으로 작성했다. 인스턴스를 계속 생성해서 진행하나 나는 그 방식은 메모리 낭비라고 생각해서 본래의 객체를 리턴하는 방식으로 구현했다. 또한 printf문을 사용하여 코드 상의 가독성을 높이려고 했다. 내 코드나 강의 상의 코드나 역시나 예외처리를 많이 배제하고 코딩한 것이다. 오류 BAAM.  

```java
import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
    	
		boolean run = true;
		while(run) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("--------------------------------------------------------");
			System.out.print("선택> ");
		
			int selectNo = scanner.nextInt();
		
			if	(selectNo == 1)	{ createAccount(); }
			else if (selectNo == 2)	{ accountList(); }
			else if (selectNo == 3)	{ deposit(); }
			else if (selectNo == 4)	{ withdraw(); }
			else if (selectNo == 5)	{ run = false; }
		}
		System.out.println("프로그램 종료");
	}

	// 계좌생성하기
	private static void createAccount() {    	
		System.out.println("--------------");
		System.out.println("계좌생성");
		System.out.println("--------------");
	
		System.out.print("계좌번호 : ");
		String ano = scanner.next();
		
		System.out.print("계좌주 : ");
		String owner = scanner.next();
	
		System.out.print("초기입금액 : ");
		int balance = scanner.nextInt();
    	
		Account newAccount = new Account(ano, owner, balance);
    	
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = newAccount;
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			}
		}
	}

	// 계좌목록보기
	private static void accountList() {
		System.out.println("--------------");
		System.out.println("계좌목록");
		System.out.println("--------------");
		
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] != null) {
				System.out.printf("%s\t%s\t%d\n", 
					accountArray[i].getAno(), accountArray[i].getOwner(),
					accountArray[i].getBalance());
			}
		}
	}

	// 예금하기
	private static void deposit() {    	
		System.out.println("--------------");
		System.out.println("예금");
		System.out.println("--------------");
		
		System.out.print("계좌번호 : ");
		String ano = scanner.next();
		
		System.out.print("예금액 : ");
		int money = scanner.nextInt();

		Account account = findAccount(ano);
		if(account == null) {
			System.out.println("결과 : 계좌가 없습니다.");
			return;
		}
		account.setBalance(account.getBalance() + money);
		System.out.println("결과 : 예금이 성공되었습니다.");
	}

	// 출금하기
	private static void withdraw() {
    		System.out.println("--------------");
		System.out.println("출금");
		System.out.println("--------------");
		
		System.out.print("계좌번호 : ");
		String ano = scanner.next();
		
		System.out.print("예금액 : ");
		int money = scanner.nextInt();

		Account account = findAccount(ano);
		if(account == null) {
			System.out.println("결과 : 계좌가 없습니다.");
			return;
		}
		account.setBalance(account.getBalance() - money);
		System.out.println("결과 : 출금이 성공되었습니다.");
	}

	// Account 배열에서 ano와 동일한 Account 객체 찾기
	private static Account findAccount(String ano) {
		Account account = null;
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] != null) {
				String dbAno = accountArray[i].getAno();
				if(dbAno.equals(ano)) {
					account = accountArray[i];
					break;
				}
			}
		}
		return account;
	}
}
```