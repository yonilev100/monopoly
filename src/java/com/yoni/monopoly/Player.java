package com.yoni.monopoly;

import java.util.ArrayList;

public class Player {
    private int money;
    private String name;
    private int index = 1;
    private ArrayList<Place> whatMine;

    public Player(String name) {
        this.name = name;
        whatMine = new ArrayList<>();
        index = 0;
        this.money = 1000;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void addToMyPlaces(Place place) {
        whatMine.add(place);
    }

    public boolean DoIHaveIt(Place placeToCheck) {
        return whatMine.contains(placeToCheck);
    }


}
