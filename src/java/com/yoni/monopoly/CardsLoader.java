package com.yoni.monopoly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CardsLoader {

    public List<Place> load() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Yoni\\IdeaProjects\\monopoly\\src\\java\\card.csv"));
            try {

                ArrayList<Place> places = new ArrayList<>();
                int[] seriaID = {1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8};
                int lineNumber = 0;
                int findID = 0;
                String line;
                while ((line = reader.readLine()) != null) {
                    if (lineNumber != 0) {
                        String[] arr = line.split(",");

                        String name = arr[1];
                        int cost = Integer.valueOf(arr[2]);
                        int rentCost = Integer.valueOf(arr[3]);
                        int firstHouseCost = Integer.valueOf(arr[4]);
                        int secondHouseCost = Integer.valueOf(arr[5]);
                        int thirdHouseCost = Integer.valueOf(arr[6]);
                        int fourthHouseCost = Integer.valueOf(arr[7]);
                        int hotelCost = Integer.valueOf(arr[8]);
                        int housePrice = Integer.valueOf(arr[9]);
                        int hotelPrice = Integer.valueOf(arr[10]);


                        Place place = new Place(name, cost, rentCost, seriaID[findID], housePrice, hotelPrice, firstHouseCost, secondHouseCost, thirdHouseCost, fourthHouseCost, hotelCost);
                        places.add(place);

                        System.out.println("LINE = " + line);
                        if(findID<21){
                            findID++;
                        }
                    }
                    lineNumber++;
                }
                setHowManyAreInASeria(places);
                return places;
            } finally {
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public void setHowManyAreInASeria(ArrayList<Place> places){
        int howManyAreInASeria = 0;
        for(Place place : places){
            for(Place placeChecked : places){
                if(placeChecked.getSeriaID() == place.getSeriaID()){
                    howManyAreInASeria++;
                }
            }
            place.setHowManyAreaInSeria(howManyAreInASeria);
        }

    }
}
