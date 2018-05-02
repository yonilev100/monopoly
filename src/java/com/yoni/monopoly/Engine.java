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
        /**erase**/
        playerList.get(0).buyPlace(board.getLocationAt(0));
        playerList.get(0).buyPlace(board.getLocationAt(1));
        playerList.get(0).buyPlace(board.getLocationAt(2));
    }


    public void run() {
        Player player = playerList.get(currentPlayerIndex);

        System.out.println("Player " + player.getName() + " started his turn - he has " + player.getMoney() + "$.");

        ArrayList<ArrayList<Place>> playerSerias = player.whichSeriasDoIHave();
        if(playerSerias.size()>0){
            ArrayList<Place> seriaChoosen = playerSerias.get((int)(Math.random()*(playerSerias.size())));
            Place placeChoosen = player.onWhichPlaceBuildAHouse(seriaChoosen);
            if(player.getProfile().willPlayerBuildAHouse(placeChoosen.getSeriaID(),player)) {
                player.buyHouseOn(placeChoosen);
            }
        }
        DiceResult diceResult = diceManager.throwDice();
        System.out.println("Throwing dice, result = " + diceResult.getDice1() + ", " + diceResult.getDice2());
        System.out.println("The " + player.getName() + " player moves " + diceResult.getTotal());
        board.movePlayer(player, diceResult.getTotal());

        Place place = board.getLocationOf(player);
        System.out.println("The player has landed on " + place.getName());

        Player owningPlayer = place.getBelongsTo();
        if (owningPlayer == null) {
            if (player.getMoney() >= place.getCost()) {
                if (player.getProfile().willPlayerBuyPlace(player, place)) {
                    System.out.println("The player decides to buy it");
                    player.buyPlace(place);
                } else {
                    System.out.println("The player decides not to buy it");
                }
            } else {
                System.out.println("The player has no money to buy it");
            }
        } else {
            if(owningPlayer.equals(player)) {
                System.out.println("Player already has the place");

            } else {
                System.out.println(owningPlayer.getName() + " has it");

                if (owningPlayer.getProfile().willPlayerRememberToAskForRentMoney(place, player, place.getRentCost())) {
                    if (owningPlayer.isHasWholeSeriaOf(place)) {
                        System.out.println("The player pays to " + owningPlayer.getName() + " " + (place.getRentCost() * 2) + "$. because he has a seria.");
                        player.pay(owningPlayer, place.getRentCost() * 2);
                    } else {
                        System.out.println("The player pays to " + owningPlayer.getName() + " " + place.getRentCost() + "$.");
                        player.pay(owningPlayer, place.getRentCost());
                    }

                    System.out.println("now he has " + player.getMoney() + "$.");
                } else {
                    System.out.println(("oh, the " + owningPlayer.getName() + " player forgot to ask money from the " + player.getName() + " player, it is his fault...."));
                }
            }
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
                    System.out.println(place.getName()+ ", number of houses: "+player.getHowManyHouses(place));
                }
            }
        }
    }
}
