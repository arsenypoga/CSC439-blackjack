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
    AbstractView view;
    Player player;
    Dealer dealer;
    Shoe shoe;

    public MainController(AbstractView view) {
        this.view = view;
        this.dealer = new Dealer();
        this.shoe =  new Shoe(3);
        this.player = new Player(0);
    }

    public void playBlackjack() {
        gameStartedMessage();
        purchaseChips();
        makeInitialBet();

        this.player.addCard(shoe.pickCard());
        this.player.addCard(shoe.pickCard());

        this.dealer.addCard(shoe.pickCard());
        this.dealer.addCard(shoe.pickCard());

        displayHand(player);
        displayHand(dealer);

    }

    public void gameStartedMessage() {
        view.gameStartedMessage();
    }

    public void purchaseChips() {
        try {
            int chips = view.purchaseChips(player);
            player.addChips(chips);
        } catch (IOException e) {
            view.quitGame();
            System.exit(0);
        }
    }

    // TODO: validate that the bet is in range!
    public void makeInitialBet() {
        try {
            int bet = view.getInitialBet();
            player.incrementBet(bet);
            player.reduceChips(bet);
        } catch (IOException e) {
            view.quitGame();
            System.exit(0);
        }
    }


    public void displayHand(AbstractPlayer player) {
        view.displayHand(player);
    }

    public void dealCard(AbstractPlayer player) {
        Card card = shoe.pickCard();
        player.addCard(card);
    }

    public void incrementBet() {
        int bet = view.incrementBet();
        player.incrementBet(bet);
    }


}
