package csc439team6.blackjack;

/**
 * Main class which will be used for the main functionality of the blackjack game.
 * Class currently doesn't contain any game features.
 *
 * @author Arseny Poga, Cory Bradford, Greyson Fangman
 * @version 1.0
 */
public class Main {

    /**
     * main method used to instantiate a card object and print the properties
     *
     * @param args blah
     */
    public static void main(String[] args) {
        Card card = new Card(Number.NINE, Suit.SPADES);
        System.out.println(card);
    }
}
