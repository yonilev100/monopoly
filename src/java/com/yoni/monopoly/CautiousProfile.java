package com.yoni.monopoly;

public class CautiousProfile implements Profile {

    @Override
    public boolean willPlayerBuyPlace(Player player, Place place) {
        return Math.random() < 0.2;
    }

    @Override
    public boolean willPlayerRememberToAskForRentMoney(Place place, Player player, int rentCost) {
        return Math.random() < 0.6;
    }
    public boolean willPlayerBuildAHouse(int seriaID, Player player){
        return Math.random() < 0.6;
    }
}
