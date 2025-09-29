package main.java.com.example.atm;

public class FetchingStatement implements TransactionState {
    @Override
    public void handle(Transaction transaction) {
        System.out.println("Fetching your statement...");
        BankService bank = transaction.getController().getBankService();
        var statement = bank.getStatement("dummyAccount");

        if (statement != null && !statement.isEmpty()) {
            transaction.setState(new StatementDisplayed(statement));
        } else {
            System.out.println("No transactions available.");
            transaction.setState(new TransactionComplete());
        }
    }
}
