package sorting;

import java.util.ArrayList;

public class MergeSort {
	
	private static void merge(ArrayList<Integer> input, ArrayList<Integer> tempArray, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int totalElements = rightEnd - leftPos + 1;
		int tempPos = leftPos; 
		
		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if (input.get(leftPos).compareTo(input.get(rightPos)) <= 0) 
				tempArray.set(tempPos++, input.get(leftPos++));
			else 
				tempArray.set(tempPos++, input.get(rightPos++));
		}
		
		while (leftPos <= leftEnd) {
			tempArray.set(tempPos++, input.get(leftPos++));
		}
			
		while (rightPos <= rightEnd) {
			tempArray.set(tempPos++, input.get(rightPos++));
		}		
		
		for (int i = 0; i < totalElements; i++, rightEnd--) {
			input.set(rightEnd, tempArray.get(rightEnd));
		}
	}	
	
	private static void mergeSort(ArrayList<Integer> input, ArrayList<Integer> tempArray, int left, int right) {		
        if( left < right )
        {
            int center = ( left + right ) / 2;
            mergeSort( input, tempArray, left, center );
            mergeSort( input, tempArray, center + 1, right );
            merge( input, tempArray, left, center + 1, right );
        }
	}
	
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> input) {
		ArrayList<Integer> tempArray = new ArrayList<Integer>();
		for (int i = 0; i < input.size(); i++) {
			tempArray.add(0);
		}
		mergeSort(input, tempArray, 0, input.size()-1);		
		return input;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(4);
		input.add(2);
		input.add(7);
		for (int i = 0; i < 100000; i++) {
			input.add(i*2);
		}
		input.add(5);
		input.add(1);
		long startTime = System.currentTimeMillis();
		mergeSort(input);
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println("time " + time);
	}

}
