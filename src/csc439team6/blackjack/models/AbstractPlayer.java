package csc439team6.blackjack.models;

/**
 * @author Arseny Poga
 * @version 1.0
 */
public abstract class AbstractPlayer {
    private final Hand hand;

    protected AbstractPlayer() {
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
}
