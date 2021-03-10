package com.example.bonneappli;

import java.util.Random;

public class GuessNumber {
    private int currentNumber;
    private int max;

    public enum guessState{BIGGER, EQUAL, SMALLER};

    public GuessNumber(int max) {
        this.max = max;
        generateNewRandomNumber();
    }

    public void generateNewRandomNumber() {
        currentNumber = new Random().nextInt(max+1);
    }

    public guessState testNumber(int numberToTest) {
        if(numberToTest > currentNumber) {
            return guessState.BIGGER;
        } else if(numberToTest < currentNumber) {
            return guessState.SMALLER;
        } else {
            return guessState.EQUAL;
        }
    }
}
