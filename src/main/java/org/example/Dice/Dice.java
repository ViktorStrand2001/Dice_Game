package org.example.Dice;

import java.util.Random;

public class Dice {
    private Random ran = new Random();

    // Method to simulate rolling a six-sided dice
    public int roll(){
        return ran.nextInt(6) + 1;
    }
}
