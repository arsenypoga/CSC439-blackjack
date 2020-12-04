package csc439team6.blackjack.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Arseny Poga
 * @version 1.0
 */
public class PlayerTest {
    Player player;
    @Before
    public void init() {
        player = new Player(0);
    }

    @After
    public void clean() {
        player = new Player(0);
    }

    @Test
    public void getChips() {
        assertEquals(0, player.getChips());
        player.addChips(100);
        assertEquals(100, player.getChips());
    }

    @Test
    public void addChips() {
        player.addChips(100);
        assertEquals(100, player.getChips());
        player.addChips(100);
        assertEquals(200, player.getChips());
    }

    @Test
    public void reduceChips() {
        player.setChips(1000);
        player.reduceChips(100);
        assertEquals(900, player.getChips());
    }

    @Test
    public void getBet() {
        assertEquals(0, player.getBet());
        player.addChips(1000);
        player.setBet(100);
        assertEquals(100, player.getBet());
    }

    @Test
    public void incrementBet() {
        assertEquals(0, player.getBet());
        player.addChips(1000);
        player.setBet(100);
        player.incrementBet(100);
        assertEquals(200, player.getBet());
    }

    @Test
    public void resetBet() {
        player.addChips(1000);
        player.setBet(100);
        player.resetBet();
        assertEquals(0, player.getBet());
    }

    @Test
    public void setChips() {
        assertEquals(0, player.getChips());
        player.setChips(100);
        assertEquals(100, player.getChips());
    }

    @Test
    public void setBet() {
        player.addChips(1000);
        player.setBet(100);
        assertEquals(100, player.getBet());
    }

    @Test
    public void addCard() {
        player.addCard(new Card(Card.Number.ACE, Card.Suit.SPADES));
        assertEquals(1, player.getHand().size());
        player.resetHand();
        player.addCard(new Card(Card.Number.ACE, Card.Suit.SPADES), true);
        Card playerCard = player.getHand().getCards().get(0);
        assertTrue(playerCard.isVisible());
    }

    @Test
    public void resetHand() {
        player.addCard(new Card(Card.Number.ACE, Card.Suit.SPADES));
        player.addCard(new Card(Card.Number.ACE, Card.Suit.SPADES));
        player.addCard(new Card(Card.Number.ACE, Card.Suit.SPADES));
        player.addCard(new Card(Card.Number.ACE, Card.Suit.SPADES));
        player.resetHand();
        assertEquals(0, player.getHand().size());
    }
}