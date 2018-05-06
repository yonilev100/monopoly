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
    @Override
    public boolean willPlayerBuyAHouse(int seriaID, Player player) {
        return Math.random()>0.2;
    }
    @Override
    public boolean willPlayerBuyAHotel(int seriaID, Player player){
        return Math.random()>0.6;
    }
}
