package csc439team6.blackjack.models;

/**
 * @author Arseny Poga
 * @version 1.0
 */
public class Player extends AbstractPlayer {
    public static final int MINIMUM_BET = 10;
    public static final int MAXIMUM_BET = 500;
    private int chips;
    private int bet;

    public Player(int chips) {
        super();
        this.chips = chips;
        this.bet = 0;
    }

    /**
     * Gets chips
     * @return
     */
    public int getChips() {
        return chips;
    }

    /**
     * Adds chips to current chip balance
     * @param chips
     */
    public void addChips(int chips) {
        this.chips += chips;
    }

    /**
     * Reduces current chip balance
     * @param chips
     */
    public void reduceChips(int chips) {
        this.chips -= chips;
    }

    /**
     * Gets bet
     * @return
     */
    public int getBet() {
        return bet;
    }

    /**
     * Increments current bet
     * @param bet
     */
    public void incrementBet(int bet) {
            this.bet += bet;
    }

    /**
     * Resets bet to 0
     */
    public void resetBet() {
        this.bet = 0;
    }

    /**
     * Sets chips
     * @param chips
     */
    public void setChips(int chips) {
        this.chips = chips;
    }

    /**
     * Sets bet
     * @param bet
     */
    public void setBet(int bet) {
        this.bet = bet;
    }
}



