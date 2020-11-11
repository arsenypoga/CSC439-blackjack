package csc439team6.blackjack;

import csc439team6.blackjack.controllers.MainController;
import csc439team6.blackjack.models.*;
import csc439team6.blackjack.views.TestView;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * @author Greyson Fangman
 * @version 1.0
 */
public class MainControllerTest {

    @Test
    public void playBlackJack() {
        TestView testview = new TestView();
        MainController controller = new MainController(testview);
        controller.playBlackjack();

    }

    @Test
    public void gameStartedMessage() {
        TestView testview = new TestView();
        MainController controller = new MainController(testview);
        controller.gameStartedMessage();
        //Scanner scanner = new Scanner(System.in);
        //String line = scanner.nextLine();
        //assertEquals(0, line.compareTo("Your game of blackjack has now started."));
        //line = scanner.nextLine();
        //assertEquals(0, line.compareTo("At any time you can type 'quit' to exit the game."));
    }

    @Test
    public void purchaseChips() {
        TestView testview = new TestView();
        MainController controller = new MainController(testview);
        controller.purchaseChips();
        assertEquals(controller.chips, 50);
    }

    @Test
    public void makeInitialBet() {
        TestView testview = new TestView();
        MainController controller = new MainController(testview);
        controller.makeInitialBet();
        assertEquals(controller.bet, 25);
    }

    @Test
    public void displayHand() {
        TestView testview = new TestView();
        MainController controller = new MainController(testview);
        controller.displayHand(controller.player);
    }

    @Test
    public void dealCard() {
        TestView testview = new TestView();
        MainController controller = new MainController(testview);
        controller.dealCard(controller.player);
    }

    @Test
    public void incrementBet() {
        TestView testview = new TestView();
        MainController controller = new MainController(testview);
        controller.purchaseChips();
        controller.incrementBet(25);
    }









}
