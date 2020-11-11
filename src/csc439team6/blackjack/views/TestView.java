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
public class TestView extends AbstractView{

    Scanner scanner = new Scanner(System.in);
    private int bet;
    @Override
    public void gameStartedMessage() {
        System.out.println("Your game of blackjack has now started.");
        System.out.println("At any time you can type 'quit' to exit the game.");
        System.out.println("In order to begin the game you must first purchase chips which will be used for betting.");
    }

    @Override
    public int purchaseChips(Player player){
        System.out.println("Your current chip balance is " + player.getChips() + " chips.");
        System.out.print("How many chips would you like to purchase? ");

        String line = "50";
        int returnval = 0;
        try {
            returnval = Integer.parseInt(line);
        }
        catch (NumberFormatException ex){
            System.out.println("Enter a new number: ");
        }

        return 50;
    }

    @Override
    public int getInitialBet() {
        System.out.print("How much would you like to bet(this table allows bets from 10-500 chips)? ");
        String line = "25";
        return Integer.parseInt(line);
    }

    @Override
    public void displayHand(AbstractPlayer player) {
        if (player instanceof Player) {
            System.out.print("Your hand : ");
            System.out.print("[ ");
            for (Card card : player.getHand().getCards()) {
                System.out.printf("%s ", card.displayString());
            }
            System.out.println("]");
        }
        if (player instanceof Dealer)
        {
            System.out.print("Dealer has: ");
            System.out.print("[ ");

            for (Card card : player.getHand().getCards()) {
                if (card.isVisible()) {
                    System.out.printf("%s ", card.displayString());
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println("]");
        }
    }

    public String scanLine() throws IOException {
        String line = "quit";

        if (line.toLowerCase().contains("quit")) {
            throw new IOException("Quit command given!");
        }

        return line;
    }


    @Override
    public int incrementBet(int bet) {
        return this.bet + bet;
    }

    @Override
    public void showGameStatus() {

    }

    @Override
    public void quitGame() {
        System.out.println("Quit received, quitting the game!");
    }
}


