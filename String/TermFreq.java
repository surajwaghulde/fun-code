package String;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TermFreq {

	HashMap<String, Integer> map = new HashMap<String, Integer>();	
	int  totalTerms;
	
	public void tokenizeAndCount(Scanner scan) {
		String input; 
		while(scan.hasNext()) {
			input = scan.next();
			StringTokenizer tokenize = new StringTokenizer(input, " ,.?!;/'");
			while(tokenize.hasMoreTokens()) {
				String token = tokenize.nextToken();
				totalTerms++;
				if (map.containsKey(token)) {
					map.put(token, map.get(token)+1);
				}
				else {
					map.put(token, 1);
				}
			}
		}		
	}
	
	public int getFrequency(String term) {
		if (map.containsKey(term)) {
			return map.get(term);
		}
		else {
			return 0;
		}
	}
	
	public float getPercentage(String term) {
		return ((float)getFrequency(term))/totalTerms;
	}
	
	public static void main(String[] args) {
		TermFreq freq = new TermFreq();
		String term = args[0];
		Scanner scan;
		if (args.length > 1) {
			String fileName = args[1];
			File file = new File(fileName);
			try {
				scan = new Scanner(file);
				freq.tokenizeAndCount(scan);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else {
			scan = new Scanner(System.in);
			freq.tokenizeAndCount(scan);
		}
		System.out.println("Term Frequency: " + freq.getFrequency(term));
		System.out.println("Percentage: " + freq.getPercentage(term));
	}

}
