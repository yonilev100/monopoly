package com.yoni.monopoly;

import com.yoni.monopoly.dice.DiceManager;
import com.yoni.monopoly.dice.DiceResult;

import java.util.ArrayList;

public class Engine {

    private final DiceManager diceManager;
    private final ArrayList<Player> playerList;
    String locations[] = {"Ben-gurion", "Bialik", "Negba", "Hevrat te'ufa", "Otobus", "Hanasi", "Alanbi", "Dereh-hayam"};
    int playerIndex = 0;

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
        Player player = playerList.get(playerIndex);

        DiceResult diceResult = diceManager.throwDice();
        System.out.println("Throwing dice, result = " + diceResult.getDice1() + ", " + diceResult.getDice2());
        System.out.println("the " + player.getColor() + " player moved " + diceResult.getDice1() + ", " + diceResult.getDice2());
        player.setIndex((player.getIndex() + diceResult.getDice1() + diceResult.getDice2()) % 8);
        System.out.println("the player is on " + locations[player.getIndex()]);
        playerIndex++;
        if (playerIndex >= 4) {
            playerIndex = 0;
            playerIndex++;
        }
    }
}
