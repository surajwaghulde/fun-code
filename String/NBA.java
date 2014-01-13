package String;

import java.util.ArrayList;
import java.util.Scanner;

public class NBA {


	public static ArrayList<String> players(String line) {
		ArrayList<String> players = new ArrayList<String>();
		for(int i = 0; i < line.length(); i++) {
			StringBuilder str = new StringBuilder();
			if(line.charAt(i) == '[') {
				i++;
				while(line.charAt(i) != ']') {
					str.append(line.charAt(i));
					i++;
				}
				players.add(str.toString());
			}
		}
		return players;
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        while(in.hasNext()) {
        	list.add(in.nextLine());
        }
        String line = "";
        for(int i = 0; i < list.size(); i++){
           line = list.get(i);
           ArrayList<String> players = players(line);
           for(int j = 0; j < players.size()-1; j++ ) {
        	   System.out.print(players.get(j) + ",");
           }
           if(players.size() > 0) {
               System.out.println(players.get(players.size()-1));        	   
           }
        } 

	}

}
