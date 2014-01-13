package String;

import java.util.HashMap;

public class FirstNonRepeatedCharacter {

	public char firstNonRepeatedChar(String str) {
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		char temp = ' ';
			
		for(int i = 0; i < str.length(); i++) {
			temp = str.charAt(i);
			if (charMap.containsKey(temp)) {
				int count = charMap.get(temp);
				count++;
				charMap.put(temp, count);
			}			
			else 
				charMap.put(temp , 1);
		}	
		int counter = 0;
		while(charMap.get(str.charAt(counter)) != 1) {
			counter++;
		}
		System.out.println(str.charAt(counter));
		return str.charAt(counter);
	}
	
	public static void main(String [] args) {
		FirstNonRepeatedCharacter firstChar = new FirstNonRepeatedCharacter();
		firstChar.firstNonRepeatedChar("teeter");
	}
	
}
