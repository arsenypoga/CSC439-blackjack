package csc439team6.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a hand of a blackjack game.
 *
 * This only represents the hand.
 *
 * @author Greyson Fangman
 * @version 1.0
 *
 *
 * The hand object should be initialized with an empty collection of cards.
 * The addCard method should take a card as a parameter and add it to the hand.
 * The getCards method should return the collection of cards currently in the hand.
 * The size method should return the number of cards currently in the hand.
 * Write appropriate JUnit tests to ensure all of the above logic works correctly.
 */
public class Hand {
    private final ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }
    
    /**
     * The addCard method should take a card as a parameter and add it to the hand.
     *
     * @return addedCard
     */
    public void addCard(Card c) {
        if (c == null)
            throw new IllegalArgumentException("Can't add a null card to a hand.");
        cards.add(c);
    }

    /**
     * returns number of cards in hand.
     *
     * @return size
     */
    public int size() {
        return cards.size();
    }

    /**
     * The getCards method should return the collection of cards currently in the hand.
     *
     * @return getCard
     */
    public List<Card> getCards() {
        return cards;
    }

}
