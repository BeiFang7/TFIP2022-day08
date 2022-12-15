package day08;

public class Card {
  
  //if got final member, values must be set in the constructor
  private final String suit;
  private final String name;
  private final Integer value;

  //Constructor
  public Card(String suit, String name, Integer value){
    this.suit = suit;
    this.name = name;
    this.value = value;
  }

  //Getters only because we cannot change the card
  public String getSuit() {
    return suit;
  }
  public String getName() {
    return name;
  }
  public Integer getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Card [suit=" + suit + ", name=" + name + ", value=" + value + "]";
  }
  
  
  
  
}