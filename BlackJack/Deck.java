package BlackJack;

import BlackJack.Card;

public class Deck {

	private static final int DECK_SIZE = 52;   // single deck of cards
	
	private Card[] deck;
	private int current;
	int round;
	
	public Deck() {
		deck = new Card[DECK_SIZE];
		int i = 0;
		for(Card.Rank r : Card.Rank.values()) 
			for(Card.Suit s : Card.Suit.values()) 
				deck[i++] = new Card(r, s);
	}
	
	public Card[] getDeck() {    // single deck
		return deck;
	}
	
	// draw a card from the deck
	public Card draw() {
		if (current < deck.length)
			return deck[current++];
		else {
			System.out.println("Deck has few cards to continue the game");     // in case the cards in the deck run out for multiplayer game with single deck
			throw new RuntimeException("Deck has few cards to continue the game");    // since the game is 2 players this case should not happen
		}		
	}
	
	public boolean hasNext() {
		return current < deck.length;
	}
	
	public void shuffle() {
		for(int i = current; i<deck.length; i++) {
			int shuffleIndex = ((int)(Math.random() * (deck.length - i)) + i);  // shuffle with equal probability
			swapCards(shuffleIndex, i);
		}
		current = 0;    // we can take the cards from done hands, this logic can be more refined than reusing the cards by setting current = 0
	}

	// swap the cards 
	public void swapCards(int shuffleIndex, int current) {
		Card tempCard = deck[current];
		deck[current] = deck[shuffleIndex];
		deck[shuffleIndex] = tempCard;
	}
}
