package csc439team6.blackjack;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * @author Greyson Fangman
 * @version 1.0
 */
public class HandTest {

    /**
     * Test case to simulate adding a card to a Hand object using the addCard class method, and comparing to a hard-
     * coded add into a separate ArrayList
     */
    @Test
    public void addCard() {
        Hand hand = new Hand();
        hand.addCard(new Card(Number.TEN, Suit.SPADES));
        ArrayList<Card> testHand = new ArrayList<>();
        testHand.add(new Card(Number.TEN, Suit.SPADES));
        assertEquals(hand.getCards(), testHand);
    }

    /**
     * Test case to ensure the number of cards in a Hand object returns the correct value
     */
    @Test
    public void size() {
        Hand hand = new Hand();
        hand.addCard(new Card(Number.TEN, Suit.SPADES));
        hand.addCard(new Card(Number.NINE, Suit.SPADES));
        assertEquals(hand.size(), 2);
    }

    /**
     * Test case to ensure the correct cards are returned using the getCards class method
     */
    @Test
    public void getCards() {
        Hand hand = new Hand();
        hand.addCard(new Card(Number.TEN, Suit.SPADES));
        hand.addCard(new Card(Number.NINE, Suit.SPADES));
        ArrayList<Card> testHand = new ArrayList<>();
        testHand.add(new Card(Number.TEN, Suit.SPADES));
        testHand.add(new Card(Number.NINE, Suit.SPADES));
        assertEquals(hand.getCards(), testHand);
    }

    /**
     * Test case to ensure that a null card cannot be added to a hand
     */
    @Test(expected = IllegalArgumentException.class)
    public void testThrowsIllegalArgumentException() {
        Hand hand = new Hand();
        hand.addCard(null);
    }
}

