package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int diff = in.nextInt();
        int[] array = new int[length];
        int result = 0;
        
        for(int i = 0; i < length; i++){
           array[i] = in.nextInt(); 
        }
        
        Arrays.sort(array);
        
        for(int i = 0; i < array.length-1; i++) {
        	int k = i+1;
        	while(((k<array.length)) && (array[k]-array[i] <= diff)) {
        		if((k<array.length) && (array[k]-array[i] == diff)) {
        			result++;
        		}
        		k++;
        	}
        }        
       	System.out.println(result);
        
    }
	
}
