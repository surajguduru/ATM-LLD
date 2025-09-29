package main.java.com.example.atm;

public class CardInserted implements TransactionState {
    
    
    public void handle(Transaction transaction) {
        ATMController atmController = transaction.getController();
        boolean isCardValid = atmController.getCardReader().validateCard();

        if(isCardValid) {
            transaction.setState(new CardValidated());
        }
        else {
            System.out.println("Card Validation failed. Transaction failed!");
            transaction.setState(new TransactionComplete());
        }
    }
}
