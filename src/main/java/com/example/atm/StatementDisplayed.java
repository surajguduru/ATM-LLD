package main.java.com.example.atm;

public class StatementDisplayed implements TransactionState {
    private String statement;

    public StatementDisplayed(String statement) {
        this.statement = statement;
    }

    @Override
    public void handle(Transaction transaction) {
        System.out.println("Recent Transactions:");
        System.out.println(statement);
        transaction.setState(new TransactionComplete());
    }
}
