//
// Author: Caiden Sanders
// Date: January 16, 2024
// Project: CS145 Lab 2
// Purpose: This class represents a playing card with a face (e.g. Ace, King)
// and a suit (e.g., Hearts, Diamonds). It is used to create individual cards
// for a card deck and provides a method to display the card's information.
//

/**
 * Represents a playing card with a face (such as Ace, King) and a suit (such as
 * Hearts, Diamonds).
 * This class is used to create individual cards for a card deck.
 */
public class Card {
    /**
     * Enum for card faces with names and values.
     */
    public enum Face {
      ACE("Ace", 1),
      DEUCE("Deuce", 2),
      THREE("Three", 3),
      FOUR("Four", 4),
      FIVE("Five", 5),
      SIX("Six", 6),
      SEVEN("Seven", 7),
      EIGHT("Eight", 8),
      NINE("Nine", 9),
      TEN("Ten", 10),
      JACK("Jack", 11),
      QUEEN("Queen", 12),
      KING("King", 13);
  
      private final String name;
      private final int value;
  
      /**
       * Constructs a card face with the specified name and value.
       *
       * @param name  the name of the face (e.g., "Ace")
       * @param value the value of the face (e.g., 1 for Ace)
       */
      private Face(String name, int value) {
        this.name = name;
        this.value = value;
      }
  
      /**
       * Gets the value of this card face.
       *
       * @return the value of the face
       */
      public int getValue() {
        return value;
      }
  
      /**
       * Returns the name of this face.
       *
       * @return the name of the face
       */
      @Override
      public String toString() {
        return this.name;
      }
    }
  
    /**
     * Enum for card suits.
     */
    public enum Suit {
      HEARTS("Hearts"),
      DIAMONDS("Diamonds"),
      CLUBS("Clubs"),
      SPADES("Spades");
  
      private final String name;
  
      /**
       * Constructs a card suit with the specified name.
       *
       * @param name the name of the suit (e.g., "Hearts")
       */
      private Suit(String s) {
        name = s;
      }
  
      /**
       * Returns the name of this suit.
       *
       * @return the name of the suit
       */
      @Override
      public String toString() {
        return this.name;
      }
    }
  
    private final Face face;
    private final Suit suit;
  
    /**
     * Gets the face of this card.
     *
     * @return the face of the card
     */
    protected Face getFace() {
      return face;
    }
  
    /**
     * Gets the suit of this card.
     *
     * @return the suit of the card
     */
    protected Suit getSuit() {
      return suit;
    }
  
    /**
     * Constructs a card with the specified face and suit.
     *
     * @param cardFace the face of the card
     * @param cardSuit the suit of the card
     */
    public Card(Face cardFace, Suit cardSuit) {
      this.face = cardFace;
      this.suit = cardSuit;
    }
  
    /**
     * Returns a string representation of the card, combining its face and suit.
     *
     * @return a string representation of the card
     */
    public String toString() {
      return face + " of " + suit;
    }
}