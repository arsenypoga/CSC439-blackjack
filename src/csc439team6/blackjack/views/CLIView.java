package csc439team6.blackjack.views;

import csc439team6.blackjack.models.*;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * CLI class which will be used to display messages to the user
 * @author Cory Bradford
 */
public class CLIView extends AbstractView {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void gameStartedMessage() {
        System.out.println("Your game of blackjack has now started.");
        System.out.println("At any time you can type 'quit' to exit the game.");
        System.out.println(" In order to begin the game you must first purchase chips which will be used for betting.");
    }

    @Override
    public int purchaseChips(Player player) throws IOException {
        System.out.println("Your current chip balance is " + player.getChips() + " chips.");
        System.out.print("How many chips would you like to purchase? ");

        String line = scanLine();

        return Integer.parseInt(line);
    }

    @Override
    public int getInitialBet() throws IOException {
        System.out.print("How much would you like to bet(this table allows bets from 10-500 chips)? ");

        String line = scanLine();
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
        String line = scanner.nextLine();

        if (line.toLowerCase().contains("quit")) {
            throw new IOException("Quit command given!");
        }
        return line;
    }

    @Override
    public int incrementBet() {
        return 0;
    }

    @Override
    public void showGameStatus() {

    }

    @Override
    public void quitGame() {
        System.out.println("Quit received, quitting the game!");
    }
}


