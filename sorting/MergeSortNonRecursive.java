package sorting;

import java.util.ArrayList;

public class MergeSortNonRecursive {

	/**
	 * @param args
	 */
	
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
	
	public static void mergeIter(ArrayList<Integer> a, ArrayList<Integer> b, int segmentSize, int n) {
		int i = 0;
		while (i <= n - 2 * segmentSize) {
			merge(a,b,i,i+segmentSize-1,i+2*segmentSize-1);
			i += 2*segmentSize;			
		}
		if (i+segmentSize < n) 
			merge(a,b,i,i+segmentSize-1,n-1);
		else 
			for (int j = i; j <= n-1; j++) {
				b.set(j, a.get(j));
			}
	}
	
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> input) {
		ArrayList<Integer> tempArray = new ArrayList<Integer>();
		int segmentSize = 1;
		int n = input.size();
		for (int i = 0; i < n; i++) {
			tempArray.add(0);
		}
		while (segmentSize < n) {
			mergeIter(input, tempArray, segmentSize, n);
			segmentSize += segmentSize;
			mergeIter(tempArray, input, segmentSize, n);
			segmentSize +=segmentSize;
		}		
		return input;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
