package org.example;

public class Pair {
    int number1;
    int number2;

    public Pair(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public String toString() {
        return number1 + " " + number2 ;
    }
}
