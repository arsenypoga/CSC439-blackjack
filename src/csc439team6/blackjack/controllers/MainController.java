package csc439team6.blackjack.controllers;

import csc439team6.blackjack.models.*;
import csc439team6.blackjack.views.AbstractView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Arseny Poga, Cory Bradford
 * @version 1.0
 */
public class MainController {

    private AbstractView view;
    private Player player;
    private Dealer dealer;
    private Shoe shoe;
    private final Logger logger = Logger.getLogger(MainController.class.getName());

    public MainController(AbstractView view) {
        logger.entering(getClass().getName(), "MainController");

        this.view = view;
        this.dealer = new Dealer();
        this.shoe =  new Shoe(3);
        this.player = new Player(0);

        logger.exiting(getClass().getName(), "MainController");
    }

    /**
     * Starts game sequence
     */
    public void playBlackjack() {
        logger.entering(getClass().getName(), "playBlackjack");

        view.gameStartedMessage();
        purchaseChips();
        makeInitialBet();

        checkShoeSize();
        populateInitialHands(this.player, this.dealer);
        displayHand(this.player);
        displayHand(this.dealer);

        String nextPlayerAction = getNextAction(this.player, getHandValue(this.player)); //method to get the action of the player
        initiatePlayerAction(nextPlayerAction);

        determineWinner();
        player.getHand().clear();
        dealer.getHand().clear();

        try {
            if (view.playAgain()) {
                playBlackjack();
            } else {
                view.quitGame();
            }
        } catch (IOException e) {
            view.quitGame();
        }

        logger.exiting(getClass().getName(), "playBlackjack");
    }

    /**
     * method to refill the shoe if the number of cards remaining is less than 30
     * This number is based off of an initial shoe size of 3 decks.
     */
    private void checkShoeSize() {
        if (shoe.cardCount() < 30) {
            shoe.repopulateShoe(3);
        }
    }

    /**
     * Method to determine the winner of the game once the playBlackjack() flow has completed.
     */
    private void determineWinner() {
        if (getHandValue(player) > 21 || getHandValue(dealer) > getHandValue(player)) {
            view.dealerWins();
        } else if (getHandValue(dealer) > 21 || getHandValue(player) > getHandValue(dealer)) {
            view.playerWins();
        } else {
            view.gameDraw();
        }
    }

    /**
     * Method to determine the action of the player and next steps in the flow to take depending on their input
     * @param nextPlayerAction
     */
    private void initiatePlayerAction(String nextPlayerAction) {
        if (nextPlayerAction.equals("DOUBLE")) { // validation for if double was selected
            player.setBet(player.getBet() * 2); // double bet
            player.addCard(shoe.pickCard()); // add new card to hand
            if (getHandValue(player) > 21 ) {
                view.bustMessage(getHandValue(player));
            } else {
                view.standMessage(getHandValue(player));
                view.dealersTurn();
                initiateDealerAction();
            }
        } else if (nextPlayerAction.equals("HIT")) { //logic for the option of HIT being selected
            player.addCard(shoe.pickCard());
            int newHandValue = getHandValue(player);
            if (newHandValue == 21) {
                view.standMessage(getHandValue(player));
                view.dealersTurn();
                initiateDealerAction();
            } else if (newHandValue < 21) {
                initiatePlayerAction(getNextAction(player, newHandValue));
            } else {
                view.bustMessage(newHandValue);
            }
        } else if (nextPlayerAction.equals("STAND")) {
            view.standMessage(getHandValue(player));
            view.dealersTurn();
            initiateDealerAction();
        } else {
            view.quitGame();
            System.exit(0);
        }
    }

    /**
     * Automated dealer action method, this method will simulate the dealer drawing a card until the hand value is
     * greater than or equal to 17
     */
    private void initiateDealerAction() {
        view.dealersHandValue(getHandValue(dealer));
        if (getHandValue(dealer) < 17) {
            dealer.addCard(shoe.pickCard());
            initiateDealerAction();
        }
    }

    /**
     * method to get the action that the player would like to take
     * @param player
     * @param currentHandValue
     * @return
     */
    private String getNextAction(AbstractPlayer player, int currentHandValue) {
        try {
            return view.getAction(player, currentHandValue);
        } catch (IOException e) {
            view.quitGame();
            System.exit(0);
            return null;
        }
    }

    /**
     * method for getting the hand value of the player/dealer based on the enum Number class
     * @param player
     * @return
     */
    private int getHandValue(AbstractPlayer player) {
        int currentHandValue = 0;
        ArrayList<Card> playerCards = player.getHand().getCards();

        for (Card cards : playerCards) {
            if (cards.getNumber() == Card.Number.ACE) {
                if (currentHandValue < 11) {
                    currentHandValue += 11;
                } else {
                    currentHandValue += 1;
                }
            } else if (cards.getNumber() == Card.Number.JACK
                        || cards.getNumber() == Card.Number.QUEEN
                        || cards.getNumber() == Card.Number.KING) {
                currentHandValue += 10;
            } else {
                Card.Number value = cards.getNumber();
                currentHandValue += cards.getNumber().valueOf(value.toString()).ordinal() + 1;
            }
        }
        return currentHandValue;
    }

    /**
     * method for the initial draws of cards, both player cards will be visible while only one dealer card will be
     * @param player
     * @param dealer
     */
    public void populateInitialHands(AbstractPlayer player, AbstractPlayer dealer) {
        for(int i = 0; i < 2; i++) { //player cards with isVisible boolean set to true
            Card card = shoe.pickCard();
            card.setVisible(true);
            player.addCard(card);
        }

        Card dealerCardOne = shoe.pickCard();
        dealerCardOne.setVisible(true);
        Card dealerCardTwo = shoe.pickCard();
        dealer.addCard(dealerCardOne);
        dealer.addCard(dealerCardTwo);
    }

    /**
     * Prompt user to purchase chips.
     *
     */
    public void purchaseChips() {
        logger.entering(getClass().getName(), "purchaseChips");

        try {
            int chips = view.purchaseChips();
            player.addChips(chips);
            logger.log(Level.INFO,  "Player purchased {} chips", chips);
        } catch (IOException e) {
            view.quitGame();

            logger.exiting(getClass().getName(), "incrementBet");
            System.exit(0);
        }
        logger.exiting(getClass().getName(), "purchaseChips");
    }

    /**
     * Prompts user for starting bet,
     * if input is incorrect the request is repeated.
     */
    public void makeInitialBet() {
        logger.entering(getClass().getName(), "makeInitialBet");
        try {
            int bet = view.getInitialBet();
            player.reduceChips(bet);
            player.setBet(bet);
        } catch (IOException e) {

            logger.info("Quit message command received!");

            view.quitGame();

            logger.exiting(getClass().getName(), "makeInitialBet");
            System.exit(0);
        }
        logger.exiting(getClass().getName(), "makeInitialBet");
    }

    /**
     * Displays hand of a player
     * @param player player
     */
    public void displayHand(AbstractPlayer player) {
        logger.entering(getClass().getName(), "displayHand");
        view.displayHand(player);
        logger.exiting(getClass().getName(), "displayHand");
    }

    /**
     * deals card to a player.
     * Player can either be a Dealer or a Player
     * @param player player
     */
    public void dealCard(AbstractPlayer player) {
        logger.entering(getClass().getName(), "dealCard");

        Card card = shoe.pickCard();
        logger.log(Level.INFO, "Player received {0}", card);
        player.addCard(card);

        logger.exiting(getClass().getName(), "dealCard");
    }

    /**
     * Increments bet
     */
    public void incrementBet() {
        logger.entering(getClass().getName(), "incrementBet");

        try {
            int bet = view.incrementBet();
            player.reduceChips(bet);

        } catch (IOException e) {
            view.quitGame();

            logger.exiting(getClass().getName(), "incrementBet");
            System.exit(0);
        }
        logger.exiting(getClass().getName(), "incrementBet");
    }

    /**
     * Gets view
     * @return view
     */
    public AbstractView getView() {
        logger.entering(getClass().getName(), "getView");
        logger.exiting(getClass().getName(), "getView");
        return view;

    }

    /**
     * Sets view
     * @param view
     */
    public void setView(AbstractView view) {
        logger.entering(getClass().getName(), "setView");

        this.view = view;

        logger.exiting(getClass().getName(), "setView");
    }

    /**
     * Gets player
     * @return player
     */
    public Player getPlayer() {
        logger.entering(getClass().getName(), "getPlayer");
        logger.exiting(getClass().getName(), "getPlayer");
        return player;
    }

    /**
     * Sets player
     * @param player
     */
    public void setPlayer(Player player) {
        logger.entering(getClass().getName(), "getPlayer");
        this.player = player;
        logger.entering(getClass().getName(), "getPlayer");

    }

    /**
     * Gets dealer
     * @return
     */
    public Dealer getDealer() {
        logger.entering(getClass().getName(), "getDealer");
        logger.exiting(getClass().getName(), "getDealer");
        return dealer;
    }

    /**
     * Sets dealer
     * @param dealer
     */
    public void setDealer(Dealer dealer) {
        logger.entering(getClass().getName(), "setDealer");
        this.dealer = dealer;
        logger.exiting(getClass().getName(), "setDealer");
    }

    /**
     * gets shoe
     * @return
     */
    public Shoe getShoe() {
        logger.entering(getClass().getName(), "getShoe");
        logger.exiting(getClass().getName(), "getShoe");
        return shoe;
    }

    /**
     * Sets shoe
     * @param shoe
     */
    public void setShoe(Shoe shoe) {
        logger.entering(getClass().getName(), "setShoe");
        this.shoe = shoe;
        logger.exiting(getClass().getName(), "setShoe");

    }
}
