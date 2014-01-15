package funEasy;

import java.util.Scanner;

public class AnagramCharChanges {

	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int cases = in.nextInt();
	        int [] occur1 = new int[26];
	        int [] occur2 = new int[26];
	        
	        
	        for(int k = 0; k < cases; k++) {	        	
		        for(int j = 0; j < 26; j++) {
		        	occur1[j] = 0;
		        	occur2[j] = 0;
		        }
		        
		        String str = in.next();
		        str = str.toLowerCase();
		        int length = str.length();
		        
		        if(length%2 == 1) {
		        	System.out.println(-1);
		        	continue;
		        }
		        
		        char [] chars = str.toCharArray();		        
		        int changes = 0;
		        
		        for(int i = 0; i < length/2; i++){
		        	occur1[chars[i]-'a']++;
		        	occur2[(chars[length-i-1])-'a']++;
		        }

		        for(int i = 0;i < 26; i++) {
		        	changes += Math.abs(occur1[i] - occur2[i]);
		        }
		        
		        System.out.println(changes/2);
	        }
	    }	
	
}
