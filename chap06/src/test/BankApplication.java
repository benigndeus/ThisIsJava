package test;

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
	
		    if(selectNo == 1) {
		        createAccount();
		    } else if(selectNo == 2) {
		    	accountList();
		    } else if(selectNo == 3) {
		    	deposit();
		    } else if(selectNo == 4) {
		    	withdraw();
		    } else if(selectNo == 5) {
		    	run = false;
		    }
		}
    	System.out.println("프로그램 종료");
    }

    // 계좌생성하기
    private static void createAccount() {
    	// 작성 위치
    	
    	// \n buffer delete
    	scanner.nextLine();
    	
		System.out.println("--------------");
		System.out.println("계좌생성");
		System.out.println("--------------");
	
		System.out.print("계좌번호 : ");
		String ano = scanner.nextLine();
	
		// 여기에 ln이 붙는 이유는 한글은 이클립스가 싫어하기 때문이다.
		System.out.println("계좌주 : ");
		String owner = scanner.nextLine();
	
		System.out.print("초기입금액 : ");
		int balance = scanner.nextInt();
		
		// \n buffer delete
    	scanner.nextLine();
	
		// 진짜 이딴 식으로밖에 못 해?
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = new Account(ano, owner, balance);
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			}
			if(accountArray[accountArray.length-1] != null) {
				System.out.println("결과 : 계좌 생성 실패. 계좌 수 한도 100개.");
				break;
			}
		}
    }

    // 계좌목록보기
    private static void accountList() {
    	// 작성 위치
    	
    	// \n buffer delete
    	scanner.nextLine();
    	
    	System.out.println("--------------");
		System.out.println("계좌목록");
		System.out.println("--------------");
    	
    	for(int i=0; i<accountArray.length; i++) {
    		if(accountArray[i] != null) {
    			System.out.printf("%s\t%s\t%d\n", 
    					accountArray[i].getAno(), accountArray[i].getOwner(), accountArray[i].getBalance());
    		}
    	}
    }

    // 예금하기
    private static void deposit() {
    	// 작성 위치
    	
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
		} else {
			System.out.println("찾는 계좌가 없습니다. 계좌번호를 정확히 입력해주세요.");
		}
    }

    // 출금하기
    private static void withdraw() {
     	//  작성 위치
    	
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
		} else {
			System.out.println("찾는 계좌가 없습니다. 계좌번호를 정확히 입력해주세요.");
		}
    }

    // Account 배열에서 ano와 동일한 Account 객체 찾기
    private static Account findAccount(String ano) {
    	// 작성 위치
    	
    	for(int i=0; i<accountArray.length; i++) {
    		if(accountArray[i].getAno().equals(ano)) {
    			return accountArray[i];
    		}
    	}
    	
		return null;
    }
}