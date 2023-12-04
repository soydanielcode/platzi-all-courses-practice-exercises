package org.platzi.javatests.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void without_mockito_looses_when_dice_number_is_low() {
        Dice dice = new Dice(6);
        Player player = new Player(dice, 1);
        assertEquals(false, player.play());
    }

    @Test
    public void wins_when_dice_number_is_low() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);

        Player player = new Player(dice, 3);
        assertTrue(player.play());
    }
    @Test
    public void looses_when_dice_number_is_low() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(1);

        Player player = new Player(dice, 3);
        assertFalse(player.play());
    }
}