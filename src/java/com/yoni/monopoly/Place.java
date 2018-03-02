package com.yoni.monopoly;

public class Place {

    private final String name;
    private final int cost;

    private Player belongsTo;

    public Place(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.belongsTo = null;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public Player getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(Player belongsTo) {
        this.belongsTo = belongsTo;
    }
}
