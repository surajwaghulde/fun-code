package math;

import java.util.ArrayList;
import java.util.Scanner;

public class Digits40 {

	public static ArrayList<Integer> getDigits(long n) {
        ArrayList<Integer> digitList = new ArrayList<Integer>();
        while(n>0) {
        	digitList.add((int)n%10);
        	n/=10;
        }
        return digitList;
	}
	
	public static int calculateOutput(ArrayList<Integer> digits) {
		int a = 0;
		int b = 0;
		for(int i : digits) {
			if(i%10==4) {
				a++;
			}
			else if(i%10==0) {
				b++;
			}
		}
		return 2*a+b;
	}
	
	public static boolean checkDigits(ArrayList<Integer> digits) {
		for(int i : digits) {
			if (!((i%10==4) || (i%10==0))) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean desiredNumber(ArrayList<Integer> digits) {
    	if(checkDigits(digits)) {
    		int len = digits.size()-1;
    		while(len >= 0 && digits.get(len) == 4) {
    			len--;
    		}
    		while(len >= 0 && digits.get(len) == 0) {
    			len--;
    		}
    		if(len == -1) {
    			return true;
    		}
    	}
    	return false;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        long[] array = new long[length];
        
        
        for(int i = 0; i < length; i++){
           array[i] = in.nextInt(); 
        }
        
        
        for(int i = 0; i < length; i++){
        	ArrayList<Integer> digitList = getDigits(array[i]);
        	if(desiredNumber(digitList)) {
        		System.out.println(calculateOutput(digitList));
        	}
        	else {
        		int multi = 2;
        		while(!desiredNumber(digitList)) {
        			digitList = getDigits(array[i] * multi++);
        		}
        		System.out.println(calculateOutput(digitList));
        	}
         }

    }

}
