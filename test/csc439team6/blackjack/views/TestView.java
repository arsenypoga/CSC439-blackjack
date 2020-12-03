package csc439team6.blackjack.views;

import csc439team6.blackjack.models.*;

import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;
/**
 * This is a copy of the CLIView class.
 * @author Greyson Fangman
 */
public class TestView extends AbstractView {

    Scanner scanner = new Scanner(System.in);
    private int bet;

    @Override
    public void messageGameStarted() {
        System.out.println("Your game of blackjack has now started.");
        System.out.println("At any time you can type 'quit' to exit the game.");
        System.out.println("In order to begin the game you must first purchase chips which will be used for betting.");
    }

    @Override
    public void messageHit() {
        System.out.println("You hit!");
    }

    @Override
    public void messageStand() {
        System.out.println("You stand!");
    }

    @Override
    public void messageDouble() {
        System.out.println("You double!");
    }

    @Override
    public void messageTie(int score) {
        System.out.println("You and the dealer tie with a score of: " + score);
    }

    @Override
    public void messagePlayerWin(int playerScore, int dealerScore) {
        System.out.println("Player wins with a score of: " + playerScore);
        System.out.println("Dealer score: " + dealerScore);
    }

    @Override
    public void messageDealerWin(int playerScore, int dealerScore) {
        System.out.println("Dealer wins with a score of: " + playerScore);
        System.out.println("Player score: " + dealerScore);
    }

    @Override
    public void messagePlayerBust(int score) {
        System.out.println("You bust with a score of: " + score);
    }

    @Override
    public void messageDealerBust(int score) {
        System.out.println("Dealer busts with a score of: " + score);
    }


    @Override
    public int promptPurchaseChips(){
        return 100;
    }

    @Override
    public int promptInitialBet() {
        return 50;
    }


    public void messageDisplayHand(AbstractPlayer player) {
        System.out.print("[ ");
        for (Card card: player.getHand().getCards()) {
            System.out.print(card.displayString() + " ");
        }
        System.out.print("]");
    }



    @Override
    public int promptIncrementBet() {
        return 20;
    }

    @Override
    public Action promptAction(Action... allowedActions) throws IOException {
        return null;
    }

    @Override
    public void messageDisplayHand(AbstractPlayer player, int handScore) {

    }


    @Override
    public void messageQuitGame() {
        System.out.println("Quit received, quitting the game!");
    }


}


