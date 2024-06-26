//
// Author: Caiden Sanders
// Date: January 16, 2024
// Project: CS145 Lab 2
// Purpose: This class represents a standard deck of 52 playing cards. It
// provides methods for shuffling the deck, dealing cards, and dealing a
// specified number of cards. The deck is initialized with all the cards during
// construction.
//
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a standard deck of 52 playing cards.
 * Provides methods for shuffling the deck, dealing cards, and dealing a
 * specified number of cards.
 * The deck is initialized with all the cards during construction.
 */
public class DeckOfCards {
  private static final SecureRandom randomNumbers = new SecureRandom();
  private static final int NUMBER_OF_CARDS = 52;
  private List<Card> deck = new ArrayList<>(NUMBER_OF_CARDS);
  private int currentCard = 0;

  /**
   * Gets the current deck of cards.
   *
   * @return the current deck of cards
   */
  protected List<Card> getDeck() {
    return deck;
  }

  /**
   * Constructs a new deck of cards, initializing it with all card faces and
   * suits.
   */
  public DeckOfCards() {
    for (Card.Face face : Card.Face.values()) {
      for (Card.Suit suit : Card.Suit.values()) {
        deck.add(new Card(face, suit));
      }
    }
  }

  /**
   * Shuffles the deck of cards.
   */
  public void shuffle() {
    currentCard = 0;
    
    for (int first = 0; first < deck.size(); first++) {
      int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
      Card temp = deck.get(first);
      deck.set(first, deck.get(second));
      deck.set(second, temp);
    }
  }

  /**
   * Deals one card from the deck.
   *
   * @return the dealt card, or null if the deck is empty
   */
  public Card dealCard() {
    return currentCard < deck.size() ? deck.get(currentCard++) : null;
  }

  /**
   * Deals a specified number of cards from the deck.
   *
   * @param numberOfCards the number of cards to deal
   * @return a list containing the dealt cards
   * @throws IllegalStateException if the deck does not have enough cards to
   *                               deal
   */
  public List<Card> dealCards(int numberOfCards) {
    List<Card> hand = new ArrayList<Card>();
    for (int i = 0; i < numberOfCards; i++) {
      Card card = dealCard();
      if (card != null)
        hand.add(card);
      else
        throw new IllegalStateException("The deck is empty.");
    }

    return hand;
  }
}