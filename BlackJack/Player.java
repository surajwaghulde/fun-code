package BlackJack;

/*
 * Player of BlackJack game
 */
public class Player {
	
	// defining types of players
	public static enum Type {
		PLAYER, DEALER;
	}	
	private Type type;
	private String name;
	int totalPlayed;
	int totalWon;
	
	public Player(String name) {
		if(name.equalsIgnoreCase("dealer")) {
			type = Type.DEALER;
			this.name = name;
		}
		else {
			type = Type.PLAYER;
			this.name = name;
		}
	}
	
	public double getWiningPercentage() {
		return totalWon/totalPlayed;
	}
	
	public String getName(){
		return this.name;
	}
}
