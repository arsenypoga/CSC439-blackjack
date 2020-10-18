package csc439team6.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Deck class which will simulate a deck of 2 unique playing cards. When the constructor is called it will call the
 * fillDeck() method to fill an ArrayList with a collection of all 52 cards.
 * Functionality for picking a card and getting the remaning size of the deck is included.
 * @author Cory Bradford
 * @version 1.0
 */
public class Deck {
    private final ArrayList<Card> cards = new ArrayList<>();
    private final Random random = new Random();

    public Deck() {
        for(Suit suit : Suit.values()) {
            for(Number number: Number.values()) {
                Card card = new Card(number, suit);
                cards.add(card);
            }
        }
    }


    /**
     * method used to pick a random Card object from the defined collection.
     * if the size of the collection is <= 0 and exception will be thrown.
     * @return cardPicked Card
     *
     */
    public Card pickCard() {
        if(cards.isEmpty()) {
            throw new NoSuchElementException();

        } else {
            int cardLocation = random.nextInt(cards.size());
            Card cardPicked = cards.get(cardLocation);
            cards.remove(cardPicked);

            return cardPicked;
        }
    }

    /**
     * returns the current size of the deck
     * @return int
     */
    public int size() {
        return cards.size();
    }

    /**
     * Is the Deck empty?
     * @return boolean isEmpty
     */
    public boolean isEmpty() {
        return this.cards.isEmpty();
    }
}
