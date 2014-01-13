package heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import fibonacci.Player;

public class TopPlayers {
	
	private PriorityQueue<Player> pq = new PriorityQueue<Player>(10, new PlayerComparator());
	private static final int A = 2; 
	private static final int B = 1;
	private static final int C = 6;
	private static final int D = -1;
	
	public int calculate(String line) {
		int score = 0;
		StringTokenizer strtok = new StringTokenizer(line, ",");
		strtok.nextToken();
		score += (A * Integer.parseInt(strtok.nextToken()));
		score += (B * Integer.parseInt(strtok.nextToken()));
		score += (C * Integer.parseInt(strtok.nextToken()));
		score += (D * Integer.parseInt(strtok.nextToken()));
		return score;
	}
	
	public String getPlayer(String line) {
		StringTokenizer strtok = new StringTokenizer(line, ",");
		return strtok.nextToken();
	}
	
	public void printTopPlayers() {
		PriorityQueue<Player> cloned = new PriorityQueue<Player>(10, new PlayerComparator());				
		for(Player p : pq) {
			cloned.add(p);
		}
		while(cloned.peek() != null) {
			Player p = cloned.poll();
			System.out.println(p.player + " " + p.score);
		}
	} 
	
	public static void main(String[] args) {
		TopPlayers topPlayers = new TopPlayers();
        Scanner in = new Scanner(System.in);
        String line = "";
        
        while(in.hasNext()) {
        	line = in.nextLine();
        	int count = 0;
        	if(line.equalsIgnoreCase("PRINT")) {
        		topPlayers.printTopPlayers();
        	}
        	else {
        		String playerName = topPlayers.getPlayer(line);
        		int score = topPlayers.calculate(line);
        		count++;
        		Comparator<Player> comparator = new PlayerComparator();
        		Player player = topPlayers.new Player(playerName, score);
        		topPlayers.pq.add(player);
        	}
        	
        }
	}
	
	class Player implements Comparable<Player>{

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
	
	static class PlayerComparator implements Comparator<Player> {

		@Override
		public int compare(Player o1, Player o2) {
//			if (o1.score < o2.score) {
//				return 1;
//				
//			}
//			if (o1.score > o2.score) {
//				return -1;
//				
//			}
			return o2.score - o1.score;
		}
		
	}
	
}
