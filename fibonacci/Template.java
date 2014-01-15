package fibonacci;

import java.util.ArrayList;
import java.util.Scanner;

public class Template {
	
	public static ArrayList<Integer> getDigits(long n) {
        ArrayList<Integer> digitList = new ArrayList<Integer>();
        while(n>0) {
        	digitList.add((int)n%10);
        	n/=10;
        }
        return digitList;
	}	
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] array = new int[length];
        
        
        for(int i = 0; i < length; i++){
           array[i] = in.nextInt(); 
        }
        
        
        String[] strings = new String [length];
        for(int i = 0; i < length; i++){
            strings[i] = in.next(); 
         }
        
    }

}


