package csc439team6.blackjack.controllers;

import csc439team6.blackjack.models.*;
import csc439team6.blackjack.views.AbstractView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Arseny Poga, Cory Bradford
 * @version 1.0
 */
public class MainController {

    private AbstractView view;
    private Player player;
    private Dealer dealer;
    private Shoe shoe;

    public MainController(AbstractView view) {
        this.view = view;
        this.dealer = new Dealer();
        this.shoe =  new Shoe(3);
        this.player = new Player(0);
    }

    /**
     * Starts game sequence
     */
    public void playBlackjack() {
        view.gameStartedMessage();
        purchaseChips();
        makeInitialBet();

        this.player.addCard(shoe.pickCard());
        this.player.addCard(shoe.pickCard());

        this.dealer.addCard(shoe.pickCard());
        this.dealer.addCard(shoe.pickCard());

        displayHand(player);
        displayHand(dealer);

    }

    /**
     * Prompt user to purchase chips.
     *
     */
    public void purchaseChips() {
        try {
            int chips = view.purchaseChips();
            player.addChips(chips);
        } catch (IOException e) {
            view.quitGame();
            System.exit(0);
        }
    }

    /**
     * Prompts user for starting bet,
     * if input is incorrect the request is repeated.
     */
    public void makeInitialBet() {
        try {
            int bet = view.getInitialBet();
            player.reduceChips(bet);
            player.setBet(bet);
        } catch (IOException e) {
            view.quitGame();
            System.exit(0);
        }
    }

    /**
     * Displays hand of a player
     * @param player player
     */
    public void displayHand(AbstractPlayer player) {
        view.displayHand(player);
    }

    /**
     * deals card to a player.
     * Player can either be a Dealer or a Player
     * @param player player
     */
    public void dealCard(AbstractPlayer player) {
        Card card = shoe.pickCard();
        player.addCard(card);
    }

    /**
     * Increments bet
     */
    public void incrementBet() {
        try {
            int bet = +view.incrementBet();
            player.reduceChips(bet);

        } catch (IOException e) {
            view.quitGame();
            System.exit(0);
        }
    }

    /**
     * Gets view
     * @return view
     */
    public AbstractView getView() {
        return view;
    }

    /**
     * Sets view
     * @param view
     */
    public void setView(AbstractView view) {
        this.view = view;
    }

    /**
     * Gets player
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sets player
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets dealer
     * @return
     */
    public Dealer getDealer() {
        return dealer;
    }

    /**
     * Sets dealer
     * @param dealer
     */
    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    /**
     * gets shoe
     * @return
     */
    public Shoe getShoe() {
        return shoe;
    }

    /**
     * Sets shoe
     * @param shoe
     */
    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }
}
