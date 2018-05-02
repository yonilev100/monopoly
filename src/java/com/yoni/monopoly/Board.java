package com.yoni.monopoly;

import java.util.ArrayList;

public class Board {

    private ArrayList<Place> locations;

    public Board() {
        CardsLoader cardsLoader = new CardsLoader();
        locations = new ArrayList<>(cardsLoader.load());
    }
    public int getNumberOfLocations() {
        return locations.size();
    }

    public Place getLocationAt(int index) {
        return locations.get(index);
    }

    public void movePlayer(Player player, int diceResult) {
        player.setIndex((player.getIndex() + diceResult) % locations.size());

    }

    public Place getLocationOf(Player player) {
        return locations.get(player.getIndex());
    }
}






