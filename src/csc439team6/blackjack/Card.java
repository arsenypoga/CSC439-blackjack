package csc439team6.blackjack;

import java.util.Objects;

/**
 * This is a Card of a Blackjack game.
 *
 * Only represents a playing unit.
 *
 * @author Arseny Poga
 * @version 1.0
 */
public class Card {
    private final Number number;
    private final Suit suit;

    /**
     * Creates a Card object.
     * @param number
     * @param suit
     */
    public Card(Number number, Suit suit) {
        this.number = number;
        this.suit = suit;
    }

    /**
     * Retrieves card number
     *
     * @return Card number
     */
    public Number getNumber() {
        return number;
    }

    /**
     * Retrieves Card suite.
     *
     * @return Card suite
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Compares Card with an any object.
     *
     * @param o Object
     * @return bool equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number == card.number &&
                suit == card.suit;
    }

    /**
     * Computes Hash Code for the card
     * @return int hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(number, suit);
    }
}
