package csc439team6.blackjack.controllers;

import csc439team6.blackjack.models.*;
import csc439team6.blackjack.views.AbstractView;

/**
 * @author Arseny Poga
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

    public void startGame() {

    }

    public void dealCard(BasePlayer player) {
        Card card = shoe.pickCard();
        player.addCard(card);
    }

    public void purchaseChips() {
        int chips = view.purchaseChips();
        player.addChips(chips);
    }

    public void makeInitialBet() {
        int bet = view.getInitialBet();
        player.incrementBet(bet); // IN this case bet is 0, then increments to `bet`
    }

    public void incrementBet() {
        int bet = view.incrementBet();
        player.incrementBet(bet);
    }


}
