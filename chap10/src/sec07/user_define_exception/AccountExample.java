package sec07.user_define_exception;

public class AccountExample {
        public static void main(String[] args) {
                Account account = new Account();

                account.deposit(10000);
                System.out.println("Your Account: " + account.getBalance());

                try {
                        account.withdraw(30000);
                        System.out.println("Your Account: " + account.getBalance());
                } catch (BalanceInsufficientException e) {
                        System.out.println("There is not enough balance.");
                }
        }
}