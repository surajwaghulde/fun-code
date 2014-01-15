package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LonelyInteger {
/* Head ends here */

    
    static int lonelyinteger(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : a) {
            if(map.containsKey(i)) {
            	map.put(i, map.get(i)+1);
            }
            else {
                map.put(i, 1);            	
            }
        }
        Set<Integer> keySet = map.keySet();
        for(int i : keySet) {
        	if(map.get(i)==1) {
        		return i;
        	}
        }        
        return -1;
    }
    
    
/* Tail starts here */
public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
           int length = in.nextInt();
           int[] array = new int[length];
           for(int i=0;i<length;i++){
              array[i]=in.nextInt(); 
           }
          int res;
               
        res = lonelyinteger(array);
        System.out.println(res);
        
    }
}