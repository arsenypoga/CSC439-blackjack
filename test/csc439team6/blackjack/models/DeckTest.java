package csc439team6.blackjack.models;

import csc439team6.blackjack.models.Card;
import csc439team6.blackjack.models.Deck;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DeckTest {

    /**
     * test method which uses a nested for loop to ensure there are no duplicate cards within the deck when the
     * class is initialized. Every combination of any two cards is tested.
     */
    @Test
    public void fillDeckTest() {
        Card card1, card2;
        Deck deck = new Deck();
        card1 = deck.pickCard();

        while (!deck.isEmpty()) {
              card2 = deck.pickCard();

              assertNotEquals(card1, card2);
              card1 = card2;
            }
    }

    /**
     * test method which will make sure that a depleted deck of card will throw an index out of bounds exception
     * done through picking 52 cards and then trying to pick a 53rd
     */
    @Test (expected = NoSuchElementException.class)
    public void emptyDeckTest() {
        Deck deck = new Deck();
        for(int i = 0; i < 53; i++) {
            deck.pickCard();
        }
    }

    /**
     * test method to test the deck size each time a card is drawn until the deck is empty.
     */
    @Test
    public void sizeTest() {
        Deck deck = new Deck();
        for(int i = 52; i > 0; i--) {
            assertEquals(i, deck.size());
            deck.pickCard();
        }
    }

}