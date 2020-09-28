package csc439team6.blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Arseny Poga, Cory Bradford, Greyson Fangman
 * @version 1.0
 */
public class CardTest {

    @org.junit.Test
    public void getNumberTest() {
        Card card = new Card(Number.TEN, Suit.SPADES);
        assertEquals(card.getNumber(), Number.TEN);
    }

    @org.junit.Test
    public void getSuitTest() {
        Card card = new Card(Number.TEN, Suit.SPADES);
        assertEquals(card.getSuit(), Suit.SPADES);
    }

    @org.junit.Test
    public void testEquals() {
        Card card1 = new Card(Number.TEN, Suit.SPADES);
        Card card2 = new Card(Number.TEN, Suit.SPADES);
        Card card3 = new Card(Number.NINE, Suit.SPADES);
        assertEquals(card1, card2);
        assertNotEquals(card1, card3);

    }

    @Test
    public void testToString() {
        Card card = new Card(Number.TEN, Suit.SPADES);
        assertEquals("<Card Number=(TEN) Suit=(SPADES)>", card.toString());
    }

    /**
     * Test method to check that the hashcode of two card objects with the same properties will return
     * the same hash value.
     */
    @Test
    public void matchingHashTest() {
        Card card1 = new Card(Number.TEN, Suit.SPADES);
        Card card2 = new Card(Number.TEN, Suit.SPADES);
        assertEquals(card1.hashCode(), card2.hashCode());
    }

    /**
     * Test method to check that the hashcode of two card objects with different properties will NOT return the same
     * hash value.
     */
    @Test
    public void nonMatchingHashTest() {
        Card card1 = new Card(Number.TEN, Suit.SPADES);
        Card card2 = new Card(Number.NINE, Suit.SPADES);
        assertNotEquals(card1.hashCode(), card2.hashCode());
    }
}