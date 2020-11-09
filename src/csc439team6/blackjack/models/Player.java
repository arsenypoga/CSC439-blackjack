package csc439team6.blackjack.models;

/**
 * @author Arseny Poga
 * @version 1.0
 */
public class Player extends AbstractPlayer {
    private static final int MINIMUM_BET = 10;
    private static final int MAXIMUM_BET = 500;
    private int chips;
    private int bet;

    public Player(int chips) {
        super();
        this.chips = chips;
        this.bet = 0;
    }


    public int getChips() {
        return chips;
    }

    public void addChips(int chips) {
        this.chips += chips;
    }

    public void reduceChips(int chips) {
        this.chips -= chips;
    }

    public int getBet() {
        return bet;
    }

    public void incrementBet(int bet) {
        int totalBet = this.bet + bet;
        if (totalBet > chips)
            throw new IndexOutOfBoundsException("bet exceeds available chips");
        else if (totalBet < MINIMUM_BET)
            throw new IndexOutOfBoundsException("bet less than allowed");
        else if (totalBet > MAXIMUM_BET)
            throw new IndexOutOfBoundsException("bet more than allowed");
        this.bet = totalBet;
    }

    public void resetBet() {
        this.bet = 0;
    }
}
