package csc439team6.blackjack.views;

import csc439team6.blackjack.models.AbstractPlayer;
import csc439team6.blackjack.models.Action;

import java.io.IOException;

/**
 * @author Arseny Poga, Cory Bradford
 * @version 1.0
 */
public abstract class AbstractView {

    /**
     * Purchase initial chips, prompt user
     *
     * @return number of chips purchased.
     */
    public abstract int promptPurchaseChips() throws IOException;

    /**
     * Get initial bet from User.
     *
     * @return
     */
    public abstract int promptInitialBet() throws IOException;

    /**
     * Prompts user for an increment number
     */
    public abstract int promptIncrementBet() throws IOException;

    public abstract Action promptAction(Action... allowedActions) throws IOException;

    /**
     * shows play again game message.
     */
    public abstract boolean promptPlayAgain() throws IOException;


    /**
     * A message to indicate to the user that a new game has begun and instructions on how to quit the game.
     * @return void
     */


    /**
     * Displays current hand
     *
     * @param player
     */
    public abstract void messageDisplayHand(AbstractPlayer player, int handScore);

    /**
     * Displays game started message
     */
    public abstract void messageGameStarted();

    /**
     * Displays hit message
     */
    public abstract void messageHit();

    /**
     * Displays Stand message
     */
    public abstract void messageStand();

    /**
     * Displays double message
     */
    public abstract void messageDouble();

    /**
     * Displays tie message
     *
     * @param score single tie score
     */
    public abstract void messageTie(int score);

    /**
     * Displays Player win message
     *
     * @param playerScore player score
     * @param dealerScore dealer score
     */
    public abstract void messagePlayerWin(int playerScore, int dealerScore);

    /**
     * Displays Dealer win message
     *
     * @param playerScore player score
     * @param dealerScore dealer score
     */
    public abstract void messageDealerWin(int playerScore, int dealerScore);

    /**
     * Displays player bust message
     */
    public abstract void messagePlayerBust();

    /**
     * Displays dealer bust message
     *
     * @param score
     */
    public abstract void messageDealerBust(int score);

    /**
     * Message logs pertaining to dealer
     */
    public abstract void messageDealersTurn(int currentDealerScore);

    /**
     * Displays dealer hit message
     *
     * @param dealerScore dealer score
     */
    public abstract void messageDisplayDealerHit(int dealerScore);


    /**
     * shows quit game message.
     */
    public abstract void messageQuitGame();
}
