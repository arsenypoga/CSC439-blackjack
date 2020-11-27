package csc439team6.blackjack.models;

import csc439team6.blackjack.controllers.MainController;

import java.util.logging.Logger;

/**
 * @author Arseny Poga
 * @version 1.0
 */
public abstract class AbstractPlayer {
    private final Hand hand;
    private final Logger logger = Logger.getLogger(MainController.class.getName());

    /**
     * Protected constructor to prevent instantiation of a base player class.
     */
    protected AbstractPlayer() {
        this.hand = new Hand();
    }

    /**
     * Gets hand
     * @return Hand
     */
    public Hand getHand() {
        logger.entering(getClass().getName(), "getHand");
        logger.exiting(getClass().getName(), "getHand");
         return hand;
    }

    /**
     * Adds card to the Hand
     * @param card Card
     */
    public void addCard(Card card) {
        logger.entering(getClass().getName(), "addCard");
        this.hand.addCard(card);
        logger.exiting(getClass().getName(), "addCard");
    }

    /**
     * Resets hand
     */
    public void resetHand() {
        logger.entering(getClass().getName(), "resetHand");

        this.hand.clear();
        logger.exiting(getClass().getName(), "resetHand");
    }
}
