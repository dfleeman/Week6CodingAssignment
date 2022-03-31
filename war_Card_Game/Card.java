package war_Card_Game;

	
	//This class represents a Card in the game, War. A Card contains a type name, a suit, and a rank. 
	//Cards are created in the Deck constructor.	

	public class Card {
		private String number;
		private String suit;
		private int rank;

	/*  Create and initialize a Card object.   
  	number = value of the card.
  	suit = suit of the card.
  	rank = the card rank, used for scoring.	   */
 
	public Card(String number, String suit, int rank) {
		this.number = number;
		this.suit = suit;
		this.rank = rank;
	}

	// Returns a String representation of the Card object (Three of Diamonds, King of Clubs, etc)
  	  
	@Override
	public String toString() {
		return number + " of " + suit;
	}
 
	//The rank of the card. Ranks are assigned by the Deck class when the card is created.
  
	public int getRank() {
		return rank;
	}
}