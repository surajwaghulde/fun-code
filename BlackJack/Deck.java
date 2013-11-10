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
	
	public Card draw() {
		if (current < deck.length)
			return deck[current++];
		else
			return null;
	}
	
	public boolean hasNext() {
		return current < deck.length;
	}
	
	public void shuffle() {
		for(int i = current; i<deck.length; i++) {
			int shuffleIndex = ((int)(Math.random() * (deck.length - i)) + i);  // shuffle with equal probability
			swapCards(shuffleIndex, i);
		}
	}

	public void swapCards(int shuffleIndex, int current) {
		Card tempCard = deck[current];
		deck[current] = deck[shuffleIndex];
		deck[shuffleIndex] = tempCard;
	}
}
