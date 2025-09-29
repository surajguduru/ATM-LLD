package main.java.com.example.atm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Keyboard keyboard = new DigitalKeyboard();
        CardReader cardReader = new CardReader();
        CashDispenser cashDispenser = new CashDispenser(new GreedyCashDispensingStrategy());
        BankService bankService = new BankService();

        Map<Action, Class<? extends Transaction>> transactionMap = new HashMap<>();
        transactionMap.put(Action.WITHDRAW_CASH, WithdrawTransaction.class);
        transactionMap.put(Action.CHECK_BALANCE, CheckBalanceTransaction.class);
        transactionMap.put(Action.GET_STATEMENT, GetStatementTransaction.class);
        // transactionMap.put(Action.DEPOSIT_CASH, DepositTransaction.class);

        ATMController controller = new ATMController(keyboard, cashDispenser, cardReader, bankService, transactionMap);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nInsert card and select action:");
            System.out.println("1. Withdraw Cash\n2. Deposit Cash\n3. Check Balance\n4. Get Statement\n0. Exit");

            int choice = sc.nextInt();
            if (choice == 0) break;

            Action action = switch (choice) {
                case 1 -> Action.WITHDRAW_CASH;
                case 2 -> Action.CHECK_BALANCE;
                case 3 -> Action.GET_STATEMENT;
                // case 4 -> Action.DEPOSIT_CASH;
                default -> null;
            };

            if (action != null) {
                controller.processTransaction(action);
            } else {
                System.out.println("Invalid selection. Try again.");
            }
        }

        sc.close();
        System.out.println("ATM shutting down...");
    }
}
