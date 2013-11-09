package BlackJack;

import BlackJack.Card;

public class Deck {

	private static final int DECK_SIZE = 52; // single deck of cards
	
	private Card[] deck;
	private int current;
	
	public Deck() {
		deck = new Card[DECK_SIZE];
		int i = 0;
		for(Card.Rank r : Card.Rank.values()) 
			for(Card.Suit s : Card.Suit.values()) 
				deck[i++] = new Card(r, s);
	}
	
	public void shuffle() {		
		for(int i=0; i<deck.length; i++) {
			int shuffleIndex = ((int)(Math.random() * i) - i) + i;
			swapCards(shuffleIndex, i);
		}
	}

	public void swapCards(int shuffleIndex, int current) {
		Card tempCard = deck[current];
		deck[current] = deck[shuffleIndex];
		deck[shuffleIndex] = tempCard;
	}
}
