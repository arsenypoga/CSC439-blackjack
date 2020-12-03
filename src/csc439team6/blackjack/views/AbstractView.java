package csc439team6.blackjack.views;

import csc439team6.blackjack.models.AbstractPlayer;
import csc439team6.blackjack.models.Action;
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
     * Purchase initial chips, prompt user
     * @return number of chips purchased.
     */
    public abstract int promptPurchaseChips() throws IOException;

    /**
     * Get initial bet from User.
     * @return
     */
    public abstract int promptInitialBet() throws IOException;

    /**
     * Prompts user for an increment number
     */
    public abstract int promptIncrementBet() throws IOException;

    public abstract Action promptAction(Action ...allowedActions) throws IOException;


    /**
     * A message to indicate to the user that a new game has begun and instructions on how to quit the game.
     * @return void
     */


    /**
     * Displays current hand
     * @param player
     */
    public abstract void messageDisplayHand(AbstractPlayer player, int handScore);
    public abstract void messageGameStarted();
    public abstract void messageHit();
    public abstract void messageStand();
    public abstract void messageDouble();

    public abstract void messageTie(int score);
    public abstract void messagePlayerWin(int playerScore, int dealerScore);
    public abstract void messageDealerWin(int playerScore, int dealerScore);

    public abstract void messagePlayerBust();
    public abstract void messageDealerBust(int score);

    /**
     * Message logs pertaining to dealer
     */
    public abstract void dealersTurn(int currentDealerScore);
    public abstract void messageDisplayDealerHit(int dealerScore);

    /**
     * shows play again game message.
     */
    public abstract boolean playAgain() throws IOException;

    /**
     * shows quit game message.
     */
    public abstract void messageQuitGame();
}
