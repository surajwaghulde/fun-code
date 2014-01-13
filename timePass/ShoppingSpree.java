package timePass;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ShoppingSpree {

	public static int getAmount(int items, int [] array) {
		int amount = 0;
		for(int i = 0; i < items; i++) {
			amount += array[i];
		}
		return amount;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] array = new int[length];
                
        for(int i = 0; i < length; i++){
           array[i] = in.nextInt(); 
        }        
        
        int items = in.nextInt();
        
        Arrays.sort(array);
         
        System.out.println(getAmount(items, array));
    }
	
}
