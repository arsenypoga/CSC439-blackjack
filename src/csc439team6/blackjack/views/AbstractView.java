package csc439team6.blackjack.views;

import csc439team6.blackjack.models.BasePlayer;
import csc439team6.blackjack.models.Hand;
import csc439team6.blackjack.models.Player;

/**
 * @author Arseny Poga, Cory Bradford
 * @version 1.0
 */
public abstract class AbstractView {

    /**
     * A message to indicate to the user that a new game has begun and instructions on how to quit the game.
     * @return void
     */
    public abstract void gameStartedMessage();

    /**
     * Purchase initial chips, prompt user
     * @return number of chips purchased.
     */
    public abstract int purchaseChips(Player player);

    /**
     * Get initial bet from User.
     * @return
     */
    public abstract int getInitialBet();

    /**
     *
     */
    public abstract int incrementBet();
    public abstract void displayPlayerHand(Hand hand);
    public abstract void displayDealerHand(Hand hand);
    public abstract void showGameStatus(); // Same as the above, needs further code
    public abstract boolean quitGame(); // If any input is quit: prompt is user REALLY wants to quit.
}
