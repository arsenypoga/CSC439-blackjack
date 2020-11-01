package csc439team6.blackjack.models;

/**
 * @author Arseny Poga
 * @version 1.0
 */
public class Player {
    private final Hand hand;
    private int chips;
    private int bet;

    private static final int MINIMUM_BET = 10;
    private static final int MAXIMUM_BET = 500;

    public Player(int chips) {
        this.chips = chips;
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void addCard(Card card) {
        this.hand.addCard(card);
    }

    public void resetHand() {
        this.hand.clear();
    }

    public int getChips() {
        return chips;
    }

    public void addChips(int chips) {
        this.chips += chips;
    }

    public int getBet() {
        return bet;
    }

    public void resetBet() {
        this.bet = 0;
    }

    public void setBet(int bet) {
        if (bet > chips)
            throw new IndexOutOfBoundsException("bet exceeds available chips");
        else if (bet < MINIMUM_BET)
            throw new IndexOutOfBoundsException("bet less than allowed");
        else if (bet > MAXIMUM_BET)
            throw new IndexOutOfBoundsException("bet more than allowed");

        this.chips -= bet;
        this.bet = bet;
    }
}
