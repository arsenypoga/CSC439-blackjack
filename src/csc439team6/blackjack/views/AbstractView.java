package csc439team6.blackjack.views;

import csc439team6.blackjack.models.BasePlayer;
import csc439team6.blackjack.models.Hand;
import csc439team6.blackjack.models.Player;

/**
 * @author Arseny Poga
 * @version 1.0
 */
public abstract class AbstractView {
    /**
     * Purchase initial chips, prompt user
     * @return number of chips purchased.
     */
    public abstract int purchaseChips();

    /**
     * Get initial bet from User.
     * @return
     */
    public abstract int getInitialBet();



    /**
     *
     */
    public abstract int incrementBet();
    public abstract void numberOfChips(); // WTF does this do?
    public abstract void displayHand(Hand hand); // Going to be tied in later
    public abstract void showGameStatus(); // Same as the above, needs further code
    public abstract void promptQuitGame(); // If any input is quit: prompt is user REALLY wants to quit.

}
