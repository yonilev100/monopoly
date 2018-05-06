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
        playerList.get(1).setMoney(2640);
        playerList.get(1).buyPlace(board.getLocationAt(5));
        playerList.get(1).buyPlace(board.getLocationAt(6));
        playerList.get(1).buyPlace(board.getLocationAt(7));
        playerList.get(1).buyHouseOn(board.getLocationAt(5));
        playerList.get(1).buyHouseOn(board.getLocationAt(5));
        playerList.get(1).buyHouseOn(board.getLocationAt(5));
        playerList.get(1).buyHouseOn(board.getLocationAt(5));
        playerList.get(1).buyHouseOn(board.getLocationAt(6));
        playerList.get(1).buyHouseOn(board.getLocationAt(6));
        playerList.get(1).buyHouseOn(board.getLocationAt(6));
        playerList.get(1).buyHouseOn(board.getLocationAt(6));
        playerList.get(1).buyHouseOn(board.getLocationAt(7));
        playerList.get(1).buyHouseOn(board.getLocationAt(7));
        playerList.get(1).buyHouseOn(board.getLocationAt(7));
        playerList.get(1).buyHouseOn(board.getLocationAt(7));
    }


    public void run() {
        Player player = playerList.get(currentPlayerIndex);

        System.out.println("Player " + player.getName() + " started his turn - he has " + player.getMoney() + "$.");

        ArrayList<ArrayList<Place>> playerSerias = player.whichSeriasDoIHave();
        if (playerSerias.size() > 0) {
            ArrayList<Place> seriaChoosen = playerSerias.get((int) (Math.random() * (playerSerias.size())));
            Place placeChoosen = player.onWhichPlaceBuildAHouse(seriaChoosen);
            if (player.getHowManyHouses(placeChoosen) < 4) {
                if (player.getMoney() >= placeChoosen.getHousePrice()) {
                    if (player.getProfile().willPlayerBuyAHouse(placeChoosen.getSeriaID(), player)) {
                        player.buyHouseOn(placeChoosen);
                    }
                }
            } else {
                if (player.thereIsNoHotelOn(placeChoosen)) {
                    if (player.getMoney() >= placeChoosen.getHotelPrice()) {
                        if (player.getProfile().willPlayerBuyAHotel(placeChoosen.getSeriaID(), player)) {
                            player.buyHotelOn(placeChoosen);
                        }
                    }
                }
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
            if (owningPlayer.equals(player)) {
                System.out.println("Player already has the place");

            } else {
                System.out.println(owningPlayer.getName() + " has it");

                if (owningPlayer.getProfile().willPlayerRememberToAskForRentMoney(place, player, place.getRentCost())) {
                    if (owningPlayer.isHasWholeSeriaOf(place) && player.thereAreNoHousesOnPlaceSeria(place)) {
                        System.out.println("The player pays to " + owningPlayer.getName() + " " + (place.getRentCost() * 2) + "$. because he has a seria without houses.");
                        player.pay(owningPlayer, place.getRentCost() * 2);
                    } else if (owningPlayer.getHowManyHouses(place) > 0 && owningPlayer.thereIsNoHotelOn(place)) {
                        switch (owningPlayer.getHowManyHouses(place)) {
                            case 1:
                                player.pay(owningPlayer, place.getFirstHouseCost());
                                System.out.println("The player pays to " + owningPlayer.getName() + " " + place.getFirstHouseCost() + "$. because he has a one house.");
                                break;
                            case 2:
                                player.pay(owningPlayer, place.getSecondHouseCost());
                                System.out.println("The player pays to " + owningPlayer.getName() + " " + place.getSecondHouseCost() + "$. because he has a two houses.");
                                break;
                            case 3:
                                player.pay(owningPlayer, place.getThirdHouseCost());
                                System.out.println("The player pays to " + owningPlayer.getName() + " " + place.getThirdHouseCost() + "$. because he has a three houses.");
                                break;
                            case 4:
                                player.pay(owningPlayer, place.getForthHouseCost());
                                System.out.println("The player pays to " + owningPlayer.getName() + " " + place.getForthHouseCost() + "$. because he has a four houses.");
                                break;
                        }

                    }
                    else if(!owningPlayer.thereIsNoHotelOn(place)){
                        player.pay(owningPlayer, place.getHotelCost());
                        System.out.println("The player pays to " + owningPlayer.getName() + " " + place.getHotelCost() + "$. because he has a hotel.");
                    }
                    else {
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
                    System.out.println(place.getName() + ", number of houses: " + player.getHowManyHouses(place));
                }
            }
        }
    }
    public void removePlayer(Player player){
        playerList.remove(player);
    }
}
