package main.java.com.example.atm;

public class BankService {
    public boolean validatePIN(int PIN) {
        if(PIN == 1234) {
            return true;
        }
        return false;
    }   
    
    public int getBalance(String accNo) {
        return 10000;
    }

    public void debit(String accNo, double amount) {
        // Logic
    }

    public String getStatement(String accNo) {
        return "Statement";
    }
}
