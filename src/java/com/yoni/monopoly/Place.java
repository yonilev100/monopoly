package com.yoni.monopoly;

public class Place{

    private final String name;
    private final int cost;
    private final int rentCost;
    private Player belongsTo;
    private int seriaID;
    private int howManyAreaInSeria;
    private int housePrice;
    private int hotelPrice;
    private int firstHouseCost;
    private int secondHouseCost;
    private int thirdHouseCost;
    private int forthHouseCost;
    private int hotelCost;

    public Place(String name, int cost, int rentCost, int seriaID, int housePrice, int hotelPrice, int firstHouseCost, int secondHouseCost, int thirdHouseCost, int forthHouseCost, int hotelCost) {
        this.name = name;
        this.cost = cost;
        this.rentCost = rentCost;
        this.belongsTo = null;
        this.seriaID = seriaID;
        this.housePrice = housePrice;
        this.hotelPrice = hotelPrice;
        this.firstHouseCost = firstHouseCost;
        this.secondHouseCost = secondHouseCost;
        this.thirdHouseCost = thirdHouseCost;
        this.forthHouseCost = forthHouseCost;
        this.hotelCost = hotelCost;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public int getHotelPrice() {
        return hotelPrice;
    }

    public int getFirstHouseCost() {
        return firstHouseCost;
    }

    public int getSecondHouseCost() {
        return secondHouseCost;
    }

    public int getThirdHouseCost() {
        return thirdHouseCost;
    }

    public int getForthHouseCost() {
        return forthHouseCost;
    }

    public int getHotelCost() {
        return hotelCost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getRentCost() {
        return rentCost;
    }

    public Player getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(Player belongsTo) {
        this.belongsTo = belongsTo;
    }

    public int getSeriaID() {
        return seriaID;
    }


    public void setHowManyAreaInSeria(int howManyAreaInSeria) {
        this.howManyAreaInSeria = howManyAreaInSeria;
    }

    public int getHowManyAreaInSeria() {
        return howManyAreaInSeria;
    }
}
