package csc439team6.blackjack.views;

import csc439team6.blackjack.models.AbstractPlayer;
import csc439team6.blackjack.models.Hand;
import csc439team6.blackjack.models.Player;

import java.io.IOError;
import java.io.IOException;

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
    public abstract int purchaseChips(Player player) throws IOException;

    /**
     * Get initial bet from User.
     * @return
     */
    public abstract int getInitialBet() throws IOException;

    /**
     *
     */
    public abstract int incrementBet() throws IOError;
    public abstract void displayHand(AbstractPlayer player) throws IOError;
    public abstract void showGameStatus() throws IOError; // Same as the above, needs further code
    public abstract void quitGame();
}
