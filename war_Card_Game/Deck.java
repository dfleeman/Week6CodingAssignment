package war_Card_Game;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


 // This class represents a card deck. The deck is populated with cards in the constructor. 
	public class Deck extends LinkedList<Card> {
		/* The internal list of person names that is used to generate the deck. */
		
	private final List<String> number = List.of("Two", "Three", "Four", "Five", "Six", "Seven",
      "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace");

	//   The internal list of suits that is used to generate the deck.   
	private final List<String> suits = List.of("Clubs", "Spades", "Hearts", "Diamonds");

	/*The deck of cards is populated in this constructor. A card is a combination
    of number and suit. Each card also has a rank, which is the position of the number 
    element in the number list with 1 added to it, so no card has a 0 value. */  
	public Deck() {
		for(int numberPos = 0; numberPos < number.size(); numberPos++) {
			int rank = numberPos + 1;
			String numbers = number.get(numberPos);

			for(String suit : suits) {
				add(new Card(numbers, suit, rank));
      }
    }
  }  
	// Shuffle the cards in the deck.
   
	public void shuffle() {
   
	Collections.shuffle(this);
    //System.out.println(this); //Printing the shuffled deck for debugging.
  }  
	//  Draw and return the "top" card from the deck.   
	//  Return The "top" card.   
	public Card draw() {
		return remove(0);
	}
}
