package sec08;

public class AccountExample {
        public static void main(String[] args) {
                Account account = new Account();

                account.deposit(10000);
                System.out.println("Your Account: " + account.getBalance());

                try {
                        account.withdraw(30000);
                        System.out.println("Your Account: " + account.getBalance());
                } catch (BalanceInsufficientException e) {
                        String message = e.getMessage();
                        System.out.println(message);
                        System.out.println();
                        
                        e.printStackTrace();
                        System.out.println();
                        System.out.println(e.toString());
                }
        }
}