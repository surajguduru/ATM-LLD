package main.java.com.example.atm;

public class CheckBalanceTransaction implements Transaction {
    private ATMController atmController;
    private TransactionState transactionState;

    public CheckBalanceTransaction(ATMController atmController) {
        this.atmController = atmController;
        this.transactionState = new CardInserted();
    }

    @Override
    public void execute() {
        while(!(transactionState instanceof TransactionComplete)) {
            transactionState.handle(this);
        }
        transactionState.handle(this);
    }

    @Override
    public void setState(TransactionState transactionState) {
        this.transactionState = transactionState;
    }

    @Override
    public ATMController getController() {
        return this.atmController;
    }

    @Override
    public TransactionState getState() {
        return this.transactionState;
    }

    @Override
    public TransactionState nextAfterPINValidation() {
        return new FetchingBalance();
    }
}
