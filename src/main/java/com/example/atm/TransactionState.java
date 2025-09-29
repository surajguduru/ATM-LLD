package main.java.com.example.atm;

public interface TransactionState {
    public void handle(Transaction transaction);
}
