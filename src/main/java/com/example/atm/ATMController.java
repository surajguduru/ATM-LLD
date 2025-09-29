package main.java.com.example.atm;

import java.util.Map;

public class ATMController {

    private Keyboard keyboard;
    private CashDispenser cashDispenser;
    private CardReader cardReader;
    private BankService bankService;
    private Map<Action, Class<? extends Transaction>> transactionMap;

    public ATMController(Keyboard keyboard,
            CashDispenser cashDispenser,
            CardReader cardReader,
            BankService bankService,
            Map<Action, Class<? extends Transaction>> transactionMap) {
        this.keyboard = keyboard;
        this.cashDispenser = cashDispenser;
        this.cardReader = cardReader;
        this.bankService = bankService;
        this.transactionMap = transactionMap;
    }

    public void processTransaction(Action action) {
        Class<? extends Transaction> transactionClass = transactionMap.get(action);
        if (transactionClass != null) {
            try {
                Transaction transaction = transactionClass.getConstructor(ATMController.class).newInstance(this);
                transaction.execute();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed to execute transaction for this action: " + action);
            }
        } 
        else {
            System.out.println("Action not supported: " + action);
        }
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public CardReader getCardReader() {
        return cardReader;
    }

    public BankService getBankService() {
        return bankService;
    }

    public ATMController getController() {
        return this;
    }
}
