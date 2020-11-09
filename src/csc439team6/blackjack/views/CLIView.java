package csc439team6.blackjack.views;

import csc439team6.blackjack.models.Hand;
import csc439team6.blackjack.models.Player;

import java.util.Scanner;

/**
 * CLI class which will be used to display messages to the user
 * @author Cory Bradford
 */
public class CLIView extends AbstractView {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void gameStartedMessage() {
        System.out.println("Your game of blackjack has now started. At any time you can type 'quit' to exit the game." +
                " In order to begin the game you must first purchase chips which will be used for betting.");
    }

    @Override
    public int purchaseChips(Player player) {
        System.out.println("Your current chip balance is " + player.getChips() + " chips.");
        System.out.print("How many chips would you like to purchase? ");
        return scanner.nextInt();
    }

    @Override
    public int getInitialBet() {
        System.out.print("How much would you like to bet(this table allows bets from 10-500 chips)? ");
        return scanner.nextInt();
    }

    @Override
    public void displayPlayerHand(Hand hand) {
        System.out.println("Player hand: " + hand.getCards());
    }

    public void displayDealerHand(Hand hand) {
        System.out.println("Dealer hand: " + hand.getCards().get(0));
    }

    @Override
    public int incrementBet() {
        return 0;
    }

    @Override
    public void showGameStatus() {

    }

    @Override
    public boolean quitGame() {
        return false;
    }
}
