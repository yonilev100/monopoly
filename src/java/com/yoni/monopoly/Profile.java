package com.yoni.monopoly;

public interface Profile {

    boolean willPlayerBuyPlace(Player player, Place place);
    boolean willPlayerRememberToAskForRentMoney(Place place, Player player,int rentCost);
    public boolean willPlayerBuildAHouse(int seriaID, Player player);
}
