package com.yoni.monopoly;

public class Player {

    private String name;
    private int index = 1;

    public Player(String name) {
        this.name = name;

        index = 0;
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
}
