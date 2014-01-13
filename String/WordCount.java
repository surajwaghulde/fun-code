package String;

import java.util.HashSet;

public class WordCount {

	HashSet<Character> delimiterSet = new HashSet<Character>();
	
	public void initiatedelimiterSet() {
		delimiterSet.add(',');
		delimiterSet.add('.');
		delimiterSet.add('!');
		delimiterSet.add(';');
		delimiterSet.add('(');
		delimiterSet.add(')');
		delimiterSet.add('/');
		delimiterSet.add('\\');
		delimiterSet.add('[');
		delimiterSet.add(']');
		delimiterSet.add(' ');
	}
	
	public int countWords(String str) {
		char [] input = str.toCharArray();
		int length = input.length;
		int wordCount = 0;
		char prev = '0';
		
		if(length ==1) {
			if(!delimiterSet.contains(input[0])) {
				wordCount++;
			}
			else {
				return 0;
			}
		}
		
		for (int i = 0; i < length; i++) {
			if (delimiterSet.contains(input[i]) && !delimiterSet.contains(prev)) {
//				System.out.println(input[i]);
				wordCount++;
			}
			prev = input [i];
		}
		System.out.println(wordCount);
		if (!delimiterSet.contains(input[length-1])) {
			wordCount++;
		}
		
		return wordCount;
	}
	
	public static void main(String[] args) {
		WordCount wordcount = new WordCount();
		wordcount.initiatedelimiterSet();
		long startTime = System.currentTimeMillis();
		wordcount.countWords("Hi!Hello,  jkasdfj)kasdjfjaskjiiklkalsdfkjhljiiikkk  ");
		long endTime = System.currentTimeMillis();
		System.out.println("Time elapsed " + (endTime-startTime));
		System.out.println(wordcount.countWords("Hi!Hello,  jkasdfj)kasdjfjaskjiiklkalsdfkjhljiiikkk I kajsdfj nnlkasdfkji aksdfasdiin[71234] "));		
	}

}
