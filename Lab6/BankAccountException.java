
public class BankAccountException extends RuntimeException{

    public BankAccountException(String message) {
        super(message);
    }

    public static class InvalidIdException extends BankAccountException {
        public InvalidIdException(String message) {
            super(message);
        }
    }

    public static class InvalidHolderException extends BankAccountException {
        public InvalidHolderException(String message) {
            super(message);
        }
    }

    public static class InvalidBalanceException extends BankAccountException {
        public InvalidBalanceException(String message) {
            super(message);
        }
    }

    public static class InvalidTransactionTypeException extends BankAccountException {
        public InvalidTransactionTypeException(String message) {
            super(message);
        }
    }

    public static class InvalidTransactionAmountException extends BankAccountException {
        public InvalidTransactionAmountException(String message) {
            super(message);
        }
    }

}
