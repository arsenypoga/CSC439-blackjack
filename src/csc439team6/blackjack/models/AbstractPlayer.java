package csc439team6.blackjack.models;

/**
 * @author Arseny Poga
 * @version 1.0
 */
public abstract class AbstractPlayer {
    private final Hand hand;

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
        return hand;
    }

    /**
     * Adds card to the Hand
     * @param card Card
     */
    public void addCard(Card card) {
        this.hand.addCard(card);
    }

    /**
     * Resets hand
     */
    public void resetHand() {
        this.hand.clear();
    }
}
