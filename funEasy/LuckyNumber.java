package funEasy;

import java.util.Scanner;

public class LuckyNumber {

    public static boolean luckkyDigits(int n) {
    	for(int i=n; i >0; i=i/10) {
            if(!(i % 10 == 4 || i % 10 == 7)) {
            	return Boolean.FALSE;
            }
    	}
    	return Boolean.TRUE;
    }
	
	public static int count(int num, int num2) {        
        int count = 0;        
        for(int i = num2; i >= num; i--) {
            if((i % 10 == 4 || i % 10 == 7) && luckkyDigits(i)) {
            	count++;
            }        	
        }
		return count;
	}
	
    public static void main(String[] args) {    	    	
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int num2 = in.nextInt();
        
        
        System.out.println(count(num, num2));
        
    }

}
