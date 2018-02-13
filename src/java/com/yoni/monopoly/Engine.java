package com.yoni.monopoly;

import com.yoni.monopoly.dice.DiceManager;
import com.yoni.monopoly.dice.DiceResult;

import java.util.ArrayList;

public class Engine {

    private final DiceManager diceManager;
    private final ArrayList<Player> playerList;
    private final Board board;

    private int currentPlayerIndex = 0;

    public Engine() {
        diceManager = new DiceManager();

        playerList = new ArrayList<>();
        playerList.add(new Player("red"));
        playerList.add(new Player("green"));
        playerList.add(new Player("blue"));
        playerList.add(new Player("yellow"));
        board = new Board();
    }


    public void run() {
        Player player = playerList.get(currentPlayerIndex);

        System.out.println("Player " + player.getName() + " started his turn");

        DiceResult diceResult = diceManager.throwDice();
        System.out.println("Throwing dice, result = " + diceResult.getDice1() + ", " + diceResult.getDice2());
        System.out.println("The " + player.getName() + " player moves " + diceResult.getTotal());

        player.setIndex((player.getIndex() + diceResult.getTotal()) % board.getNumberOfLocations());
        System.out.println("the player is on " + board.getLocationAt(player.getIndex()));

        currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
    }
}
