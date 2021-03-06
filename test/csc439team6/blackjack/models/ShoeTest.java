package csc439team6.blackjack.models;

import csc439team6.blackjack.models.Shoe;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * @author Arseny Poga
 * @version 1.0
 */
public class ShoeTest {

    /**
     * Test case to simulate the picking of one card from a shoe of size 3
     */
    @Test
    public void pickCard() {
        Shoe shoe = new Shoe(3);
        System.out.println(shoe.cardCount());
        shoe.pickCard();
        assertEquals(shoe.cardCount(), 155);
    }

    /**
     * Test case to ensure that a card cannot be picked when no shoes exist/all shoes are depleted
     */
    @Test(expected = NoSuchElementException.class)
    public void pickCardException() {
        Shoe shoe = new Shoe(0);
        shoe.pickCard();
    }

    /**
     * Test case to test: 1. That the number of decks remaning in the shoe is correct 2. That a deck of size 1 will be
     * removed from the collection once all cards have been picked
     */
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

    /**
     * Test method to ensure that the number of cards in the shoe is correct based on new decks inserted into the shoe
     */
    @Test
    public void cardCount() {
        Shoe shoe = new Shoe(1);
        assertEquals(52, shoe.cardCount());

        shoe = new Shoe(2);
        assertEquals(52*2, shoe.cardCount());

        shoe = new Shoe(3);
        assertEquals(52*3, shoe.cardCount());
    }

    @Test
    public void cut() {
        Shoe shoe = new Shoe(1);
        for (int i = 0; i < 45; i++) {
            shoe.pickCard();
        }

        shoe.cut();
        assertEquals(52, shoe.cardCount());

    }
}