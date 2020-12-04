package csc439team6.blackjack.models;

import java.util.Objects;
import java.util.logging.Logger;

/**
 * Class used to create a Card object which will be used in the blackjack game.
 * The properties of the object will be number and suit, which are assigned through use of the Number and Suit
 * enum classes.
 * Only represents a single playing unit.
 *
 * @author Arseny Poga, Cory Bradford, Greyson Fangman
 * @version 1.0
 */
public class Card implements Comparable<Card> {
    private final Number number;
    private final Suit suit;
    private static final Logger logger = Logger.getLogger(Card.class.getName());
    private boolean isVisible;
    /**
     * Creates a Card object and sets the number and suit variables.
     *
     * @param number Number
     * @param suit   Suit
     */
    public Card(Number number, Suit suit) {
        logger.entering(getClass().getName(), "Card");
        this.number = number;
        this.suit = suit;
        isVisible = false;
        logger.exiting(getClass().getName(), "Card");
    }

    /**
     * Retrieves card number
     *
     * @return Number number
     */


    public Number getNumber() {
        logger.entering(getClass().getName(), "getNumber");
        logger.exiting(getClass().getName(), "getNumber");
        return number;
    }

    /**
     * Retrieves Card suite.
     *
     * @return Suit suite
     */
    public Suit getSuit() {
        logger.entering(getClass().getName(), "getSuit");
        logger.exiting(getClass().getName(), "getSuit");
        return suit;
    }

    public boolean isVisible() {
        logger.entering(getClass().getName(), "isVisible");
        logger.exiting(getClass().getName(), "isVisible");

        return isVisible;
    }

    public void setVisible(boolean visible) {
        logger.entering(getClass().getName(), "setVisible");
        isVisible = visible;
        logger.exiting(getClass().getName(), "setVisible");
    }

    /**
     * Compares Card with an any object.
     *
     * @param o Object
     * @return bool equality
     */
    @Override
    public boolean equals(Object o) {
        logger.entering(getClass().getName(), "equals");
        logger.exiting(getClass().getName(), "equals");
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
        logger.entering(getClass().getName(), "hashCode");
        logger.exiting(getClass().getName(), "hashCode");
        return Objects.hash(number, suit);
    }

    /**
     * modified toString() method used to string together a human readable message of a card object's properties
     *
     * @return String
     */
    @Override
    public String toString() {
        logger.exiting(getClass().getName(), "toString");
        logger.entering(getClass().getName(), "toString");
        return "<Card Number=(" + this.number.toString() + ") Suit=(" + this.suit.toString() + ")>";
    }

    public String displayString() {
        logger.entering(getClass().getName(), "displayString");
        logger.exiting(getClass().getName(), "displayString");
        return this.suit.toString().toUpperCase().charAt(0) + this.number.shortString();
    }

    @Override
    public int compareTo(Card o) {
        logger.entering(getClass().getName(), "compareTo");
        logger.exiting(getClass().getName(), "compareTo");
        return this.number.compareTo(o.number);
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
        KING;

        /**
         * Returns short string version of a card number
         * @return
         */
        public String shortString() {
        logger.entering(getClass().getName(), "shortString");
            String returnString = "";
            switch (this) {
                case ACE:
                    returnString = "A";
                    break;
                case TWO:
                    returnString = "2";
                    break;
                case THREE:
                    returnString = "3";
                    break;
                case FOUR:
                    returnString = "4";
                    break;
                case FIVE:
                    returnString = "5";
                    break;
                case SIX:
                    returnString = "6";
                    break;
                case SEVEN:
                    returnString = "7";
                    break;
                case EIGHT:
                    returnString = "8";
                    break;
                case NINE:
                    returnString = "9";
                    break;
                case TEN:
                    returnString = "10";
                    break;
                case JACK:
                    returnString = "J";
                    break;
                case QUEEN:
                    returnString = "Q";
                    break;
                case KING:
                    returnString = "K";
                    break;
            }
            logger.exiting(getClass().getName(), "shortString");
            return returnString;
        }
    }
}