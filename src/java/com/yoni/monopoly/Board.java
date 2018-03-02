package com.yoni.monopoly;

public class Board {

    private final Place locations[];

    public Board() {
        locations = new Place[] {new Place("Ben-gurion",100), new Place("Bialik",30), new Place("Negba",80), new Place("Hevrat te'ufa",110), new Place("Otobus",60), new Place("Hanasi",200), new Place("Alanbi",15), new Place("Dereh-hayam",100)};
    }

    public int getNumberOfLocations() {
        return locations.length;
    }

    public Place getLocationAt(int index) {
        return locations[index];
    }

    public void movePlayer(Player player, int diceResult) {
        player.setIndex((player.getIndex() + diceResult) % locations.length);
    }

    public Place getLocationOf(Player player) {
        return locations[player.getIndex()];
    }
}
