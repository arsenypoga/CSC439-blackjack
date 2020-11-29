package csc439team6.blackjack.views;

import csc439team6.blackjack.models.AbstractPlayer;
import csc439team6.blackjack.models.Card;
import csc439team6.blackjack.models.Dealer;
import csc439team6.blackjack.models.Player;

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
    public void gameStartedMessage() {
        System.out.println("Your game of blackjack has now started.");
        System.out.println("At any time you can type 'quit' to exit the game.");
        System.out.println("In order to begin the game you must first purchase chips which will be used for betting.");
    }


    @Override
    public int purchaseChips(){
        return 100;
    }

    @Override
    public int getInitialBet() {
        return 50;
    }


    @Override
    public void displayHand(AbstractPlayer player) {
        System.out.print("[ ");
        for (Card card: player.getHand().getCards()) {
            System.out.print(card.displayString() + " ");
        }
        System.out.print("]");
    }



    @Override
    public int incrementBet() {
        return 20;
    }


    @Override
    public void quitGame() {
        System.out.println("Quit received, quitting the game!");
    }

    @Override
    public String getAction(AbstractPlayer player, int currentHandValue) throws IOException {
        return null;
    }

    @Override
    public void bustMessage(int currentHandValue) {

    }

    @Override
    public void standMessage(int currentHandValue) {

    }

    @Override
    public void dealerWins() {

    }

    @Override
    public void playerWins() {

    }

    @Override
    public void dealersTurn() {

    }

    @Override
    public void gameDraw() {

    }

    @Override
    public void dealersHandValue(int dealersHandValue) {

    }

    @Override
    public boolean playAgain() throws IOException {
        return false;
    }


}


