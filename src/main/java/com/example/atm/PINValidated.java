package main.java.com.example.atm;

public class PINValidated implements TransactionState {
    @Override
    public void handle(Transaction transaction) {
        System.out.println("Enter amount to withdraw:");
        double amount = Double.parseDouble(transaction.getController().getKeyboard().getInput());

        BankService bank = transaction.getController().getBankService();
        CashDispenser dispenser = transaction.getController().getCashDispenser();

        if (bank.getBalance("dummyAccount") >= amount && dispenser.hasSufficientCash(amount)) {
            dispenser.dispenseCash(amount);
            bank.debit("dummyAccount", amount);
            // if(transaction instanceof WithdrawTransaction) {
            //     transaction.setState(new CashDispensed());
            // }
            // else if(transaction instanceof GetStatementTransaction) {
            //     transaction.setState(new FetchingStatement());
            // }
            // else if(transaction instanceof CheckBalanceTransaction) {
            //     transaction.setState(new FetchingBalance());
            // }
            transaction.setState(transaction.nextAfterPINValidation());
        } else {
            System.out.println("Insufficient funds / Sufficient cash not available!");
            transaction.setState(new TransactionComplete());
        }
    }
}
