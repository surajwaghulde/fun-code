package math;

import java.util.Scanner;

public class NCR {

	public static int ncr(int n, int m) {
		int result = 1;
		int div = 1;
		for(int i = m; i > 0; i--) {
			result *=n--;
		}
		
		for(int i = 1; i <= m; i ++) {
			div *= i;
		}
		
		return result/div;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] array = new int[length];
        
        for(int i = 0; i < length; i++){
            array[i] = in.nextInt(); 
         }
                
        for(int i = 0; i < length; i++){
        	System.out.println(ncr(array[i],2));
        }
        
    }
}
