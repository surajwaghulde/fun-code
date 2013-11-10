package BlackJack;

import java.util.ArrayList;

import BlackJack.Deck;
import BlackJack.Card;
import BlackJack.Player;

public class Hand {

	private Player player;
	private static final int MaxPoints = 21;
	private int totalPoints;
	private int numberOfAces;
	boolean isSurrender = false;
	boolean doubleDown = false;
	boolean stand = false;
	private int bet;
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Hand(String name) {
		this.player = new Player(name);
	}
	
	public Card getNextCard(Deck deck){
		Card card = deck.draw();
		if(card != null){
			this.cards.add(card);
			return card;
		}
		return null;		
	}	
	
	public void updatePoints(Card card) {
		switch (card.getRank()) {
		case ACE:
			totalPoints += 11;
			numberOfAces++;
			break;
		case TWO:
			totalPoints += 2;
			break;
		case THREE:
			totalPoints += 3;
			break;
		case FOUR:
			totalPoints += 4;
			break;
		case FIVE:
			totalPoints += 5;
			break;
		case SIX:
			totalPoints += 6;
			break;
		case SEVEN:
			totalPoints += 7;
			break;
		case EIGHT:
			totalPoints += 8;
			break;
		case NINE:
			totalPoints += 9;
			break;
		case TEN:
		case JACK:
		case QUEEN:
		case KING:
			totalPoints += 10;
			break;
		}
	}
	
	public void updatePoints() {
		for (Card card : cards) {
			switch (card.getRank()) {
			case ACE:
				totalPoints += 11;
				numberOfAces++;
				break;
			case TWO:
				totalPoints += 2;
				break;
			case THREE:
				totalPoints += 3;
				break;
			case FOUR:
				totalPoints += 4;
				break;
			case FIVE:
				totalPoints += 5;
				break;
			case SIX:
				totalPoints += 6;
				break;
			case SEVEN:
				totalPoints += 7;
				break;
			case EIGHT:
				totalPoints += 8;
				break;
			case NINE:
				totalPoints += 9;
				break;
			case TEN:
			case JACK:
			case QUEEN:
			case KING:
				totalPoints += 10;
				break;
			}
		}
	}
	
	public boolean isBusted() {
		// ace adjustment - remove 10 points every time there is an ace and total is a bust
		if ( totalPoints > MaxPoints) {
			totalPoints = totalPoints - (numberOfAces*10);
			if (totalPoints > MaxPoints) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkHit() {
		return (!isBusted() && !doubleDown && !isSurrender);
	}

	public void doSurrender() {
		isSurrender = true;
	}
	
	public void doStand() {
		stand = true;
	}
	
	public boolean checkDouble() {
		if(!isBusted() && !doubleDown && !isSurrender) {
			doubleDown = true;
			return true;
		}		
		return false;
	}
	
	public boolean isSoft17(){
		if (numberOfAces==1 && totalPoints<18) {
			return true;
		}
		if (numberOfAces==0 && totalPoints<17) {
			return true;
		}
		return false;
	}
	
	public boolean is21() {
		if (totalPoints == 21) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Card> getCards() {
		return this.cards;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}
	
}
