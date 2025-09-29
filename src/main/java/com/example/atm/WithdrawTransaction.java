package main.java.com.example.atm;

public class WithdrawTransaction implements Transaction {
    TransactionState transactionState;
    ATMController atmController;

    public WithdrawTransaction(ATMController atmController) {
        this.atmController = atmController;
        transactionState = new CardInserted();
    }

    public void execute() {
        System.out.println("This is a Withdrawal transaction");
        
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
        return atmController;
    }

    @Override
    public TransactionState getState() {
        return this.transactionState;
    }

    @Override
    public TransactionState nextAfterPINValidation() {
        return new CashDispensed();
    }
}
