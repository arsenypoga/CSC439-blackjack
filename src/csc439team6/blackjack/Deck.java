package csc439team6.blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 * Deck class which will simulate a deck of 2 unique playing cards. When the constructor is called it will call the
 * fillDeck() method to fill an ArrayList with a collection of all 52 cards.
 * Functionality for picking a card and getting the remaning size of the deck is included.
 * @author Cory Bradford
 * @version 1.0
 */
public class Deck {
    private ArrayList<Card> cards;
    private Random random = new Random();

    public Deck() {
        this.cards = fillDeck();
    }

    /**
     * method used to fill the Collection with all 52 cards through use of a nested loop
     * each card is added to the class ArrayList.
     * @param
     */
    private ArrayList<Card> fillDeck() {
        ArrayList<Card> cards = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 13; j++) {
                Card card = new Card(Number.values()[j], Suit.values()[i]);
                cards.add(card);
            }
        }
        return cards;
    }

    /**
     * method used to pick a random Card object from the defined collection.
     * if the size of the collection is <= 0 and exception will be thrown.
     * @return cardPicked Card
     * @throws IndexOutOfBoundsException
     */
    public Card pickCard() throws IndexOutOfBoundsException {
        if(cards.size() <= 0) {
            throw new IndexOutOfBoundsException();
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
    public int getSize() {
        return cards.size();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
