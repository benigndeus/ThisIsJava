package verify.exam19;

public class Account {
	private int balance;
	public static final int MIN_BALANCE = 0;
	public static final int MAX_BALANCE = 1000000;
	
	public int getBalance() {
		return this.balance;
	}
	
	public void setBalance(int balance) {
		if(balance < Account.MIN_BALANCE || balance > Account.MAX_BALANCE) {
			return;
		} else {
			this.balance = balance;
		}
	}
}