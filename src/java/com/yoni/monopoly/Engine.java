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
        playerList.add(new Player("red", new AggressiveProfile()));
        playerList.add(new Player("green", new CautiousProfile()));
        playerList.add(new Player("blue", new CautiousProfile()));
        playerList.add(new Player("yellow", new CautiousProfile()));

        board = new Board();
    }


    public void run() {
        Player player = playerList.get(currentPlayerIndex);

        System.out.println("Player " + player.getName() + " started his turn - he has " + player.getMoney() + "$.");

        DiceResult diceResult = diceManager.throwDice();
        System.out.println("Throwing dice, result = " + diceResult.getDice1() + ", " + diceResult.getDice2());
        System.out.println("The " + player.getName() + " player moves " + diceResult.getTotal());
        board.movePlayer(player, diceResult.getTotal());

        Place place = board.getLocationOf(player);
        System.out.println("The player has landed on " + place.getName());

        if (place.getBelongsTo() == null && player.getMoney() >= place.getCost()) {
            if (player.getProfile().willPlayerBuyPlace(player, place)) {
                System.out.println("The player decides to buy it");
                player.buyPlace(place);
            } else {
                System.out.println("The player decides not to buy it");
            }
        } else {
            System.out.println(place.getBelongsTo().getName() + " has it");
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
    }

    public void printDebug() {
        for (Player player : playerList) {
            System.out.println("******************** DEBUG *************************");
            System.out.println("Information about " + player.getName() + ":");
            System.out.println("Money: " + player.getMoney() + "$");
            System.out.println("Places:");
            if (player.getPlaces().isEmpty()) {
                System.out.println("None");
            } else {
                for (Place place : player.getPlaces()) {
                    System.out.println(place.getName());
                }
            }
        }
    }
}
