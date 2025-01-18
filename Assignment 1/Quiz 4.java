import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
       
        BankAccount account = new BankAccount(1000);
        Calendar date = Calendar.getInstance();

        DepositTransaction deposit = new DepositTransaction(200, date, "TXN001");
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(150, date, "TXN002");

        System.out.println("Testing Direct Subclass Objects:");
        deposit.apply(account);
        System.out.println("Balance after deposit: " + account.getBalance());

        try {
            withdrawal.apply(account);
            System.out.println("Balance after withdrawal: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\nTesting with Base Class References (Polymorphism):");

        BaseTransaction baseDeposit = (BaseTransaction) deposit;
        BaseTransaction baseWithdrawal = (BaseTransaction) withdrawal;

        baseDeposit.apply(account);
        System.out.println("Balance after polymorphic deposit: " + account.getBalance());

        try {
            baseWithdrawal.apply(account);
            System.out.println("Balance after polymorphic withdrawal: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Exception during polymorphic withdrawal: " + e.getMessage());
        }
    }
}


