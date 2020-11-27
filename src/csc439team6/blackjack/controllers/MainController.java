package csc439team6.blackjack.controllers;

import csc439team6.blackjack.models.*;
import csc439team6.blackjack.views.AbstractView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Arseny Poga, Cory Bradford
 * @version 1.0
 */
public class MainController {

    private AbstractView view;
    private Player player;
    private Dealer dealer;
    private Shoe shoe;
    private final Logger logger = Logger.getLogger(MainController.class.getName());

    public MainController(AbstractView view) {
        logger.entering(getClass().getName(), "MainController");

        this.view = view;
        this.dealer = new Dealer();
        this.shoe =  new Shoe(3);
        this.player = new Player(0);

        logger.exiting(getClass().getName(), "MainController");
    }

    /**
     * Starts game sequence
     */
    public void playBlackjack() {
        logger.entering(getClass().getName(), "playBlackjack");

        view.gameStartedMessage();
        purchaseChips();
        makeInitialBet();

        this.player.addCard(shoe.pickCard());
        this.player.addCard(shoe.pickCard());

        this.dealer.addCard(shoe.pickCard());
        this.dealer.addCard(shoe.pickCard());

        displayHand(player);
        displayHand(dealer);

        logger.exiting(getClass().getName(), "playBlackjack");
    }

    /**
     * Prompt user to purchase chips.
     *
     */
    public void purchaseChips() {
        logger.entering(getClass().getName(), "purchaseChips");

        try {
            int chips = view.purchaseChips();
            player.addChips(chips);
            logger.log(Level.INFO,  "Player purchased {} chips", chips);
        } catch (IOException e) {
            view.quitGame();

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
            int bet = view.getInitialBet();
            player.reduceChips(bet);
            player.setBet(bet);
        } catch (IOException e) {

            logger.info("Quit message command received!");

            view.quitGame();

            logger.exiting(getClass().getName(), "makeInitialBet");
            System.exit(0);
        }
        logger.exiting(getClass().getName(), "makeInitialBet");
    }

    /**
     * Displays hand of a player
     * @param player player
     */
    public void displayHand(AbstractPlayer player) {
        logger.entering(getClass().getName(), "displayHand");
        view.displayHand(player);
        logger.exiting(getClass().getName(), "displayHand");
    }

    /**
     * deals card to a player.
     * Player can either be a Dealer or a Player
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
            int bet = view.incrementBet();
            player.reduceChips(bet);

        } catch (IOException e) {
            view.quitGame();

            logger.exiting(getClass().getName(), "incrementBet");
            System.exit(0);
        }
        logger.exiting(getClass().getName(), "incrementBet");
    }

    /**
     * Gets view
     * @return view
     */
    public AbstractView getView() {
        logger.entering(getClass().getName(), "getView");
        logger.exiting(getClass().getName(), "getView");
        return view;

    }

    /**
     * Sets view
     * @param view
     */
    public void setView(AbstractView view) {
        logger.entering(getClass().getName(), "setView");

        this.view = view;

        logger.exiting(getClass().getName(), "setView");
    }

    /**
     * Gets player
     * @return player
     */
    public Player getPlayer() {
        logger.entering(getClass().getName(), "getPlayer");
        logger.exiting(getClass().getName(), "getPlayer");
        return player;
    }

    /**
     * Sets player
     * @param player
     */
    public void setPlayer(Player player) {
        logger.entering(getClass().getName(), "getPlayer");
        this.player = player;
        logger.entering(getClass().getName(), "getPlayer");

    }

    /**
     * Gets dealer
     * @return
     */
    public Dealer getDealer() {
        logger.entering(getClass().getName(), "getDealer");
        logger.exiting(getClass().getName(), "getDealer");
        return dealer;
    }

    /**
     * Sets dealer
     * @param dealer
     */
    public void setDealer(Dealer dealer) {
        logger.entering(getClass().getName(), "setDealer");
        this.dealer = dealer;
        logger.exiting(getClass().getName(), "setDealer");
    }

    /**
     * gets shoe
     * @return
     */
    public Shoe getShoe() {
        logger.entering(getClass().getName(), "getShoe");
        logger.exiting(getClass().getName(), "getShoe");
        return shoe;
    }

    /**
     * Sets shoe
     * @param shoe
     */
    public void setShoe(Shoe shoe) {
        logger.entering(getClass().getName(), "setShoe");
        this.shoe = shoe;
        logger.exiting(getClass().getName(), "setShoe");

    }
}
