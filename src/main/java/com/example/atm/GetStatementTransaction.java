package main.java.com.example.atm;

public class GetStatementTransaction implements Transaction {
    ATMController atmController;
    TransactionState transactionState;

    public GetStatementTransaction(ATMController atmController) {
        this.atmController = atmController;
        this.transactionState = new CardInserted();
    }

    public void execute() {
        
        while(!(transactionState instanceof TransactionComplete)) {
            transactionState.handle(this);
        }

        transactionState.handle(this);
    }

    public ATMController getController() {
        return this.atmController;
    }

    @Override
    public void setState(TransactionState transactionState) {
        this.transactionState = transactionState;
    }

    @Override
    public TransactionState getState() {
        return this.transactionState;
    }

    @Override
    public TransactionState nextAfterPINValidation() {
        return new FetchingStatement();
    }
}
