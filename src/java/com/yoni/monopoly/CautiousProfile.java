package com.yoni.monopoly;

public class CautiousProfile implements Profile {

    @Override
    public boolean willPlayerBuyPlace(Player player, Place place) {
        return Math.random() < 0.2;
    }
}
