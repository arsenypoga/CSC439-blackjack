package csc439team6.blackjack.controllers;

import csc439team6.blackjack.models.*;
import csc439team6.blackjack.views.AbstractView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author Arseny Poga, Cory Bradford
 * @version 1.0
 */
public class MainController {

    private final Logger logger;
    private AbstractView view;
    private Player player;
    private Dealer dealer;
    private Shoe shoe;

    public MainController(AbstractView view) {
        LogManager.getLogManager().getLogger("").setLevel(Level.WARNING);

        logger = Logger.getLogger(MainController.class.getName());
        logger.entering(getClass().getName(), "MainController");

        this.view = view;
        this.dealer = new Dealer();
        this.shoe = new Shoe(3);
        this.player = new Player(0);

        logger.exiting(getClass().getName(), "MainController");
    }

    /**
     * Starts game sequence
     */
    public void playBlackjack() {
        logger.entering(getClass().getName(), "playBlackjack");

        view.messageGameStarted();
        purchaseChips();

        while(true) {
            makeInitialBet();

            //================================================================================
            // Cut Shoe
            //================================================================================
            shoe.cut();

            //================================================================================
            // Deal and Display initial Hands
            //================================================================================
            player.addCard(shoe.pickCard());
            player.addCard(shoe.pickCard());

            dealer.addCard(shoe.pickCard(), true);
            dealer.addCard(shoe.pickCard());

            displayHand(player, scoreHand(player.getHand()));
            displayHand(dealer, scoreHand(dealer.getHand()));
            Action action = null;

            //================================================================================
            // Determine allowed actions
            //================================================================================
            if (scoreHand(player.getHand()) == 21) {
                view.messagePlayerWin(scoreHand(player.getHand()), scoreHand(dealer.getHand()));
                if (playAgain()) {
                    continue;
                }
            } else if (scoreHand(player.getHand()) >= 9 && scoreHand(player.getHand()) <= 11) {
                action = promptAction(Action.HIT, Action.STAND, Action.DOUBLE);
            } else {
                action = promptAction(Action.HIT, Action.STAND);
            }

            //================================================================================
            // Execute selected action
            //================================================================================
            if (action == Action.HIT) {
                view.messageHit();
                player.addCard(shoe.pickCard());
                view.messageDisplayHand(player, scoreHand(player.getHand()));
            } else if (action == Action.STAND) {
                view.messageStand();
                view.messageDisplayHand(player, scoreHand(player.getHand()));
            } else if (action == Action.DOUBLE) {
                view.messageDouble();
                player.incrementBet(player.getBet());
                player.addCard(shoe.pickCard());
                view.messageDisplayHand(player, scoreHand(player.getHand()));
            }


            // Player bust check
            int playerScore = scoreHand(player.getHand());
            if (playerScore > 21) {
                view.messagePlayerBust();
                view.messageDealerWin(playerScore, scoreHand(dealer.getHand()));
                if (playAgain()) {
                    continue;
                }
            }

            while (action != Action.STAND) {
                action = promptAction(Action.HIT, Action.STAND);
                if (action == Action.STAND) {
                    break;
                }
                view.messageHit();
                player.addCard(shoe.pickCard());
                view.messageDisplayHand(player, scoreHand(player.getHand()));
                if (scoreHand(player.getHand()) > 21) {
                    view.messagePlayerBust();
                    view.messageDealerWin(scoreHand(player.getHand()), scoreHand(dealer.getHand()));
                    if (playAgain()) {
                        continue;
                    }
                }
            }

            //================================================================================
            // Determine if either Player or Dealer have busted
            //================================================================================

            // After all the actions player always stands.
            // Therefore dealer must hit util the condition

            int dealerScore = scoreHand(dealer.getHand());
            view.messageDealersTurn(dealerScore);
            while (dealerScore < 17) {
                dealer.addCard(shoe.pickCard());
                dealerScore = scoreHand(dealer.getHand());
                view.messageDisplayDealerHit(dealerScore);
            }
            // Check if the Dealer has busted
            if (dealerScore > 21) {
                view.messageDealerBust(dealerScore);
                view.messagePlayerWin(playerScore, dealerScore);
                if (playAgain()) {
                    continue;
                }
            }

            //================================================================================
            // Compare Dealer and Player scores
            //================================================================================
            if (dealerScore == playerScore) {
                view.messageTie(dealerScore);
            } else if (dealerScore > playerScore) {
                view.messageDealerWin(playerScore, dealerScore);
            } else {
                view.messagePlayerWin(playerScore, dealerScore);
            }

            playAgain();
            logger.exiting(getClass().getName(), "playBlackjack");
        }
    }


    /**
     * Prompt user to purchase chips.
     */
    public void purchaseChips() {
        logger.entering(getClass().getName(), "purchaseChips");

        try {
            int chips = view.promptPurchaseChips();
            player.addChips(chips);
            logger.log(Level.INFO, "Player purchased {} chips", chips);
        } catch (IOException e) {
            view.messageQuitGame();

            logger.exiting(getClass().getName(), "incrementBet");
            System.exit(0);
        }
        logger.exiting(getClass().getName(), "purchaseChips");
    }

    /**
     * Prompts user for starting bet,
     * if input is incorrect the request is repeated.
     */
    public void makeInitialBet() {
        logger.entering(getClass().getName(), "makeInitialBet");
        try {
            int bet = view.promptInitialBet();
            player.reduceChips(bet);
            player.setBet(bet);
        } catch (IOException e) {

            logger.info("Quit message command received!");

            view.messageQuitGame();

            logger.exiting(getClass().getName(), "makeInitialBet");
            System.exit(0);
        }
        logger.exiting(getClass().getName(), "makeInitialBet");
    }

    public boolean playAgain() {
        logger.entering(getClass().getName(), "playAgain");
        try {
            return view.promptPlayAgain();

        } catch (IOException e) {
            logger.info("Quit message command received!");

            view.messageQuitGame();

            logger.exiting(getClass().getName(), "playAgain");
            System.exit(0);
        }
        logger.exiting(getClass().getName(), "playAgain");
        return false;
    }

    /**
     * Displays hand of a player
     *
     * @param player player
     */
    public void displayHand(AbstractPlayer player, int score) {
        logger.entering(getClass().getName(), "displayHand");
        view.messageDisplayHand(player, score);
        logger.exiting(getClass().getName(), "displayHand");
    }

    /**
     *
     */
    public Action promptAction(Action... allowedAction) {
        logger.entering(getClass().getName(), "promptAction");
        try {
            return view.promptAction(allowedAction);
        } catch (IOException e) {

            logger.info("Quit message command received!");

            view.messageQuitGame();
            logger.exiting(getClass().getName(), "makeInitialBet");
            System.exit(0);
        }
        return null;
    }

    /**
     * deals card to a player.
     * Player can either be a Dealer or a Player
     *
     * @param player player
     */
    public void dealCard(AbstractPlayer player) {
        logger.entering(getClass().getName(), "dealCard");

        Card card = shoe.pickCard();
        logger.log(Level.INFO, "Player received {0}", card);
        player.addCard(card);

        logger.exiting(getClass().getName(), "dealCard");
    }

    /**
     * Increments bet
     */
    public void incrementBet() {
        logger.entering(getClass().getName(), "incrementBet");

        try {
            int bet = view.promptIncrementBet();
            player.reduceChips(bet);

        } catch (IOException e) {
            view.messageQuitGame();

            logger.exiting(getClass().getName(), "incrementBet");
            System.exit(0);
        }
        logger.exiting(getClass().getName(), "incrementBet");
    }

    /**
     * Gets view
     *
     * @return view
     */
    public AbstractView getView() {
        logger.entering(getClass().getName(), "getView");
        logger.exiting(getClass().getName(), "getView");
        return view;

    }

    /**
     * Sets view
     *
     * @param view
     */
    public void setView(AbstractView view) {
        logger.entering(getClass().getName(), "setView");

        this.view = view;

        logger.exiting(getClass().getName(), "setView");
    }

    /**
     * Gets player
     *
     * @return player
     */
    public Player getPlayer() {
        logger.entering(getClass().getName(), "getPlayer");
        logger.exiting(getClass().getName(), "getPlayer");
        return player;
    }

    /**
     * Sets player
     *
     * @param player
     */
    public void setPlayer(Player player) {
        logger.entering(getClass().getName(), "getPlayer");
        this.player = player;
        logger.entering(getClass().getName(), "getPlayer");

    }

    /**
     * Gets dealer
     *
     * @return
     */
    public Dealer getDealer() {
        logger.entering(getClass().getName(), "getDealer");
        logger.exiting(getClass().getName(), "getDealer");
        return dealer;
    }

    /**
     * Sets dealer
     *
     * @param dealer
     */
    public void setDealer(Dealer dealer) {
        logger.entering(getClass().getName(), "setDealer");
        this.dealer = dealer;
        logger.exiting(getClass().getName(), "setDealer");
    }

    /**
     * gets shoe
     *
     * @return
     */
    public Shoe getShoe() {
        logger.entering(getClass().getName(), "getShoe");
        logger.exiting(getClass().getName(), "getShoe");
        return shoe;
    }

    /**
     * Sets shoe
     *
     * @param shoe
     */
    public void setShoe(Shoe shoe) {
        logger.entering(getClass().getName(), "setShoe");
        this.shoe = shoe;
        logger.exiting(getClass().getName(), "setShoe");

    }

    public static int scoreHand(Hand hand) {
        int currentScore = 0;
        ArrayList<Card> currentHand = hand.getCards();
        Collections.sort(currentHand);

        for (Card card : currentHand) {
            if (card.getNumber() == Card.Number.TWO) {
                currentScore += 2;
            } else if (card.getNumber() == Card.Number.THREE) {
                currentScore += 3;
            } else if (card.getNumber() == Card.Number.FOUR) {
                currentScore += 4;
            } else if (card.getNumber() == Card.Number.FIVE) {
                currentScore += 5;
            } else if (card.getNumber() == Card.Number.SIX) {
                currentScore += 6;
            } else if (card.getNumber() == Card.Number.SEVEN) {
                currentScore += 7;
            } else if (card.getNumber() == Card.Number.EIGHT) {
                currentScore += 8;
            } else if (card.getNumber() == Card.Number.NINE) {
                currentScore += 9;
            } else if (card.getNumber() == Card.Number.TEN || card.getNumber() == Card.Number.JACK || card.getNumber() == Card.Number.QUEEN || card.getNumber() == Card.Number.KING) {
                currentScore += 10;
            } else if (card.getNumber() == Card.Number.ACE) {
                if (currentScore + 11 <= 21) {
                    currentScore += 11;
                } else {
                    currentScore += 1;
                }
            }
        }
        return currentScore;
    }
}
