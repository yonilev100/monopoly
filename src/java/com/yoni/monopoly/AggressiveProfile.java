package com.yoni.monopoly;

public class AggressiveProfile implements Profile {

    @Override
    public boolean willPlayerBuyPlace(Player player, Place place) {
        return true;
    }
}
