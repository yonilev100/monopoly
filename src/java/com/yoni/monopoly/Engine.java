package com.yoni.monopoly;

import com.yoni.monopoly.dice.DiceManager;
import com.yoni.monopoly.dice.DiceResult;

import java.util.ArrayList;

public class Engine {

    private final DiceManager diceManager;
    private final ArrayList<Player> playerList;

    private int currentPlayer;


    public Engine() {
        diceManager = new DiceManager();

        playerList = new ArrayList<>();
        playerList.add(new Player("red"));
        playerList.add(new Player("green"));
        playerList.add(new Player("blue"));
        playerList.add(new Player("yellow"));
    }


    public void run() {
        System.out.println("Running single turn");

        for (Player player : playerList) {
            DiceResult diceResult = diceManager.throwDice();
            System.out.println("Throwing dice, result = " + diceResult.getDice1() + ", " + diceResult.getDice2());
            System.out.println("the "+player.getColor()+" player moved " + diceResult.getDice1() + ", " + diceResult.getDice2());

        }
    }
}
