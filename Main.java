//
// Author: Caiden Sanders
// Date: January 16, 2024
// Project: CS145 Lab 2
// Purpose: This class is the entry point for the Poker Game application. It
// demonstrates the creation and functionality of a PokerHand object from the
// PokerGame package. The class showcases the ability to deal, shuffle, and
// evaluate poker hands based on standard poker hand rankings.
//
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    PokerHand myPokerHand = new PokerHand(Arrays.asList(new Card(Card.Face.DEUCE, Card.Suit.CLUBS),
        new Card(Card.Face.FIVE, Card.Suit.HEARTS),
        new Card(Card.Face.DEUCE, Card.Suit.DIAMONDS),
        new Card(Card.Face.FIVE, Card.Suit.SPADES),
        new Card(Card.Face.FIVE, Card.Suit.CLUBS)));

    System.out.println("My poker hand looks like this: " + myPokerHand + "\n");
    System.out.println("Is a pair? " + myPokerHand.hasOnePair());
    System.out.println("Is a two pair? " + myPokerHand.hasTwoPair());
    System.out.println(
        "Is a three of a kind? " + myPokerHand.hasThreeOfAKind());
    System.out.println("Is a four of a kind? " + myPokerHand.hasFourOfAKind());
    System.out.println("Is a flush? " + myPokerHand.hasFlush());
    System.out.println("Is a straight? " + myPokerHand.hasStraight());
    System.out.println("Is a full house? " + myPokerHand.hasFullHouse() + "\n");
    myPokerHand.shuffle();
    System.out.println("My poker hand looks like this: " + myPokerHand + "\n");
    System.out.println("Is a pair? " + myPokerHand.hasOnePair());
    System.out.println("Is a two pair? " + myPokerHand.hasTwoPair());
    System.out.println(
        "Is a three of a kind? " + myPokerHand.hasThreeOfAKind());
    System.out.println("Is a four of a kind? " + myPokerHand.hasFourOfAKind());
    System.out.println("Is a flush? " + myPokerHand.hasFlush());
    System.out.println("Is a straight? " + myPokerHand.hasStraight());
    System.out.println("Is a full house? " + myPokerHand.hasFullHouse() + "\n");
    myPokerHand.shuffle();
    System.out.println("My poker hand looks like this: " + myPokerHand + "\n");
    System.out.println("Is a pair? " + myPokerHand.hasOnePair());
    System.out.println("Is a two pair? " + myPokerHand.hasTwoPair());
    System.out.println(
        "Is a three of a kind? " + myPokerHand.hasThreeOfAKind());
    System.out.println("Is a four of a kind? " + myPokerHand.hasFourOfAKind());
    System.out.println("Is a flush? " + myPokerHand.hasFlush());
    System.out.println("Is a straight? " + myPokerHand.hasStraight());
    System.out.println("Is a full house? " + myPokerHand.hasFullHouse() + "\n");
  }
}