package csc439team6.blackjack.models;

/**
 * Number is a card number.
 *
 * While we could use integer representation, here we use an enum as it is more human readable.
 *
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
