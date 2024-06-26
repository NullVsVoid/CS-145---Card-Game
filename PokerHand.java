//
// Author: Caiden Sanders
// Date: January 16, 2024
// CS145 Lab 2
// Purpose: This class represents a poker hand, which is a special subset of
// cards from a deck. It inherits from the DeckOfCards class and includes
// methods to evaluate the poker hand for various rankings, such as one pair,
// two pairs, three of a kind, four of a kind, flush, straight, and full house.
// It also provides an enum for hand rankings.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a poker hand, which is a subset of cards from a deck.
 * Inherits from the DeckOfCards class and includes methods to evaluate the
 * poker hand for various rankings, such as one pair, two pairs, three of a
 * kind, four of a kind, flush, straight, and full house.
 */
public class PokerHand extends DeckOfCards {
    private List<Card> hand;

    /**
     * Constructs a PokerHand by dealing five cards.
     */
    public PokerHand() {
        super();
        hand = super.dealCards(5);
    }

    /**
     * Constructs a PokerHand with a predetermined set of cards.
     *
     * @param predeterminedHand A list of cards to initialize the hand.
     * @throws IllegalArgumentException If the provided list does not contain
     *                                  exactly 5 cards.
     */
    public PokerHand(List<Card> predeterminedHand) {
        super();
        if (predeterminedHand.size() == 5) {
            hand = new ArrayList<>(predeterminedHand);
        } else {
            throw new IllegalArgumentException(
                    "A poker hand must contain exactly 5 cards.");
        }
    }

    /**
     * Shuffles the deck and re-deals five cards to this hand.
     */
    @Override
    public void shuffle() {
        super.shuffle();
        hand.clear();
        hand = super.dealCards(5);
    }

    /**
     * Checks if the hand contains one pair.
     *
     * @return true if the hand contains exactly one pair; false otherwise.
     */
    public boolean hasOnePair() {
        for (int i = 0; i < hand.size(); i++) {
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(i).getFace().equals(hand.get(j).getFace())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the hand contains two distinct pairs.
     *
     * @return true if the hand contains exactly two distinct pairs; false
     *         otherwise.
     */
    public boolean hasTwoPair() {
        int[] pairCounts = new int[Card.Face.values().length];
        for (Card card : hand) {
            pairCounts[card.getFace().ordinal()]++;
        }
        int distinctPairCount = 0;
        for (int count : pairCounts) {
            if (count == 2) {
                distinctPairCount++;
            }
        }
        return distinctPairCount == 2;
    }

    /**
     * Checks if the hand contains three of a kind.
     *
     * @return true if the hand contains three cards of the same face; false
     *         otherwise.
     */
    public boolean hasThreeOfAKind() {
        for (int i = 0; i < hand.size(); i++) {
            int count = 0;
            for (int j = 0; j < hand.size(); j++) {
                if (hand.get(i).getFace().equals(hand.get(j).getFace())) {
                    count++;
                }
            }
            if (count == 3)
                return true;
        }
        return false;
    }

    /**
     * Checks if the hand contains four of a kind.
     *
     * @return true if the hand contains four cards of the same face; false
     *         otherwise.
     */
    public boolean hasFourOfAKind() {
        for (int i = 0; i < hand.size(); i++) {
            int count = 0;
            for (int j = 0; j < hand.size(); j++) {
                if (hand.get(i).getFace().equals(hand.get(j).getFace())) {
                    count++;
                }
            }
            if (count == 4)
                return true;
        }
        return false;
    }

    /**
     * Checks if the hand is a flush.
     *
     * @return true if all cards in the hand have the same suit; false otherwise.
     */
    public boolean hasFlush() {
        Card.Suit suit = hand.get(0).getSuit();
        for (int i = 1; i < hand.size(); i++) {
            if (!hand.get(i).getSuit().equals(suit)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the hand is a straight.
     *
     * @return true if the hand contains five cards of sequential face values;
     *         false otherwise.
     */
    public boolean hasStraight() {
        hand.sort((a, b) -> Integer.compare(a.getFace().getValue(),
                b.getFace().getValue()));
        if (hand.get(0).getFace().equals("Ace") &&
                hand.get(1).getFace().getValue() == 2 &&
                hand.get(2).getFace().getValue() == 3 &&
                hand.get(3).getFace().getValue() == 4 &&
                hand.get(4).getFace().getValue() == 5)
            return true;
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i + 1).getFace().getValue() -
                    hand.get(i).getFace().getValue() != 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the hand is a full house.
     *
     * @return true if the hand contains a three of a kind and a pair; false
     *         otherwise.
     */
    public boolean hasFullHouse() {
        return hasThreeOfAKind() && hasOnePair();
    }

    /**
     * Returns a string representation of the poker hand.
     *
     * @return String representation of the hand.
     */
    public String toString() {
        return Arrays.toString(hand.toArray());
    }
}