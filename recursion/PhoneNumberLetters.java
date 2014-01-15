package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumberLetters {

	    private static Map<Character, char[]> digitMap;
	    static {
	        digitMap = new HashMap<Character, char[]>();

	        digitMap.put(Character.valueOf('0'), new char[] { ' ' });
	        digitMap.put(Character.valueOf('1'), new char[] { ' ' });
	        digitMap.put(Character.valueOf('2'), new char[] { 'a', 'b', 'c' });
	        digitMap.put(Character.valueOf('3'), new char[] { 'd', 'e', 'f' });
	        digitMap.put(Character.valueOf('4'), new char[] { 'g', 'h', 'i' });
	        digitMap.put(Character.valueOf('5'), new char[] { 'j', 'k', 'l' });
	        digitMap.put(Character.valueOf('6'), new char[] { 'm', 'n', 'o' });
	        digitMap.put(Character.valueOf('7'), new char[] { 'p', 'r', 's' });
	        digitMap.put(Character.valueOf('8'), new char[] { 't', 'u', 'v' });
	        digitMap.put(Character.valueOf('9'), new char[] { 'w', 'x', 'y' });
	    }

	    public static void convert(String input, String resultSoFar, List<String> allResults) {

	        if (input.length() == 0) {
	            // We have hit the end of the input phone number and thus the end of
	            // recursion
	            allResults.add(resultSoFar);
	        } else {
	            // Strip the next character off the front of the phone number
	            Character nextDigit = Character.valueOf(input.charAt(0));

	            // Look up the list of mappings from that digit to all letters
	            char[] mappingArray = digitMap.get(nextDigit);

	            // More robust error handling would throw an exception or do
	            // something else when an unknown character was encountered in the
	            // phone number.
	            if (mappingArray != null) {

	                // We have processed the first digit in the rest of the number,
	                // so recurse with the rest of the number
	                String inputTail = input.substring(1);

	                // By iterating through the array the mapping lists do not all
	                // have to be the same size.
	                for (char nextLetter : mappingArray) {
	                    // Put the next mapped letter on the end of the result being
	                    // built and recurse
	                    convert(inputTail, resultSoFar + nextLetter, allResults);
	                }
	            }
	        }

	    }
	    public static void main(String[] args) {

	        // Simplified version that does not ask for input
	        String num = "234";
	        List<String> results = new ArrayList<String>();

	        // Starting condition is that the entire input needs to be processed,
	        // the result so far is empty, and we have nothing in the list of final
	        // answers
	        convert(num, "", results);

	        for (String nextResult : results) {
	            System.out.println(nextResult);
	        }

	        System.out.println("End of results list. Total words generated: " + results.size());
	    }
}
