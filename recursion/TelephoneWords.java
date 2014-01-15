package recursion;

import java.util.ArrayList;
import java.util.HashMap;

public class TelephoneWords {
	
	private static HashMap<Character, char []> chars = new HashMap<Character, char []>(10);
	private char [] digitChars;
	private int nextDigit;
	
	public void populateChars() {
		chars.put(Character.valueOf('2'), new char [] {'a','b','c'});
		chars.put(Character.valueOf('3'), new char [] {'d','e','f'});
		chars.put(Character.valueOf('4'), new char [] {'g','h','i'});
		chars.put(Character.valueOf('5'), new char [] {'j','k','l'});
		chars.put(Character.valueOf('6'), new char [] {'m','n','o'});
		chars.put(Character.valueOf('7'), new char [] {'p','r','s'});
		chars.put(Character.valueOf('8'), new char [] {'t','u','v'});
		chars.put(Character.valueOf('9'), new char [] {'w','x','y'});					
	}
		
	public void getAllWords(String number, String resultSoFar, ArrayList<String> results) {
		if(number.length() == 0) { 
			results.add(resultSoFar);
		} else {			
			Character nextDigit = Character.valueOf(number.charAt(0));
			digitChars = chars.get(nextDigit);
			number = number.substring(1);
			if(digitChars != null) {
				for(char c : digitChars) {
					getAllWords(number, resultSoFar + c, results);
				}							
			}
		}
	}
	
	public static void main(String[] args) {
		TelephoneWords words = new TelephoneWords();
		words.populateChars();
		String number = "234";
		ArrayList<String> allWords = new ArrayList<String>();
		words.getAllWords(number, "", allWords);
		for(String str : allWords) {
			System.out.println(str);
		}
	}

}
