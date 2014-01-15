package search;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MissingNumbers {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length1 = in.nextInt();
        
        int[] array1 = new int[length1];        
        for(int i = 0; i < length1; i++){
           array1[i] = in.nextInt(); 
        }

        int length2 = in.nextInt();
        int[] array2 = new int[length2];        
        for(int i = 0; i < length2; i++){
           array2[i] = in.nextInt(); 
        }
        
        Map<Integer, Integer> map1 = new TreeMap<Integer, Integer>();
        for (int i : array1) {
        	if(map1.containsKey(i)) {
        		map1.put(i, map1.get(i)+1);
        	}
        	else {
        		map1.put(i, 1);        		
        	}
        }
        
        Map<Integer, Integer> map2 = new TreeMap<Integer, Integer>();
        for (int i : array2) {
        	if(map2.containsKey(i)) {
        		map2.put(i, map2.get(i)+1);
        	}
        	else {
        		map2.put(i, 1);        		
        	}
        }
        
        for(int i : map2.keySet()) {
        	int diff = map2.get(i) - map1.get(i);
        	if(diff>0) {
        		System.out.print(i + " ");
        	}
        }
    }
}
