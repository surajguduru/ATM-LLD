package main.java.com.example.atm;

import java.util.Map;

public interface CashDispensingStrategy {
    Map<Denomination, Integer> dispense(double amount, Map<Denomination, Integer> cash);
}
