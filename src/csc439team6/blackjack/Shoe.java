package csc439team6.blackjack;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Shoe class simlates a shoe of multiple decks in blackjack
 *
 * @author Arseny Poga
 * @version 1.0
 */
public class Shoe {
    private final Random random = new Random();
    private final ArrayList<Deck> decks = new ArrayList<>();

    public Shoe(int deckNumber) {
        for (int i = 0; i < deckNumber; i++) {
            decks.add(new Deck());
        }
    }

    /**
     * This method picks a random card from the set of decks.
     *
     * @return Card a random card
     */
    public Card pickCard() {
        if (decks.isEmpty()) {
            throw new NoSuchElementException();
        }

        int deckLocation = random.nextInt(decks.size());
        Deck deck = decks.get(deckLocation);
        Card card = deck.pickCard();

        if (deck.getSize() == 0) {
            decks.remove(deckLocation);
        }
        return card;
    }

    /**
     * This method returns the count of decks currently held.
     *
     * @return int deck count
     */
    public int deckCount() {
        return decks.size();
    }

    /**
     * This method returns the total card count that is available.
     *
     * @return int card count
     */
    public int cardCount() {
        int count = 0;

        for (Deck d : decks) {
            count += d.getSize();
        }
        return count;
    }
}