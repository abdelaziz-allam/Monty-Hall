package com.tele2.tvshow.game;

import com.tele2.tvshow.model.Box;
import com.tele2.tvshow.model.GameSettings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game;

    @BeforeEach
    public void setup(){
        game = new Game();
    }

    @Test
    public void testGameConstructor() {
        List<Box> boxes = game.getSettings().getBoxes();
        assertNotNull(boxes);
        assertEquals(3, boxes.size());
        assertEquals(-1, game.getPickedBox());

        boolean hasMoneyBox = false;
        for (Box box : boxes) {
            if (box.isMoneyBox()) {
                hasMoneyBox = true;
                break;
            }
        }
        assertTrue(hasMoneyBox);
    }

    @Test
    public void testPickBox(){
        game.pickBox(1);
        assertEquals(1, game.getPickedBox());
    }

    @Test
    public void testOpenOtherBox(){
        game.pickBox(1);
        game.openOtherBox();

        int openedBox = IntStream.range(0, GameSettings.NUMBER_OF_BOXES)
                .filter(i -> i != game.getPickedBox() && game.getSettings().getBoxes().get(i).isOpen())
                .findFirst()
                .orElse(-1);

        assertNotEquals(-1, openedBox);
        assertFalse(game.getSettings().getBoxes().get(game.getPickedBox()).isOpen());
        assertFalse(game.getSettings().getBoxes().get(openedBox).isMoneyBox());
    }

    @Test
    public void testHasWon(){
        game.pickBox(1);

        boolean result = game.hasWon();
        if (game.getSettings().getBoxes().get(1).isMoneyBox()) {
            assertTrue(result);
        } else {
            assertFalse(result);
        }
    }

}
