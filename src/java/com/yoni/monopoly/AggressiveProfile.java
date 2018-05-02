package com.yoni.monopoly;

public class AggressiveProfile implements Profile {

    @Override
    public boolean willPlayerBuyPlace(Player player, Place place) {
        return true;
    }

    @Override
    public boolean willPlayerRememberToAskForRentMoney(Place place, Player player, int rentCost) {
        return true;
    }
    public boolean willPlayerBuildAHouse(int seriaID, Player player){
        return true;
    }
}
