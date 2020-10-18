package csc439team6.blackjack;

import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {

    /**
     * test method which uses a nested for loop to ensure there are no duplicate cards within the deck when the
     * class is initialized. Every combination of any two cards is tested.
     */
    @Test
    public void fillDeckTest() {
        Deck deck = new Deck();
        for(int i = 0; i < 52; i++) {
            Card card1 = deck.getCards().get(i);
            for(int j = i + 1; j < deck.getSize(); j++) {
                Card card2 = deck.getCards().get(j);
                assertNotEquals(card1, card2);
            }
        }
    }

    /**
     * test method which will make sure that a depleted deck of card will throw an index out of bounds exception
     * done through picking 52 cards and then trying to pick a 53rd
     */
    @Test (expected = IndexOutOfBoundsException.class)
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
    public void getSizeTest() {
        Deck deck = new Deck();
        for(int i = 52; i > 0; i--) {
            assertEquals(i, deck.getSize());
            deck.pickCard();
        }
    }

}