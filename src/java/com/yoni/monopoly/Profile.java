package com.yoni.monopoly;

public interface Profile {

    boolean willPlayerBuyPlace(Player player, Place place);

    boolean willPlayerRememberToAskForRentMoney(Place place, Player player, int rentCost);

    boolean willPlayerBuyAHouse(int seriaID, Player player);

    boolean willPlayerBuyAHotel(int seriaID, Player player);
}
