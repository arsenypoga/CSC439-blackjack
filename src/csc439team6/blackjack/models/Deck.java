package csc439team6.blackjack.models;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Deck class which will simulate a deck of 2 unique playing cards. When the constructor is called it will call the
 * fillDeck() method to fill an ArrayList with a collection of all 52 cards.
 * Functionality for picking a card and getting the remaning size of the deck is included.
 * @author Cory Bradford
 * @version 1.0
 */
public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();
    private final Random RANDOM = new Random();
    private final Logger logger = Logger.getLogger(Deck.class.getName());

    public Deck() {
        logger.entering(getClass().getName(), "Deck");
        for(Card.Suit suit : Card.Suit.values()) {
            for(Card.Number number: Card.Number.values()) {
                Card card = new Card(number, suit);
                cards.add(card);
            }
        }
        logger.exiting(getClass().getName(), "Deck");
    }


    /**
     * method used to pick a random Card object from the defined collection.
     * if the size of the collection is <= 0 and exception will be thrown.
     * @return cardPicked Card
     *
     */
    public Card pickCard() {
        logger.entering(getClass().getName(), "pickCard");

        if(cards.isEmpty()) {
            logger.log(Level.WARNING, "Deck is empty");
            throw new NoSuchElementException();

        } else {
            int cardLocation = RANDOM.nextInt(cards.size());
            Card cardPicked = cards.get(cardLocation);
            cards.remove(cardPicked);

            logger.exiting(getClass().getName(), "pickCard");
            return cardPicked;
        }
    }

    /**
     * returns the current size of the deck
     * @return int
     */
    public int size() {
        logger.entering(getClass().getName(), "size");
        logger.exiting(getClass().getName(), "size");
        return cards.size();
    }

    /**
     * Is the Deck empty?
     * @return boolean isEmpty
     */
    public boolean isEmpty() {
        logger.entering(getClass().getName(), "isEmpty");
        logger.exiting(getClass().getName(), "isEmpty");
        return this.cards.isEmpty();
    }
}