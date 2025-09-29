package main.java.com.example.atm;

import java.util.Scanner;

public class PhysicalKeyboard implements Keyboard {
    public String getInput() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }
}