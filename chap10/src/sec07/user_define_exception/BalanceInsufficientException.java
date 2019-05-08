package sec07.user_define_exception;

public class BalanceInsufficientException extends Exception {
        public BalanceInsufficientException() {}
        public BalanceInsufficientException(String message) {
                super(message);
        }
}