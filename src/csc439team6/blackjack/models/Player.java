package csc439team6.blackjack.models;

import java.util.logging.Logger;

/**
 * @author Arseny Poga
 * @version 1.0
 */
public class Player extends AbstractPlayer {
    public static final int MINIMUM_BET = 10;
    public static final int MAXIMUM_BET = 500;
    private final Logger logger = Logger.getLogger(Player.class.getName());

    private int chips;
    private int bet;

    /**
     * Creates a player class with set amount of chips and initial bet set to 0
     *
     * @param chips amount of chips to use
     */
    public Player(int chips) {
        super();
        logger.entering(getClass().getName(), "Player");
        this.chips = chips;
        this.bet = 0;
        logger.exiting(getClass().getName(), "Player");

    }

    /**
     * Gets chips
     *
     * @return
     */
    public int getChips() {
        logger.entering(getClass().getName(), "getChips");
        logger.exiting(getClass().getName(), "getChips");

        return chips;
    }

    /**
     * Sets chips
     *
     * @param chips
     */
    public void setChips(int chips) {
        logger.entering(getClass().getName(), "setChips");
        this.chips = chips;
        logger.exiting(getClass().getName(), "setChips");
    }

    /**
     * Adds chips to current chip balance
     *
     * @param chips
     */
    public void addChips(int chips) {
        logger.entering(getClass().getName(), "addChips");
        this.chips += chips;
        logger.exiting(getClass().getName(), "addChips");
    }

    /**
     * Reduces current chip balance
     *
     * @param chips
     */
    public void reduceChips(int chips) {
        logger.entering(getClass().getName(), "reduceChips");
        this.chips -= chips;
        logger.exiting(getClass().getName(), "reduceChips");
    }

    /**
     * Gets bet
     *
     * @return
     */
    public int getBet() {
        logger.entering(getClass().getName(), "getBet");
        logger.exiting(getClass().getName(), "getBet");
        return bet;
    }

    /**
     * Sets bet
     *
     * @param bet
     */
    public void setBet(int bet) {
        logger.entering(getClass().getName(), "setBet");
        this.bet = bet;
        logger.exiting(getClass().getName(), "setBet");
    }

    /**
     * Increments current bet
     *
     * @param bet
     */
    public void incrementBet(int bet) {
        logger.entering(getClass().getName(), "incrementBet");
        this.bet += bet;
        logger.exiting(getClass().getName(), "incrementBet");
    }

    /**
     * Resets bet to 0
     */
    public void resetBet() {
        logger.entering(getClass().getName(), "resetBet");
        this.bet = 0;
        logger.exiting(getClass().getName(), "resetBet");
    }
}



