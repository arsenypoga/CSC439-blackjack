package csc439team6.blackjack.models;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
    private ArrayList<Card> cards;
    private final Logger logger = Logger.getLogger(Hand.class.getName());

    public Hand() {
        logger.entering(getClass().getName(), "Hand");
        cards = new ArrayList<>();
        logger.exiting(getClass().getName(), "Hand");
    }
    
    /**
     * The addCard method should take a card as a parameter and add it to the hand.
     *
     * @return addedCard
     */
    public void addCard(Card c) {
        logger.entering(getClass().getName(), "addCard");
        if (c == null) {
            logger.warning("Adding null to Hand");
            throw new IllegalArgumentException("Can't add a null card to a hand.");
        }
        cards.add(c);
        logger.exiting(getClass().getName(), "addCard");
    }

    /**
     * returns number of cards in hand.
     *
     * @return size
     */
    public int size() {
        logger.entering(getClass().getName(), "size");
        logger.exiting(getClass().getName(), "size");
        return cards.size();
    }

    /**
     * The getCards method should return the collection of cards currently in the hand.
     *
     * @return getCard
     */
    public ArrayList<Card> getCards() {
        logger.entering(getClass().getName(), "getCards");
        logger.exiting(getClass().getName(), "getCards");
        return cards;
    }

    public void clear() {
        logger.entering(getClass().getName(), "clear");
        logger.exiting(getClass().getName(), "clear");
        this.cards.clear();
    }

}
