package BlackJack;

public class Card {

	public enum Rank {
		TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
	}
	
	public enum Suit {
		SPADES, HEARTS, CLUBS, DIAMONDS;
	}

	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;		
	}
	
	public boolean equals(Card card) {
		return (this.rank == card.rank) && (this.suit == card.suit);
	}
	
	public String toString() {
		return rank + " " + suit;
	}
	
	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
}
