package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ClosestNumbers {

	
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] array = new int[length];
        int min = Integer.MAX_VALUE;
        int minOfAll = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < length; i++){
           array[i] = in.nextInt(); 
        }
        
        Arrays.sort(array);
        
        for(int i = 0; i < array.length-1; i++) {        	
    		if(Math.abs(array[i+1] - array[i]) < minOfAll) {
    			minOfAll = Math.abs(array[i+1] - array[i]);
    			list.clear();
    			list.add(i);
    			list.add(i+1);
    		}
    		else {
        		if(Math.abs(array[i+1] - array[i]) == minOfAll) {
        			list.add(i);
        			list.add(i+1);
        		}
    		}        		
        }
        
        for(int i : list) {
        	System.out.print(array[i] + " ");
        }
        
    }

}
