package main.java.com.example.atm;

import java.util.LinkedHashMap;
import java.util.Map;

public class GreedyCashDispensingStrategy implements CashDispensingStrategy {

    @Override
    public Map<Denomination, Integer> dispense(double amount, Map<Denomination, Integer> cash) {
        Map<Denomination, Integer> result = new LinkedHashMap<>();

        double remaining = amount;

        for (Denomination denom : Denomination.values()) {
            int denomValue = denom.getValue();
            int availableNotes = cash.getOrDefault(denom, 0);

            int neededNotes = (int) (remaining / denomValue);
            int dispensedNotes = Math.min(neededNotes, availableNotes);

            if (dispensedNotes > 0) {
                result.put(denom, dispensedNotes);
                cash.put(denom, availableNotes - dispensedNotes);
                remaining -= dispensedNotes * denomValue;
            }
        }

        if (remaining > 0) {
            throw new IllegalStateException("Unable to dispense the requested amount with available denominations.");
        }

        return result;
    }
}
