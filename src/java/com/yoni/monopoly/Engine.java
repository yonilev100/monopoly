package com.yoni.monopoly;

import com.yoni.monopoly.dice.DiceManager;
import com.yoni.monopoly.dice.DiceResult;

public class Engine {

    private final DiceManager diceManager;


    public Engine() {
        diceManager = new DiceManager();
    }


    public void run() {
        System.out.println("Running single turn");

        DiceResult diceResult = diceManager.throwDice();
        System.out.println("Throwing dice, result=" + diceResult.getDice1() + ", " + diceResult.getDice2());
    }
}
