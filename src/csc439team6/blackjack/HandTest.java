package csc439team6.blackjack;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * @author Greyson Fangman
 * @version 1.0
 */
public class HandTest {
    private Object Card;

    @org.junit.Test
    public void clear() {
        Hand hand = new Hand();
        hand.addCard(new Card(Number.TEN, Suit.SPADES));
        hand.clear();
        ArrayList<Card> testHand = new ArrayList<Card>();
        assertEquals(hand.size(), testHand.size());
    }

    @org.junit.Test
    public void addCard() {
        Hand hand = new Hand();
        hand.addCard(new Card(Number.TEN, Suit.SPADES));
        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(new Card(Number.TEN, Suit.SPADES));
        assertEquals(hand.getCards(), testHand);
    }

    @Test
    public void size() {
        Hand hand = new Hand();
        hand.addCard(new Card(Number.TEN, Suit.SPADES));
        hand.addCard(new Card(Number.NINE, Suit.SPADES));
        assertEquals(hand.size(), 2);
    }
    @org.junit.Test
    public void getCards() {
        Hand hand = new Hand();
        hand.addCard(new Card(Number.TEN, Suit.SPADES));
        hand.addCard(new Card(Number.NINE, Suit.SPADES));
        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(new Card(Number.TEN, Suit.SPADES));
        testHand.add(new Card(Number.NINE, Suit.SPADES));
        assertEquals(hand.getCards(), testHand);
    }
}

