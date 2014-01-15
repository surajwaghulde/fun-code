package fibonacci;

public class Player implements Comparable<Player>{

	String player;
	int score;
	
	public Player(String name, int score) {
		this.player = name;
		this.score = score;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	@Override
	public int compareTo(Player p1) {
		return this.score - p1.score;
	}

}
