package com.yoni.monopoly;

public class Place {
    String name;
    int cost;
    String belongsTo;

    public Place(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.belongsTo = "";
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public String getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(String belongsTo) {
        this.belongsTo = belongsTo;
    }
}
