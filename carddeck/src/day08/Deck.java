package day08;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Deck {

  public static final String[] SUITS = {"Spade", "Diamond", "Club", "Heart"};
  public static final String[] CARD_NAME = {"Ace", "Two", "Three", "Four", "Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
  public static final Integer[] CARD_VALUES ={1,2,3,4,5,6,7,8,9,10,10,10,10};

  private List<Card> cards = new LinkedList<>();

  //constructor
  public Deck(){
    this.cards = createDeck();
  }

 //Create deck
  private List<Card> createDeck(){
    List<Card> cards = new LinkedList<>();
    for(String suit:SUITS)
      for(Integer i = 0; i <CARD_NAME.length;i++){
        Card card = new Card(suit, CARD_NAME[i],CARD_VALUES[i]);
        cards.add(card);
      }
      return cards;
  }

  public void shuffle() {
    Random rnd = new SecureRandom();

    //Create 2 random integers, get 2 random cards, swop: cannot guarantee even swop, worse case is no swop at all because all 2 cards swopped are being swopped back to original position
    for (Integer i = 0; i < cards.size(); i++) {
      Integer idx0 = rnd.nextInt(cards.size());
      Integer idx1 = rnd.nextInt(cards.size());
      Card card0 = cards.get((int)idx0);
      Card card1 = cards.get((int)idx1);
      cards.set(idx0, card1);
      cards.set(idx1, card0);
    }
  }
  //Shuffle OR
  public void shuffleAlt() {
    Random rnd = new SecureRandom();

    //Create 1 random integer, get a random card and swop with index i card: better to guarantee even swop because at least systematically you swop every card
    for (Integer i = 0; i < cards.size(); i++) {
      Integer idx1 = rnd.nextInt(cards.size());
      Card card0 = cards.get((int)i);
      Card card1 = cards.get((int)idx1);
      cards.set(i, card1);
      cards.set(idx1, card0);
    }
  }

  //have a box, whether the card is in or not
  public Optional<Card> take() {
    if (cards.size() > 0) {
      Card c = cards.remove(0);
      return Optional.of(c);

    }
    return Optional.empty();
  }


  @Override
  public String toString() {
    return "Deck [cards=" + cards + "]";
  }


}
