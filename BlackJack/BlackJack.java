package BlackJack;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import sun.tools.tree.DoStatement;

import BlackJack.Hand;

public class BlackJack {
	
	private static PrintStream output;
	private static Scanner input;
	
	private Deck deck;
	private ArrayList<Hand> hands = new ArrayList<Hand>();
	private Player player;
	private String playerName;
	private int round;
	private static final int defaultSize = 2;
	private Move nextMove;
	private Card nextCard;
	private static boolean gameOver;

	static {
		output = System.out;
		input = new Scanner(System.in);
	}

	public void playBlackJack() {
		playerName = input.nextLine();
		player = new Player(playerName);
		deck = new Deck();

		if(round++%6 == 0) {
			deck.shuffle();
		}
		
		Hand playerHand = new Hand(playerName);
		Hand dealerHand = new Hand("dealer");
		hands.add(playerHand);
		hands.add(dealerHand);
		
		for(int i = 0; i < defaultSize; i++){
			playerHand.getNextCard(deck);
			dealerHand.getNextCard(deck);
		}
		playerHand.updatePoints();
		dealerHand.updatePoints();
		System.out.println(player.getName() + " total points " + playerHand.getTotalPoints());
		System.out.println("Dealer total points " + dealerHand.getTotalPoints());
		
		while(true) {
			System.out.println("Round " + round);
			if(round++%6 == 0) {
				deck.shuffle();
			}
			
			System.out.println("player cards");
			for(Card card : playerHand.getCards()) {
				System.out.println(card.toString());
			}
			
			System.out.println("dealer cards");
			for(Card card : dealerHand.getCards()) {
				System.out.println(card.toString());
			}
			
			output.println();
			output.println("Enter next move ");
			nextMove = Move.valueOf(input.nextLine());
			switch (nextMove) {
				case HIT : 
					if(playerHand.checkHit()) {
						nextCard = playerHand.getNextCard(deck);
						playerHand.updatePoints(nextCard);
					}
					break;
				case STAND :
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
			
			if(playerHand.isSurrender) {
				playerLost(player);
				System.out.println(player.getName() + " surrendered this game.");
				gameOver = true;
			}	
			
			if(dealerHand.isSoft17()) {
				if(dealerHand.checkHit()) {
					nextCard = dealerHand.getNextCard(deck);
					dealerHand.updatePoints(nextCard);
				}
			}
			
			System.out.println("player cards");
			for(Card card : playerHand.getCards()) {
				System.out.println(card.toString());
			}
			
			System.out.println("dealer cards");
			for(Card card : dealerHand.getCards()) {
				System.out.println(card.toString());
			}
			
			System.out.println(player.getName() + " total points " + playerHand.getTotalPoints());
			System.out.println("Dealer total points " + dealerHand.getTotalPoints());
			
			if(dealerHand.isBusted()) {
				playerWon(player);
				System.out.println("Dealer is busted with points " + dealerHand.getTotalPoints() + " and you won this game.");
				gameOver = true;
			}
			
			if(playerHand.isBusted()) {
				playerLost(player);
				System.out.println(player.getName() + " is busted and lost this game.");
				gameOver = true;
			}
			
			if(!dealerHand.isSoft17()) {
				if(playerHand.getTotalPoints() > dealerHand.getTotalPoints()) {
					playerWon(player);
					System.out.println("Congratulations you won the game");
					gameOver = true;
				}
			}						
			
			if(playerHand.stand || playerHand.doubleDown) {
				if(dealerHand.getTotalPoints() > playerHand.getTotalPoints()) {
					playerLost(player);
					System.out.println("Congratulations you won the game");
					gameOver = true;
				}
			}				
			
			if(gameOver) {
				if(nextGame()) {
					continue;
				}
				else {
					break;
				}
			}
		}		
	}
	
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
