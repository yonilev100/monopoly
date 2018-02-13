package com.yoni.monopoly;

public class Player {
    String color;
    int index = 0;
    public Player(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
