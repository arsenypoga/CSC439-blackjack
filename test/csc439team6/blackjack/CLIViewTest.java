package csc439team6.blackjack;

import csc439team6.blackjack.controllers.MainController;
import csc439team6.blackjack.models.Card;
import csc439team6.blackjack.models.Hand;
import csc439team6.blackjack.models.Player;
import csc439team6.blackjack.views.AbstractView;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.*;
import csc439team6.blackjack.views.TestView;


/**
 * @author Greyson Fangman
 * @version 1.0
 */

public class CLIViewTest {
    @Test
    public void purchaseChips() {
        Player player = new Player(100);
        TestView testview = new TestView();
        MainController controller = new MainController(testview);
        assertEquals(testview.purchaseChips(player), 50);
    }

    @Test
    public void getInitialBet() {
        TestView testview = new TestView();
        MainController controller = new MainController(testview);
        assertEquals(testview.getInitialBet(), 25);
    }

    @Test (expected = IOException.class)
    public void scanLine() throws IOException {
        TestView testview = new TestView();
        MainController controller = new MainController(testview);
        testview.scanLine();
    }

    @Test
    public void IncrementBet() {
        TestView testview = new TestView();
        MainController controller = new MainController(testview);
        controller.purchaseChips();
        controller.incrementBet(25);
    }




}
