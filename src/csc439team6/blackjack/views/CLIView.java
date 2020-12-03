package csc439team6.blackjack.views;

import csc439team6.blackjack.models.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CLI class which will be used to display messages to the user
 *
 * @author Cory Bradford
 */
public class CLIView extends AbstractView {

    Scanner scanner = new Scanner(System.in);
    private final Logger logger = Logger.getLogger(CLIView.class.getName());

    /**
     * Show game started message.
     */
    @Override
    public void messageGameStarted() {
        logger.entering(getClass().getName(), "gameStartedMessage");

        System.out.println("Your game of blackjack has now started.");
        System.out.println("At any time you can type 'quit' to exit the game.");
        System.out.println("In order to begin the game you must first purchase chips which will be used for betting.");

        logger.exiting(getClass().getName(), "gameStartedMessage");
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

    /**
     * Prompt player to purchase chips
     *
     * @return
     * @throws IOException
     */
    @Override
    public int promptPurchaseChips() throws IOException {
        logger.entering(getClass().getName(), "purchaseChips");

        System.out.print("How many chips would you like to purchase?: ");

        String line = scanLine();

        logger.exiting(getClass().getName(), "purchaseChips");
        return validateIntString(line);
    }

    /**
     * Prompt player for the initial bet
     *
     * @return int initial bet
     * @throws IOException
     */
    @Override
    public int promptInitialBet() throws IOException {
        logger.entering(getClass().getName(), "getInitialBet");

        System.out.print("How much would you like to bet(this table allows bets from 10-500 chips)? ");
        String line = scanLine();

        logger.exiting(getClass().getName(), "getInitialBet");
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
    public void messageDisplayHand(AbstractPlayer player, int score) {
        logger.entering(getClass().getName(), "displayHand");

        if (player instanceof Player) {
            logger.info("Displaying Player's hand");
            System.out.println("Your hand score: " + score);
            System.out.print("Your hand : ");
        } else {
            logger.info("Displaying Dealer's hand");
            System.out.println("Dealer's hand score: " + score);
            System.out.print("Dealer's hand : ");
        }
        System.out.print("[ ");
        for (Card card : player.getHand().getCards()) {
            System.out.printf("%s ", card.displayString());
        }
        System.out.println("]");


        logger.exiting(getClass().getName(), "displayHand");
    }

    /**
     * method to get the next action that the player would like to perform. String will be converted to upper case
     * to make data validation easier.
     * @param currentHandValue
     * @return String
     * @throws IOException
     */
    @Override
    public String getAction(AbstractPlayer player, int currentHandValue) throws IOException {
        System.out.println("Your current hand value is: " + currentHandValue);
        if (currentHandValue >= 9 && currentHandValue <= 11 && player.getHand().size() == 2) {
            System.out.println("Would you like to hit, double, or stand? ");
            return scanLine().toUpperCase();
        } else {
            System.out.println("Would you like to hit or stand? ");
            return scanLine().toUpperCase();
        }
    }

    @Override
    public void bustMessage(int currentHandValue) {
        System.out.println("You have bust with a hand value of: " + currentHandValue);
    }

    @Override
    public void standMessage(int currentHandValue) {
        System.out.println("You are now standing with a hand value of: " + currentHandValue);
    }

    @Override
    public void dealersTurn() {
        System.out.println("The dealer will now begin to play");
    }

    @Override
    public void dealersHandValue(int dealersHandValue) {
        if (dealersHandValue == 21) {
            System.out.println("The dealer has a hand value of " + dealersHandValue);
        } else if (dealersHandValue > 21) {
            System.out.println("The dealer has a hand value of " + dealersHandValue + " - The dealer has bust");
        } else if (dealersHandValue >= 17) {
            System.out.println("The dealer has a hand value of " + dealersHandValue + " - Dealer will now stand");
        } else {
            System.out.println("The dealer has a hand value of " + dealersHandValue + " - The dealer will now hit");
        }
    }

    @Override
    public void dealerWins() {
        System.out.println("The dealer has won the game");
    }

    @Override
    public void playerWins() {
        System.out.println("You won the game!");
    }

    @Override
    public void gameDraw() {
        System.out.println("The game resulted in a draw!");
    }

    @Override
    public boolean playAgain() throws IOException {
        System.out.println("Would you like to play again? {Y/N)");
        if (scanLine().toUpperCase().equals("Y")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Helper method to scan for "quit message" and raise an IO exception if it's encountered
     *
     * @return String line
     * @throws IOException Quit is received
     */
    public String scanLine() throws IOException {
        logger.entering(getClass().getName(), "scanLine");

        String line = scanner.nextLine();

        if (line.toLowerCase().contains("quit")) {
            throw new IOException("Quit command given!");
        }

        logger.exiting(getClass().getName(), "scanLine");
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
        logger.entering(getClass().getName(), "validateIntString");
        int returnInt;
        while (true) {
            try {
                returnInt = Integer.parseInt(str);

                logger.exiting(getClass().getName(), "validateIntString");
                return returnInt;
            } catch (NumberFormatException ex) {
                logger.log(Level.WARNING, "Couldn't parse int: {0}", str);

                System.out.println("Incorrect input! Enter a new number: ");
                str = scanLine();
            }
        }
    }

    public void messageCurrentBet(int bet) {
        logger.entering(getClass().getName(), "displayCurrentBet");

        System.out.println("Current Bet: " + bet);

        logger.exiting(getClass().getName(), "displayCurrentBet");

    }

    public void messageCurrentBalance(Player player) {
        logger.entering(getClass().getName(), "displayCurrentBalance");

        System.out.println("Your current chip balance is " + player.getChips() + " chips.");

        logger.entering(getClass().getName(), "displayCurrentBalance");
    }


    /**
     * Prompt player if he wants to increment bet, if so prompt player for the amount of the increment
     * @return int bet to increment, 0 if no input
     */
    @Override
    public int promptIncrementBet() throws IOException {
        logger.entering(getClass().getName(), "incrementBet");

        System.out.println("Would you want to increment bet? [Y/n]: ");

        String line = scanLine();
        int incrementNumber = 0;
        boolean isFlagValid = false;
        boolean isNumberValid = false;

        while(!isFlagValid) {
            if (line.equalsIgnoreCase("Y")) {
                System.out.println("Increment number: ");
                incrementNumber = validateIntString(scanLine());
                while (!isNumberValid) {
                    if (incrementNumber > Player.MAXIMUM_BET) {
                        logger.log(Level.WARNING, "Entered number exceeding Player.MAXIMUM_BET: " + Player.MAXIMUM_BET +"; Got: {1}", incrementNumber);

                        System.out.println("Player bet exceeds maximum allowed bet: " + Player.MAXIMUM_BET);
                        System.out.println("Increment number: ");
                        line = scanLine();
                    } else if (incrementNumber < Player.MINIMUM_BET) {
                        logger.log(Level.WARNING, "Entered number below Player.MINIMUM_BET: " + Player.MINIMUM_BET +"; Got: {1}", incrementNumber);

                        System.out.println("Player bet is below minimum allowed bet: " + Player.MINIMUM_BET);
                        System.out.println("Increment number: ");

                        line = scanLine();
                    }
                    isNumberValid = true;
                }

            } else if (line.equalsIgnoreCase("N")) {
                isFlagValid = true;
            } else {
                logger.log(Level.WARNING, "Entered message is not understood: {0}", line);
                System.out.println("Input is not understood, try again!");
                System.out.println("Would you want to increment bet? [Y/n]: ");
                line = scanLine();
            }
        }
        logger.exiting(getClass().getName(), "incrementBet");
        return incrementNumber;
    }

    @Override
    public Action promptAction(Action ...allowedActions) throws IOException {
        boolean isInputValid = false;
        Action returnAction = null;
        System.out.print("Do you want to: {}?: "+ Arrays.toString(allowedActions));
        String line = scanLine();

        while(!isInputValid) {
            if (line.equalsIgnoreCase("HIT")) {
                returnAction = Action.HIT;
            } else if (line.equalsIgnoreCase("DOUBLE")) {
                returnAction = Action.DOUBLE;
            }
            else if (line.equalsIgnoreCase("STAND")) {
                returnAction = Action.STAND;
            } else {
                logger.log(Level.WARNING, "Entered message is not understood: {0}", line);
                System.out.println("Input is not understood, try again!");
                System.out.println("Would you want to increment bet? [Y/n]: ");
                line = scanLine();
            }

            if (!Arrays.asList(allowedActions).contains(returnAction)) {
                System.out.println("Input is not allowed, try again with: " + allowedActions);
                line = scanLine();
            } else {
                isInputValid = true;
            }

        }
        return returnAction;
    }


    /**
     * Show quit message
     */
    @Override
    public void messageQuitGame() {
        logger.entering(getClass().getName(), "quitGame");

        System.out.println("Quit received, quitting the game. Thank you for playing!");

        logger.exiting(getClass().getName(), "quitGame");
    }
}


