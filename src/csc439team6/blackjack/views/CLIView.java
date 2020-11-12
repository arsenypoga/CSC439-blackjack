package csc439team6.blackjack.views;

import csc439team6.blackjack.models.AbstractPlayer;
import csc439team6.blackjack.models.Card;
import csc439team6.blackjack.models.Dealer;
import csc439team6.blackjack.models.Player;

import java.io.IOException;
import java.util.Scanner;

/**
 * CLI class which will be used to display messages to the user
 *
 * @author Cory Bradford
 */
public class CLIView extends AbstractView {

    Scanner scanner = new Scanner(System.in);

    /**
     * Show game started message.
     */
    @Override
    public void gameStartedMessage() {
        System.out.println("Your game of blackjack has now started.");
        System.out.println("At any time you can type 'quit' to exit the game.");
        System.out.println("In order to begin the game you must first purchase chips which will be used for betting.");
    }

    /**
     * Prompt player to purchase chips
     *
     * @return
     * @throws IOException
     */
    @Override
    public int purchaseChips() throws IOException {
        System.out.print("How many chips would you like to purchase?: ");

        String line = scanLine();
        return validateIntString(line);
    }

    /**
     * Prompt player for the initial bet
     *
     * @return int initial bet
     * @throws IOException
     */
    @Override
    public int getInitialBet() throws IOException {
        System.out.print("How much would you like to bet(this table allows bets from 10-500 chips)? ");
        String line = scanLine();
        return validateIntString(line);
    }

    /**
     * Displays Players hand that is given.
     * If given object is a Player all cards are shown
     * Otherwise if given object is Dealer, only visible cards are shown
     *
     * @param player
     */
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
        if (player instanceof Dealer) {
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

    /**
     * Helper method to scan for "quit message" and raise an IO exception if it's encountered
     *
     * @return String line
     * @throws IOException Quit is received
     */
    public String scanLine() throws IOException {
        String line = scanner.nextLine();

        if (line.toLowerCase().contains("quit")) {
            throw new IOException("Quit command given!");
        }
        return line;
    }

    /**
     * Helper method to validate user inputs
     *
     * @param str
     * @return
     * @throws IOException
     */
    public int validateIntString(String str) throws IOException {
        int returnInt;
        while (true) {
            try {
                returnInt = Integer.parseInt(str);
                return returnInt;
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect input! Enter a new number: ");
                str = scanLine();
            }
        }
    }

    public void displayCurrentBet(int bet) {
    System.out.println("Current Bet: "+bet);
    }

    public void displayCurrentBalance(Player player) {
        System.out.println("Your current chip balance is " + player.getChips() + " chips.");
    }


    /**
     * Prompt player if he wants to increment bet, if so prompt player for the amount of the increment
     * @return int bet to increment, 0 if no input
     */
    @Override
    public int incrementBet() throws IOException {

        System.out.println("Would you want to increment bet? [Y/n]: ");

        String line = scanLine();
        int incrementNumber = 0;
        boolean isFlagValid = false;
        boolean isNumberValid = false;

        while(!isFlagValid) {
            if (line.equals("y") || line.equals("Y")) {
                System.out.println("Increment number: ");
                incrementNumber = validateIntString(scanLine());
                while (!isNumberValid) {

                    if (incrementNumber > Player.MAXIMUM_BET) {
                        System.out.println("Player bet exceeds maximum allowed bet: " + Player.MAXIMUM_BET);
                        System.out.println("Increment number: ");
                        line = scanLine();
                    } else if (incrementNumber < Player.MINIMUM_BET) {
                        System.out.println("Player bet is below minimum allowed bet: " + Player.MINIMUM_BET);
                        System.out.println("Increment number: ");
                        line = scanLine();
                    }
                    isNumberValid = true;
                }

            } else if (line.equals("n") || line.equals("N")) {
                isFlagValid = true;
            } else {
                System.out.println("Input is not understood, try again!");
                System.out.println("Would you want to increment bet? [Y/n]: ");
                line = scanLine();
            }
        }
        return incrementNumber;
    }

    /**
     * Show quit message
     */
    @Override
    public void quitGame() {
        System.out.println("Quit received, quitting the game!");
    }
}


