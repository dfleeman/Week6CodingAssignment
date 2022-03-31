package war_Card_Game;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class App {
	
	   //This is the list of player names. This list never changes for the purposes of this coding project. 
	   private final List<String> pacman = List.of("Inky", "Pinky", "Clyde", "Blinky", "Sue", "Pac-Man", "Ms. Pac-Man");

	  // This allows the game to generate two random player names from the list. 
	  private Random random = new Random();
	  
	  public static void main(String[] args) {
	    new App().run();
	  }	  
	   //This method creates the players, creates and shuffles the deck, and plays the game.	   
	  private void run() {
	    
	     //Create a new list of member names. This list is modified by removing names of player members, so
	     //that the original list (pacman) is not modified.	     
	    List<String> names = new LinkedList<>(pacman);
	    Player player1 = selectPlayer(names);
	    Player player2 = selectPlayer(names);
	    
	    System.out.println(player1.getName() + " VS " + player2.getName() + ".");//Print the two player names

	    // Create and shuffle the deck. 
	    Deck deck = new Deck();
	    deck.shuffle();

	    // Deal the cards evenly to each player. 
	    deal(deck, player1, player2);

	    //Play the game. 
	    play(player1, player2);

	    //Announce the winner. If there is no winner, announce a tie. */
	    declareWinner(player1, player2);
	  }	  
	   //Figure out which player has the highest score and announce the winner.  
	  private void declareWinner(Player player1, Player player2) {
	    if (player1.getScore() > player2.getScore()) {
	      printWinner(player1);
	      printLoser(player2);
	    } else if (player2.getScore() > player1.getScore()) {
	      printWinner(player2);
	      printLoser(player1);
	    } else {
	      printTie(player1, player2);
	    }
	  }	  
	   //Announce the loser.
	    private void printLoser(Player loser) {
	    	System.out.println(loser.getName() + " LOSES with a score of "
	        + loser.getScore() + ".");
	  }	  
	   //Announce the winner.	   
	  private void printWinner(Player winner) {
	    System.out.println(
	        winner.getName() + " WINS with a score of " + winner.getScore() + ".");
	  }	  
	   //Announce a tie, in which both players have the same score.	  
	  private void printTie(Player player1, Player player2) {
	    System.out.println(player1.getName() + " and " + player2.getName() + " tied with a score of "
	        + player1.getScore() + ".");
	  }	  
	  //This method plays the game and stores each player's score.   
	  private void play(Player player1, Player player2) {   	 
	     
	  //Each player has the same number of cards so pick one to get the number of cards, which equals the number of turns.
	  int numTurns = player1.getHand().size();
	    System.out.println(player1.getName() + " draws: \t" + player1.getHand());//Print Player1 Hand
		System.out.println(player2.getName() + " draws: \t" + player2.getHand());//Print Player2 Hand
	    
	    /*For each turn, players flip over the top card in their hand, which removes the card from the
	     hand. The card ranks are compared, and the winning player increments the score in the Player
	     object. If there is a tie, neither player score increments. */
	    for (int turn = 0; turn < numTurns; turn++) {
	      Card card1 = player1.flip();
	      Card card2 = player2.flip();

	      if (card1.getRank() > card2.getRank()) {
	        player1.incrementScore();
	      } else if (card2.getRank() > card1.getRank()) {
	        player2.incrementScore();
	      }
	    }
	  }	 
	   //Deal the deck evenly to each player. The cards in the deck go into the players' hands.	  
	  private void deal(Deck deck, Player player1, Player player2) {
	    int size = deck.size();	    
	    for (int index = 0; index < size; index++) {	      
	       //Using the modulo operator to determine which player gets a card. Player 1 gets one card, Player 2 the next one.	       
	      if (index % 2 == 0) {
	        player1.draw(deck);
	      } else {
	        player2.draw(deck);
	      }
	    }
	  }
	  /*Randomly select a player name from the given list. The player name is removed from the list so
	   	that the same player is not selected twice. */
	  private Player selectPlayer(List<String> names) {
	    int pos = random.nextInt(names.size());
	    String playerName = names.remove(pos);
	    return new Player(playerName);
	  }
	}