package sorting;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Median {
    
    public int median(int [] array) {     
        int medianPosition = array.length/2;
        return median(array, 0, array.length-1, medianPosition);
    }
    
    public void swap(int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public int median(int [] array, int low, int high, int medianPosition) {
        int pivot = array[low];
        int left = low;
        int right = high+1;
        
        while(left < right) {
            while(array[++left] < pivot) {
                if(left == high) {
                    break;
                }
            }        
            while(array[--right] > pivot) {
                if(right == low) {
                    break;
                }
            }        
            if(right <= left) {
                break;
            }        
            swap(array, left, right);      
        }
        
        swap(array, low, right);
        
        if(medianPosition == right) {
            return array[medianPosition];
        }
        else if(medianPosition < right) {
            return median(array, low, right-1, medianPosition);
        }
        else {
            return median(array, right+1, high, medianPosition);        
        }

    }
    
    public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int length = in.nextInt();
           int[] array = new int[length];
           for(int i=0;i<length;i++){
              array[i]=in.nextInt(); 
           }
            Median sol = new Median();
            System.out.println(sol.median(array));
    }
}