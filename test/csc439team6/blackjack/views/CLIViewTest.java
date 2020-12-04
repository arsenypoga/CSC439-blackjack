package csc439team6.blackjack.views;

import csc439team6.blackjack.Main;
import csc439team6.blackjack.controllers.MainController;
import csc439team6.blackjack.models.Card;
import csc439team6.blackjack.models.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * @author Arseny Poga
 * @version 1.0
 */
public class CLIViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    CLIView view = new CLIView();
    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void clean() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void gameStartedMessage() {
        view.messageGameStarted();
        assertEquals("Your game of blackjack has now started.\r\n" +
                "At any time you can type 'quit' to exit the game.\r\n" +
                "In order to begin the game you must first purchase chips which will be used for betting.\r\n", outContent.toString());
    }

    @Test
    public void displayHand() {
        Player player = new Player(0);
        player.addCard(new Card(Card.Number.EIGHT, Card.Suit.CLUBS));
        view.messageDisplayHand(player, MainController.scoreHand(player.getHand()));
        assertEquals("Your hand score: 8\r\nYour hand : [ C8 ]\r\n", outContent.toString());
    }

    @Test
    public void displayCurrentBet() {
        view.messageCurrentBet(10);
        assertEquals("Current Bet: 10\r\n", outContent.toString());
    }

    @Test
    public void displayCurrentBalance() {
        Player player = new Player(100);
        view.messageCurrentBalance(player);

        assertEquals("Your current chip balance is 100 chips.\r\n", outContent.toString());
    }


    @Test
    public void quitGame() {
        view.messageQuitGame();
        assertEquals("Quit received, quitting the game. Thank you for playing!\r\n", outContent.toString());
    }
}