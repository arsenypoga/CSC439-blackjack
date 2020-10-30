package csc439team6.blackjack;

import csc439team6.blackjack.models.Shoe;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * @author Arseny Poga
 * @version 1.0
 */
public class ShoeTest {
    @Test
    public void pickCard() {
        Shoe shoe = new Shoe(3);
        System.out.println(shoe.cardCount());
        shoe.pickCard();
        assertEquals(shoe.cardCount(), 155);
    }

    @Test(expected = NoSuchElementException.class)
    public void pickCardException() {
        Shoe shoe = new Shoe(0);
        shoe.pickCard();
    }

    @Test
    public void deckCount() {
        Shoe shoe = new Shoe(3);
        assertEquals(3, shoe.deckCount());

        shoe = new Shoe(1);
        for (int i = 0; i < 52; i++)
        {
            shoe.pickCard();
        }

        System.out.println(shoe.cardCount());
        assertEquals(0, shoe.deckCount());
    }

    @Test
    public void cardCount() {
        Shoe shoe = new Shoe(1);
        assertEquals(52, shoe.cardCount());

        shoe = new Shoe(2);
        assertEquals(52*2, shoe.cardCount());

        shoe = new Shoe(3);
        assertEquals(52*3, shoe.cardCount());
    }
}