package com.yoni.monopoly;

public class Train {
    private String name;
    private int cost = 200;
    private int rentCost = 25;
    private int twoTrainsCost = 50;
    private int threeTrainsCost = 100;
    private int fourTrainsCost = 200;

    public Train(String name) {
        this.name = name;

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

    public int getTwoTrainsCost() {
        return twoTrainsCost;
    }

    public int getThreeTrainsCost() {
        return threeTrainsCost;
    }

    public int getFourTrainsCost() {
        return fourTrainsCost;
    }
    public int howMuchDoYouNeedToPay(int howManyTrains){
        switch(howManyTrains){
            case 1:
                return rentCost;
            case 2:
                return twoTrainsCost;
            case 3:
                return threeTrainsCost;
            case 4:
                return fourTrainsCost;

        }
        return 0;
    }
}
