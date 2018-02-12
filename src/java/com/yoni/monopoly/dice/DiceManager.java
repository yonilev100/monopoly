package com.yoni.monopoly.dice;

public class DiceManager {

    public DiceResult throwDice() {
        return new DiceResult(throwDie(), throwDie());
    }

    private int throwDie() {
        return (int)(Math.random() * 6) + 1;
    }
}
