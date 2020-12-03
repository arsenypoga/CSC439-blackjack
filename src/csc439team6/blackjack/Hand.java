package csc439team6.blackjack;

import csc439team6.blackjack.models.Card;

import java.util.ArrayList;
/**
 * This is a hand of a blackjack game.
 *
 * This only represents the hand.
 *
 * @author Greyson Fangman
 * @version 1.0
 */
/*
The hand object should be initialized with an empty collection of cards.
The addCard method should take a card as a parameter and add it to the hand.
The getCards method should return the collection of cards currently in the hand.
The size method should return the number of cards currently in the hand.
Write appropriate JUnit tests to ensure all of the above logic works correctly.
 */
public class Hand {
    private ArrayList<Card> hand;
    /**
     * The hand object should be initialized with an empty collection of cards.
     * @return hand
     */
    public Hand() {
        hand = new ArrayList<Card>();
    }

    /**
     * Clears the cards that are in hand
     *
     * @return clear
     */
    public void clear() {
        hand.clear();
    }
    /**
     * The addCard method should take a card as a parameter and add it to the hand.
     *
     * @return addedCard
     */
    public void addCard(Card c) {
        if (c == null)
            throw new NullPointerException("Can't add a null card to a hand.");
        hand.add(c);
    }

    /**
     * returns number of cards in hand.
     *
     * @return size
     */
    public int size() {
        return hand.size();
    }

    /**
     * The getCards method should return the collection of cards currently in the hand.
     *
     * @return getCard
     */
    public ArrayList getCards() {
        return hand;
    }

}
