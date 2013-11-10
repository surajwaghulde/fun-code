package BlackJack;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import BlackJack.Hand;

/*
 * BlackJack the game of 21
 * @author : Suraj Waghulde
 */
public class BlackJack {
	
	private static PrintStream output;
	private static Scanner input;
	
	private Deck deck;
	private Player player;
	private String playerName;
	private int round;
	private static final int defaultSize = 2;
	private Move nextMove;
	private Card nextCard;
	private static boolean gameOver;
	Hand playerHand;
	Hand dealerHand;

	static {    // command line static initializations
		output = System.out;
		input = new Scanner(System.in);
	}
	
	// Distributing the initial cards
	public void initialDistributionOfCards() {
		for(int i = 0; i < defaultSize; i++){
			playerHand.getNextCard(deck);
			dealerHand.getNextCard(deck);
		}
		playerHand.updatePoints();
		dealerHand.updatePoints();
		
		System.out.println("player cards");    // print player cards
		for(Card card : playerHand.getCards()) {
			System.out.println(card.toString());
		}
		
		System.out.println("dealer cards");    // print dealer cards
		for(Card card : dealerHand.getCards()) {
			System.out.println(card.toString());
		}
		System.out.println(player.getName() + " total points " + playerHand.getTotalPoints());    // print players total points
		System.out.println("Dealer total points " + dealerHand.getTotalPoints());     // print dealers total points
	}

	// Command Line Black Jack game
	public void playBlackJack() {
		playerName = input.nextLine();
		player = new Player(playerName);
		deck = new Deck();

		if(round++%6 == 0) {    // shuffle the deck of cards every 6 rounds
			deck.shuffle();
		}
		
		playerHand = new Hand(playerName);
		dealerHand = new Hand("dealer");
		initialDistributionOfCards();     // distribute cards as first step of the game
		
		while(true) {
			System.out.println("Round " + round);
			if(round++%6 == 0) {
				deck.shuffle();
			}			
			
			output.println();
			output.println("Enter next move ");     // players next move
			nextMove = Move.valueOf(input.nextLine());
			switch (nextMove) {
				case HIT : 
					if(playerHand.checkHit()) {
						nextCard = playerHand.getNextCard(deck);
						playerHand.updatePoints(nextCard);
					}
					break;
				case STAND :
					playerHand.doStand();
					break;
				case DOUBLE :
					if(playerHand.checkDouble()) {
						nextCard = playerHand.getNextCard(deck);
						playerHand.updatePoints(nextCard);
					}
					break;
				case SURRENDER :
					playerHand.doSurrender();
					break;
			}	
			
			if(playerHand.isSurrender) {    // counting players surrender as losing the game
				playerLost(player);
				System.out.println(player.getName() + " surrendered this game.");
				gameOver = true;
			}	
			
			if(dealerHand.isSoft17()) {    // dealer hits on soft 17 
				if(dealerHand.checkHit()) {
					nextCard = dealerHand.getNextCard(deck);
					dealerHand.updatePoints(nextCard);
				}
			}
			
			System.out.println("player cards");    // print player cards
			for(Card card : playerHand.getCards()) {
				System.out.println(card.toString());
			}
			
			System.out.println("dealer cards");    // print dealer cards
			for(Card card : dealerHand.getCards()) {
				System.out.println(card.toString());
			}
			
			System.out.println(player.getName() + " total points " + playerHand.getTotalPoints());    // print players total points
			System.out.println("Dealer total points " + dealerHand.getTotalPoints());    // print dealers total points
			
			if(dealerHand.isBusted()) {     // check who is busted
				if(playerHand.isBusted()) {
					System.out.println("Both players are busted.");
					playerLost(player);
				}
				else {
					playerWon(player);
					System.out.println("Dealer is busted with points " + dealerHand.getTotalPoints() + " and you won this game.");					
				}
				gameOver = true;
			}
			
			if(playerHand.isBusted() && !gameOver) {
				playerLost(player);
				System.out.println(player.getName() + " is busted and lost this game.");
				gameOver = true;
			}
			
			if(!dealerHand.isSoft17() && !gameOver) {    // dealer is done choosing the cards
				if(playerHand.getTotalPoints() > dealerHand.getTotalPoints()) {
					playerWon(player);
					System.out.println("Congratulations you won the game");
					gameOver = true;
				}
			}						
			
			// decide who wins if player stands and dealer is done choosing the cards or if player has played Double Down
			if(((playerHand.stand  && !dealerHand.isSoft17()) || playerHand.doubleDown) && !gameOver) {
				if(dealerHand.getTotalPoints() > playerHand.getTotalPoints()) {
					playerLost(player);
					System.out.println("dealer won the game");
					gameOver = true;
				}
				else {
					if(dealerHand.getTotalPoints() == playerHand.getTotalPoints()) {
						System.out.println("equal points - a tie.");
						playerLost(player);    //player did not win, so not counting this game in wining percentage.
						gameOver = true;
					} else {
						playerWon(player);
						System.out.println("Congratulations you won the game");
						gameOver = true;
					}
				}
			}				
			
			if(gameOver) {
				 // there is no precise definition of wining so counting table wins
				System.out.println("Total games won " + player.totalWon + ". Total games played " + player.totalPlayed);
				System.out.println("Wining percentage " + 100*((double)player.totalWon/player.totalPlayed));
				if(nextGame()) {
					round++;
					playerHand = new Hand(playerName);
					dealerHand = new Hand("dealer");
					initialDistributionOfCards();
					gameOver = false;
					continue;
				}
				else {
					break;
				}
			}
		}		
	}
	
	// check whether user wants to play more
	public boolean nextGame() {
		System.out.println("Up for next Game \\../ Y/N ?");
		if(input.nextLine().equalsIgnoreCase("y")) {
			return true;
		}
		return false;
	}
	
	public void playerWon(Player player) {
		player.totalPlayed++;
		player.totalWon++;
	}
	
	public void playerLost(Player player) {
		player.totalPlayed++;
	}
	
	public static void main(String[] args) {		
		BlackJack blackjackGame = new BlackJack();
		output.println("Starting BlackJack :");
		output.println("Enter your name: ");
		blackjackGame.playBlackJack();
	}
	
}
