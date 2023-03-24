package com.tele2.tvshow.game;

import com.tele2.tvshow.model.Box;
import com.tele2.tvshow.model.GameSettings;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

//Game object that represents the TV show game
public class Game {
    private GameSettings settings;
    private Random random;
    private int chosenBox;

    // initialize the Gate data
    public Game(){
        init();
    }

    private void init() {
        settings = new GameSettings();
        chosenBox = -1;
        random = new Random();
    }

    public void pickBox(int index) {
        chosenBox = index;
    }

    public void openOtherBox() {
        int boxToOpen = -1;
        List<Box> boxes = settings.getBoxes();
        do {
            boxToOpen = random.nextInt(GameSettings.NUMBER_OF_BOXES);
        } while (boxToOpen == chosenBox || boxes.get(boxToOpen).isMoneyBox());
        boxes.get(boxToOpen).setOpen(true);
    }

    public void switchBox() {
        IntStream.range(0, GameSettings.NUMBER_OF_BOXES)
                .filter(i -> i != chosenBox && !settings.getBoxes().get(i).isOpen())
                .findFirst()
                .ifPresent(i -> chosenBox = i);
    }


    public boolean hasWon() {
        return settings.getBoxes().get(chosenBox).isMoneyBox();
    }

    public int getPickedBox(){
        return chosenBox;
    }

    public GameSettings getSettings() {
        return settings;
    }
}
