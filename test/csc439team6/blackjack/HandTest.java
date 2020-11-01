package csc439team6.blackjack;

import csc439team6.blackjack.models.Card;
import csc439team6.blackjack.models.Hand;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * @author Greyson Fangman
 * @version 1.0
 */
public class HandTest {


    @Test
    public void addCard() {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.Number.TEN, Card.Suit.SPADES));
        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(new Card(Card.Number.TEN, Card.Suit.SPADES));
        assertEquals(hand.getCards(), testHand);
    }

    @Test
    public void size() {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.Number.TEN, Card.Suit.SPADES));
        hand.addCard(new Card(Card.Number.NINE, Card.Suit.SPADES));
        assertEquals(hand.size(), 2);
    }
    @Test
    public void getCards() {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.Number.TEN, Card.Suit.SPADES));
        hand.addCard(new Card(Card.Number.NINE, Card.Suit.SPADES));
        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(new Card(Card.Number.TEN, Card.Suit.SPADES));
        testHand.add(new Card(Card.Number.NINE, Card.Suit.SPADES));
        assertEquals(hand.getCards(), testHand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowsIllegalArgumentException() {
        Hand hand = new Hand();
        hand.addCard(null);
    }
}

