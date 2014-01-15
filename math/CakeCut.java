package math;

import java.util.Scanner;

public class CakeCut {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] array = new int[length];        
        
        for(int i = 0; i < length; i++){
           array[i] = in.nextInt(); 
        }

        for(int i = 0; i < length; i++) {
        	int cuts = array[i];
        	long half = cuts/2;
        	long other = cuts - half;
        	System.out.println(half*other);
        	
        }
    }
}
