package csc439team6.blackjack.controllers;

import csc439team6.blackjack.models.*;
import csc439team6.blackjack.views.AbstractView;

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
        this.player = new Player(0);
        this.dealer = new Dealer();
        this.shoe =  new Shoe(3);
    }

    public void playBlackjack() {
        gameStartedMessage();
        purchaseChips();
        makeInitialBet();
        dealInitialHands(player, dealer);
        displayInitialHands(player.getHand(), dealer.getHand());
    }

    public void gameStartedMessage() {
        view.gameStartedMessage();
    }

    public void purchaseChips() {
        int chips = view.purchaseChips(player);
        player.addChips(chips);
    }

    public void makeInitialBet() {
        try {
            int bet = view.getInitialBet();
            player.incrementBet(bet);
            player.reduceChips(bet);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            makeInitialBet();
        }
    }

    public void dealInitialHands(BasePlayer player, BasePlayer dealer) {
        for(int i = 0; i < 2; i++) {
            Card card = shoe.pickCard();
            player.addCard(card);
        }

        for(int i = 0; i < 2; i++) {
            Card card = shoe.pickCard();
            dealer.addCard(card);
        }
    }

    public void displayInitialHands(Hand playerHand, Hand dealerHand) {
        view.displayPlayerHand(playerHand);
        view.displayDealerHand(dealerHand);
    }

    public void dealCard(BasePlayer player) {
        Card card = shoe.pickCard();
        player.addCard(card);
    }

    public void incrementBet() {
        int bet = view.incrementBet();
        player.incrementBet(bet);
    }


}
