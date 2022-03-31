package war_Card_Game;

import java.util.LinkedList;
import java.util.List;

	
public class Player {
	private String name;
	private List<Card> hand = new LinkedList<>();
	private int score = 0;
		 
	public Player(String name) {
		this.name = name;
	}	
	//Return the player name.	
	public String getName() {
		return name;
	}		
	//Remove the "top" card from the deck and add it to the player's hand.	
	public void draw(Deck deck) {
		getHand().add(deck.draw());
	}    	
	 //Return the player's current hand. 	
	public List<Card> getHand() {
		return hand;
	}	
	 //Remove and return the "top" card from the player's hand.	 
	public Card flip() {
		return hand.remove(0);
	}	
	 //Increment the player's score by 1.	 
	public void incrementScore() {
		score = getScore() + 1;
	}	
	 //Return the player's current score.	 
	public int getScore() {
		return score;
	 }
	}