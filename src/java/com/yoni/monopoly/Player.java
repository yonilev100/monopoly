package com.yoni.monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {
    private int money;
    private String name;
    private int index = 1;
    private List<Place> places;
    private Profile profile;
    private HashMap<Place,Integer> placesHouses = new HashMap<>();



    public Player(String name, Profile profile) {
        this.name = name;
        places = new ArrayList<>();
        index = 0;
        this.money = 1000;
        this.profile = profile;
    }


    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public int getHowManyHouses(Place place){
        return placesHouses.get(place);
    }

    public Place onWhichPlaceBuildAHouse(ArrayList<Place> seria) {
        Place placeWithSmallestNumOFHouses = seria.get(0);
        for (Place place : seria) {
            if (place.getBelongsTo().getHowManyHouses(place) < placeWithSmallestNumOFHouses.getBelongsTo().getHowManyHouses(placeWithSmallestNumOFHouses)) {
                placeWithSmallestNumOFHouses = place;
            } else if (place.getBelongsTo().getHowManyHouses(place) == placeWithSmallestNumOFHouses.getBelongsTo().getHowManyHouses(placeWithSmallestNumOFHouses)) {
                if (Math.random() < 0.5) {
                    placeWithSmallestNumOFHouses = place;
                }
            }
        }
        return placeWithSmallestNumOFHouses;
    }

    public void buyPlace(Place place) {
        places.add(place);
        place.setBelongsTo(this);
        money -= place.getCost();
        System.out.println("Player " + name + " buys " + place.getName() + " and pays " + place.getCost() + "$. Now he has " + money + "$.");
        placesHouses.put(place,0);
    }

    public void buyHouseOn(Place place) {
        if(money>=place.getHousePrice()){
            placesHouses.put(place, placesHouses.get(place) + 1);
            money -= place.getHousePrice();
            System.out.println("Player " + name + " buys a house on " + place.getName() + " and pays " + place.getHousePrice() + "$. Now he has " + money + "$.");
            placesHouses.put(place,0);
        }
        else{
            System.out.println("Player " + name + " don't have enough money to buy "+place.getName());
        }
    }


    public List<Place> getPlaces() {
        return places;
    }


    public Profile getProfile() {
        return profile;
    }

    public void pay(Player otherPlayer, int sum) {
        money -= sum;
        otherPlayer.setMoney(otherPlayer.getMoney() + sum);
    }

    public boolean isHasWholeSeriaOf(Place place) {
        int placeCount = 0;
        for (Place myPlace : places) {
            if (myPlace.getSeriaID() == place.getSeriaID())
                placeCount++;
        }
        return placeCount == place.getHowManyAreaInSeria();
    }
    public ArrayList<ArrayList<Place>> whichSeriasDoIHave() {
        HashMap<Integer, ArrayList<Place>> seriaIDMapping = new HashMap<>();
        for (Place place : places){
            if(isHasWholeSeriaOf(place)){
                ArrayList<Place> arrayList = seriaIDMapping.get(place.getSeriaID());
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    seriaIDMapping.put(place.getSeriaID(), arrayList);
                }
                arrayList.add(place);
            }
        }

        ArrayList<ArrayList<Place>> serias = new ArrayList<>(seriaIDMapping.values());
        return serias;
    }
}
