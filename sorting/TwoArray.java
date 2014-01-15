package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class TwoArray {
	
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
		Boolean bool = new Boolean(Boolean.TRUE);
        int cases = in.nextInt();
        for(int i = 0; i < cases; i++) {
        	int length = in.nextInt();
        	int sum = in.nextInt();
            int[] array1 = new int[length];

            for(int j=0;j<length;j++){
               array1[j]=in.nextInt(); 
            }

            int[] array2 = new int[length];
            for(int j=0;j<length;j++){
               array2[j]=in.nextInt(); 
            }
            
            Arrays.sort(array1);
            Arrays.sort(array2);
            
            for(int k = 0; k < length; k++) {
            	if(!(array1[k] + array2[length-k-1] >= sum)) {
            		bool = Boolean.FALSE;
            	}
            }
                                    
            if(!bool) {
            	bool = Boolean.TRUE;
                for(int k = 0; k < length; k++) {
                	if(!(array2[k] + array1[length-k-1] >= sum)) {
                		bool = Boolean.FALSE;
                	}
                }            	
            }            
            
            if(bool) {
            	System.out.println("YES");
            }
            else {
            	System.out.println("NO");
            }
        }
    }
}
