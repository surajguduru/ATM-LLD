package main.java.com.example.atm;

import java.util.HashMap;
import java.util.Map;

public class CashDispenser {
    private Map<Denomination, Integer> cash;
    private CashDispensingStrategy strategy;

    public CashDispenser(CashDispensingStrategy strategy) {
        this.strategy = strategy;
        this.cash = new HashMap<>();

        // load some initial cash
        cash.put(Denomination.TWO_THOUSAND, 10);
        cash.put(Denomination.FIVE_HUNDRED, 20);
        cash.put(Denomination.ONE_HUNDRED, 50);
    }

    public boolean hasSufficientCash(double amount) {
        try {
            strategy.dispense(amount, new HashMap<>(cash)); // simulate
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    public void dispenseCash(double amount) {
        Map<Denomination, Integer> notes = strategy.dispense(amount, cash);
        System.out.println("Dispensing: " + notes);
    }
}
