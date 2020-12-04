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
        logger.entering(getClass().getName(), "messageHit");
        System.out.println("You hit!");
        logger.exiting(getClass().getName(), "messageHit");
    }

    @Override
    public void messageStand() {
        logger.entering(getClass().getName(), "messageStand");
        System.out.println("You stand!");
        logger.exiting(getClass().getName(), "messageStand");
    }

    @Override
    public void messageDouble() {
        logger.entering(getClass().getName(), "messageDouble");
        System.out.println("You double!");
        logger.exiting(getClass().getName(), "messageDouble");
    }


    @Override
    public void messageTie(int score) {
        logger.entering(getClass().getName(), "messageTie");
        System.out.println("You and the dealer tie with a score of: " + score);
        logger.exiting(getClass().getName(), "messageTie");
    }

    @Override
    public void messagePlayerWin(int playerScore, int dealerScore) {
        logger.entering(getClass().getName(), "messageTie");
        System.out.println("Player wins with a score of: " + playerScore);
        System.out.println("Dealer score: " + dealerScore);
        logger.exiting(getClass().getName(), "messageTie");

    }

    @Override
    public void messageDealerWin(int playerScore, int dealerScore) {
        logger.entering(getClass().getName(), "messageDealerWin");
        System.out.println("Player score: " + playerScore);
        System.out.println("Dealer wins with a score of: " + dealerScore);
        logger.entering(getClass().getName(), "messageDealerWin");
    }

    @Override
    public void messagePlayerBust() {
        logger.entering(getClass().getName(), "messagePlayerBust");
        System.out.println("You bust!");
        logger.entering(getClass().getName(), "messagePlayerBust");
    }

    @Override
    public void messageDealerBust(int score) {
        logger.entering(getClass().getName(), "messageDealerBust");
        System.out.println("Dealer busts with a score of: " + score);
        logger.entering(getClass().getName(), "messageDealerBust");

    }

    @Override
    public void messageDisplayDealerHit(int dealerScore) {
        System.out.println("The dealer has hit, dealers current hand value is: " + dealerScore);
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

    //TODO: cleanup this logic
    @Override
    public boolean promptPlayAgain() throws IOException {
        logger.entering(getClass().getName(), "promptPlayAgain");
        System.out.println("Would you like to play again? (Y/N)");
        String line = scanLine();
        if (line.equalsIgnoreCase("Y")) {
            logger.exiting(getClass().getName(), "promptPlayAgain");
            return true;
        } else {
            logger.exiting(getClass().getName(), "promptPlayAgain");
            return false;
        }
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

            System.out.print("[ ");
            for (Card card : player.getHand().getCards()) {
                System.out.printf("%s ", card.displayString());
            }
            System.out.println("]");


        } else {
            logger.info("Displaying Dealer's hand");
            System.out.print("Dealer's hand : ");
            System.out.print("[ ");
            for (Card card : player.getHand().getCards()) {
                if (card.isVisible()){
                    System.out.printf("%s ", card.displayString());
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println("]");


        }

        logger.exiting(getClass().getName(), "displayHand");
    }

    @Override
    public void messageDealersTurn(int currentDealerScore) {
        logger.entering(getClass().getName(), "currentDealerScore");
        System.out.println("The dealer will now begin to play. The dealers hand value is: " + currentDealerScore);
        logger.exiting(getClass().getName(), "currentDealerScore");
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
        logger.exiting(getClass().getName(), "promptAction");
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
        logger.exiting(getClass().getName(), "promptAction");
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


