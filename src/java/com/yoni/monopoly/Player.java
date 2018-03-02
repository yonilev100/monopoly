package com.yoni.monopoly;

import java.util.ArrayList;

public class Player {
    private int money;
    private String name;
    private int index = 1;
    private ArrayList<Place> places;
    private Profile profile;

    public Player(String name, Profile profile) {
        this.name = name;
        places = new ArrayList<>();
        index = 0;
        this.money = 1000;
        this.profile = profile;
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

    public void buyPlace(Place place) {
        places.add(place);
        place.setBelongsTo(this);
        money -= place.getCost();

        System.out.println("Player " + name + " buys " + place.getName() + " and pays " + place.getCost() + ". Now he has " + money + "$.");
    }


    public ArrayList<Place> getPlaces() {
        return places;
    }


    public Profile getProfile() {
        return profile;
    }
}
