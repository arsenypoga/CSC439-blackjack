package csc439team6.blackjack.models;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Shoe class simulates a shoe of multiple decks in blackjack
 *
 * @author Arseny Poga
 * @version 1.0
 */
public class Shoe {
    private final Random RANDOM = new Random();
    private final Logger logger = Logger.getLogger(Shoe.class.getName());
    private final ArrayList<Deck> decks = new ArrayList<>();
    private final int minimumSize;
    private final int initialDeckCount;

    /**
     * Creates a Shoe which is a set of decks
     *
     * @param deckNumber number of decks
     */
    public Shoe(int deckNumber) {
        logger.entering(getClass().getName(), "Shoe");
        initialDeckCount = deckNumber;

        for (int i = 0; i < deckNumber; i++) {
            decks.add(new Deck());
        }

        minimumSize = this.cardCount() / 5;
        logger.exiting(getClass().getName(), "Shoe");
    }

    /**
     * This method picks a random card from the set of decks.
     *
     * @return Card a random card
     */
    public Card pickCard() {
        logger.entering(getClass().getName(), "pickCard");
        if (decks.isEmpty()) {
            logger.warning("Shoe is empty");
            throw new NoSuchElementException();
        }

        int deckLocation = RANDOM.nextInt(decks.size());
        Deck deck = decks.get(deckLocation);
        Card card = deck.pickCard();

        if (deck.isEmpty()) {
            logger.log(Level.INFO, "Removing deck {0}", deckLocation);
            decks.remove(deckLocation);
        }
        logger.exiting(getClass().getName(), "pickCard");
        return card;
    }

    /**
     * This method returns the count of decks currently held.
     *
     * @return int deck count
     */
    public int deckCount() {
        logger.entering(getClass().getName(), "deckCount");
        logger.exiting(getClass().getName(), "deckCount");
        return decks.size();
    }

    /**
     * This method returns the total card count that is available.
     *
     * @return int card count
     */
    public int cardCount() {
        logger.entering(getClass().getName(), "cardCount");
        int count = 0;

        for (Deck d : decks) {
            count += d.size();
        }
        logger.exiting(getClass().getName(), "cardCount");
        return count;
    }

    /**
     * Cut the shoe. This repopulates the shoe with the same number of decks as it had before
     */
    public void cut() {
        logger.entering(getClass().getName(), "shoe cut");

        if (cardCount() <= minimumSize) {
            this.decks.clear();
            for (int i = 0; i < initialDeckCount; i++) {
                this.decks.add(new Deck());
            }
        }

        logger.exiting(getClass().getName(), "shoe cut");
    }
}