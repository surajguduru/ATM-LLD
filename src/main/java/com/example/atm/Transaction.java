package main.java.com.example.atm;

public interface Transaction {
    void execute();
    void setState(TransactionState transactionState);
    TransactionState getState();
    ATMController getController();
    TransactionState nextAfterPINValidation();
}

