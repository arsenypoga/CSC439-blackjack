package csc439team6.blackjack.views;

import csc439team6.blackjack.models.Hand;
import csc439team6.blackjack.models.Player;

/**
 * @author Arseny Poga
 * @version 1.0
 */
public abstract class AbstractView {

    public abstract void purchaseChips(Player player);
    public abstract void makeBet(Player player);
    public abstract void numberOfChips(Player player);
    public abstract void dealCards(); //need to revisit parameters
    public abstract void displayHand(Hand hand);
    public abstract void gameStatus();
    public abstract void quitGame();

}
