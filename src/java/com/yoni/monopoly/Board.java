package com.yoni.monopoly;

public class Board {

    private final String locations[];

    public Board() {
        locations = new String[] {"Ben-gurion", "Bialik", "Negba", "Hevrat te'ufa", "Otobus", "Hanasi", "Alanbi", "Dereh-hayam"};
    }

    public int getNumberOfLocations() {
        return locations.length;
    }

    public String getLocationAt(int index) {
        return locations[index];
    }
}
