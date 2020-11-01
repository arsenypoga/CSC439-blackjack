package csc439team6.blackjack.models;

import java.util.Objects;

/**
 * Class used to create a Card object which will be used in the blackjack game.
 * The properties of the object will be number and suit, which are assigned through use of the Number and Suit
 * enum classes.
 * Only represents a single playing unit.
 *
 * @author Arseny Poga, Cory Bradford, Greyson Fangman
 * @version 1.0
 */
public class Card {
    private final Number number;
    private final Suit suit;
    private boolean isVisible;
    /**
     * Creates a Card object and sets the number and suit variables.
     *
     * @param number Number
     * @param suit   Suit
     */
    public Card(Number number, Suit suit) {
        this.number = number;
        this.suit = suit;
        this.isVisible = false;
    }

     public boolean isVisible() {
     return isVisible;
     }

     public void setVisible(boolean visible) {
     isVisible = visible;
     }

     /**
     * Retrieves card number
     *
     * @return Number number
     */
    public Number getNumber() {
        return number;
    }

    /**
     * Retrieves Card suite.
     *
     * @return Suit suite
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
     *
     * @return int hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(number, suit);
    }

    /**
     * modified toString() method used to string together a human readable message of a card object's properties
     *
     * @return String
     */
    @Override
    public String toString() {
        return "<Card Number=(" + this.number.toString() + ") Suit=(" + this.suit.toString() + ")>";
    }

    /**
     * Enum representing 4 card suites.
     *
     * @author Arseny Poga, Cory Bradford, Greyson Fangman
     * @version 1.0
     */
    public enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    /**
     * Number is a card number.
     * <p>
     * While we could use integer representation, here we use an enum as it is more human readable.
     * <p>
     * Note that the card values start from 0 (ACE), not 1.
     *
     * @author Arseny Poga, Cory Bradford, Greyson Fangman
     * @version 1.0
     */
    public enum Number {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }
}