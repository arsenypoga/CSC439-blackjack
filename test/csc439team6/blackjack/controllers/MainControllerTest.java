package csc439team6.blackjack.controllers;

import csc439team6.blackjack.controllers.MainController;
import csc439team6.blackjack.models.*;
import csc439team6.blackjack.views.AbstractView;
import csc439team6.blackjack.views.TestView;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * @author Greyson Fangman
 * @version 1.0
 */
public class MainControllerTest {
    MainController controller;
    TestView testview;
    @Before
    public void init() {
        testview = new TestView();
        controller = new MainController(testview);
    }

    @Test
    public void playBlackJack() {
        controller.playBlackjack();
    }

    @Test
    public void purchaseChips() {
        controller.purchaseChips();
        assertEquals(100, controller.getPlayer().getChips());
    }

    @Test
    public void makeInitialBet() {
        controller.makeInitialBet();
        assertEquals(50, controller.getPlayer().getBet());
    }

    @Test
    public void displayHand() {
        TestView testview = new TestView();
        MainController controller = new MainController(testview);
        controller.displayHand(controller.getPlayer(), MainController.scoreHand(controller.getDealer().getHand()));
    }

    @Test
    public void dealCard() {
        TestView testview = new TestView();
        MainController controller = new MainController(testview);
        controller.dealCard(controller.getPlayer());
    }

    @Test
    public void incrementBet() {
        TestView testview = new TestView();
        MainController controller = new MainController(testview);
        controller.purchaseChips();
        controller.incrementBet();
    }

    @Test
    public void getView() {
        assertEquals(testview, controller.getView());
    }

    @Test
    public void setView() {
        TestView view = new TestView();
        controller.setView(view);
        assertEquals(view, controller.getView());
        controller.setView(testview);
    }

    @Test
    public void setPlayer() {
        Player player = new Player(0);
        controller.setPlayer(player);
        assertEquals(player, controller.getPlayer());
    }


    @Test
    public void getPlayer() {
        Player player = controller.getPlayer();
        assertEquals(player, controller.getPlayer());
    }


    @Test
    public void getDealer() {
        Dealer dealer = controller.getDealer();
        assertEquals(dealer, controller.getDealer());
    }

    @Test
    public void setDealer() {
        Dealer previousDealer = controller.getDealer();
        Dealer player = new Dealer();
        controller.setDealer(player);
        assertEquals(player, controller.getDealer());
        controller.setDealer(previousDealer);
    }

    @Test
    public void getShoe() {
        Shoe shoe = controller.getShoe();
        assertEquals(shoe, controller.getShoe());
    }

    @Test
    public void setShoe() {
        Shoe previousShoe = controller.getShoe();
        Shoe shoe = new Shoe(3);
        controller.setShoe(shoe);
        assertEquals(shoe, controller.getShoe());
        controller.setShoe(previousShoe);
    }

}
