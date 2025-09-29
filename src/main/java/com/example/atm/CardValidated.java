package main.java.com.example.atm;

public class CardValidated implements TransactionState {

    public void handle(Transaction transaction) {
        System.out.println("Please enter the PIN: ");
        String PIN = transaction.getController().getKeyboard().getInput();
        boolean isValidPIN = transaction.getController().getBankService().validatePIN(Integer.parseInt(PIN));

        if(isValidPIN) {
            transaction.setState(new PINValidated());
        }
        else {
            System.out.println("The PIN entered was wrong. Transaction failed!");
            transaction.setState(new TransactionComplete());
        }
    }
}
