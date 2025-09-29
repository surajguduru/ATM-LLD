package main.java.com.example.atm;

public class FetchingBalance implements TransactionState {
    public void handle(Transaction transaction) {
        BankService bankService = transaction.getController().getBankService();
        double balance = bankService.getBalance("dummy123");
        System.out.println("Your current acc balance is: " + balance);
        transaction.setState(new TransactionComplete());
    }
}
