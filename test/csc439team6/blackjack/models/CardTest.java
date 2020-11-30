package csc439team6.blackjack.models;

import csc439team6.blackjack.models.Card;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Arseny Poga, Cory Bradford, Greyson Fangman
 * @version 1.0
 */
public class CardTest {

    @org.junit.Test
    public void getNumberTest() {
        Card card = new Card(Card.Number.TEN, Card.Suit.SPADES);
        assertEquals(card.getNumber(), Card.Number.TEN);
    }

    @org.junit.Test
    public void getSuitTest() {
        Card card = new Card(Card.Number.TEN, Card.Suit.SPADES);
        assertEquals(card.getSuit(), Card.Suit.SPADES);
    }

    @org.junit.Test
    public void testEquals() {
        Card card1 = new Card(Card.Number.TEN, Card.Suit.SPADES);
        Card card2 = new Card(Card.Number.TEN, Card.Suit.SPADES);
        Card card3 = new Card(Card.Number.NINE, Card.Suit.SPADES);
        assertEquals(card1, card2);
        assertNotEquals(card1, card3);

    }

    @Test
    public void testToString() {
        Card card = new Card(Card.Number.TEN, Card.Suit.SPADES);
        assertEquals("<Card Number=(TEN) Suit=(SPADES)>", card.toString());
    }

    /**
     * Test method to check that the hashcode of two card objects with the same properties will return
     * the same hash value.
     */ 
    @Test
    public void matchingHashTest() {
        Card card1 = new Card(Card.Number.TEN, Card.Suit.SPADES);
        Card card2 = new Card(Card.Number.TEN, Card.Suit.SPADES);
        assertEquals(card1.hashCode(), card2.hashCode());
    }

    /**
     * Test method to check that the hashcode of two card objects with different properties will NOT return the same
     * hash value.
     */
    @Test
    public void nonMatchingHashTest() {
        Card card1 = new Card(Card.Number.TEN, Card.Suit.SPADES);
        Card card2 = new Card(Card.Number.NINE, Card.Suit.SPADES);
        assertNotEquals(card1.hashCode(), card2.hashCode());
    }


    @Test
    public void isVisible() {
        Card card1 = new Card(Card.Number.TEN, Card.Suit.SPADES);
        assertFalse(card1.isVisible());
        card1.setVisible(true);
        assertTrue(card1.isVisible());
    }
    @Test
    public void setVisible() {
        Card card1 = new Card(Card.Number.TEN, Card.Suit.SPADES);
        card1.setVisible(true);
        assertTrue(card1.isVisible());
    }

}