package main.java.com.example.atm;

public enum Denomination {
    ONE_HUNDRED(100),
    FIVE_HUNDRED(500),
    TWO_THOUSAND(2000);

    private final int value;

    Denomination(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
