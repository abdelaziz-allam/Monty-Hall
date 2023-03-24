package com.tele2.tvshow.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class GameSettings {
    public static final int NUMBER_OF_BOXES = 3;
    private static List<Box> boxes ;
    private Random random ;

    public GameSettings(){
        init();
    }
    // init Gate
    private void init() {
        random = new Random();
        boxes = new ArrayList<>();
        // Initialize boxes
        IntStream.range(0, NUMBER_OF_BOXES).forEach(i -> boxes.add(new Box()));
        // select random box to define money exist in
        int moneyBoxIndex = random.nextInt(NUMBER_OF_BOXES);
        boxes.get(moneyBoxIndex).setMoneyBox(true);
    }


    public List<Box> getBoxes() {
        return boxes;
    }

    public Random getRandom() {
        return random;
    }
}
