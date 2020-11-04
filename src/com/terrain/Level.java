package com.terrain;

import com.player.Bike;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Level {

    Bike bike;
    int trackNumber;

    public Level(int i, Bike bike){
        this.bike = bike;
        trackNumber = i;

    }

    public ArrayList<Block> makeTrack(){
        ArrayList<Block> result = new ArrayList<>();
        return result;
    }
}
