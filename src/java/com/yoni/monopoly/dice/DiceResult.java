package com.yoni.monopoly.dice;

public class DiceResult {

    private final int dice1;
    private final int dice2;

    public DiceResult(int dice1, int dice2) {
        this.dice1 = dice1;
        this.dice2 = dice2;
    }


    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
    }

    public int getTotal() {
        return dice1 + dice2;
    }
}
