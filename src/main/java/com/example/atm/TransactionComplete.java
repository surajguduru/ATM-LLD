package main.java.com.example.atm;

public class TransactionComplete implements TransactionState {
    public void handle(Transaction transaction) {
        System.out.println("Transaction is complete. Thanks!");
    }
}
