package csc439team6.blackjack.models;

import csc439team6.blackjack.models.Card;
import csc439team6.blackjack.models.Hand;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * @author Greyson Fangman
 * @version 1.0
 */
public class HandTest {
    Hand hand;

    @Before
    public void init() {
        hand = new Hand();
    }

    @After
    public void clean() {
        hand = new Hand();
    }

    @Test
    public void addCard() {
        Card card = new Card(Card.Number.TEN, Card.Suit.SPADES);
        hand.addCard(card);
        assertEquals(card, hand.getCards().get(0));
    }

    @Test
    public void size() {
        hand.addCard(new Card(Card.Number.TEN, Card.Suit.SPADES));
        assertEquals(1, hand.size());
        hand.addCard(new Card(Card.Number.NINE, Card.Suit.SPADES));
        assertEquals(2, hand.size());
        hand.clear();
        assertEquals(0, hand.size());

    }
    @Test
    public void getCards() {
        hand.addCard(new Card(Card.Number.TEN, Card.Suit.SPADES));
        hand.addCard(new Card(Card.Number.NINE, Card.Suit.SPADES));
        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(new Card(Card.Number.TEN, Card.Suit.SPADES));
        testHand.add(new Card(Card.Number.NINE, Card.Suit.SPADES));
        assertEquals(hand.getCards(), testHand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowsIllegalArgumentException() {
        hand.addCard(null);
    }

    @Test
    public void testAddCard() {
        Card card = new Card(Card.Number.KING, Card.Suit.DIAMONDS);
        hand.addCard(card);
        assertEquals(card, hand.getCards().get(0));
    }

    @Test
    public void clear() {
        hand.addCard(new Card(Card.Number.KING, Card.Suit.SPADES));
        hand.addCard(new Card(Card.Number.KING, Card.Suit.SPADES));
        hand.addCard(new Card(Card.Number.KING, Card.Suit.SPADES));
        hand.clear();
        assertEquals(0, hand.size());
    }
}

