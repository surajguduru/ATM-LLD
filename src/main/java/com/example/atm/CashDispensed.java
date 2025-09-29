package main.java.com.example.atm;

public class CashDispensed implements TransactionState {
    public void handle(Transaction transaction) {
        System.out.println("Cash dispensed. Please collect the cash & your card");
        transaction.setState(new TransactionComplete());
    }
}
