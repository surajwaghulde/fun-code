package sorting;

import java.util.List;

public class QuickSort<T extends Comparable>{


	public void quickSort(T array []) {
		quickSortRecurse(array, 0, array.length-1);
	}
	
	public void swap(T array [], int left, int right) {
		System.out.println("swapping " + array[left] + " with " + array[right]);
		T temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public void quickSortRecurse(T array [], int left, int right) {
		int mid = (left + right)/2;
		System.out.println("mid is " + array[mid] + " left is " + array[left] + " right is " + array[right]);
		if (array[left].compareTo(array[mid]) > 0) {
			swap(array, left, mid);
		}
		if (array[left].compareTo(array[right]) > 0) {
			swap(array, left, right);
		}
		if (array[mid].compareTo(array[right]) > 0) {
			swap(array, mid, right);
		}
		
		if (right - left < 4) {
			System.out.println("returning ");
			return;
		}

		
		T pivot = array[mid];
		
		System.out.println("pivot is " + pivot);
		swap(array, mid, right-1);
		
		int i = left;
		int j = right-1;
		
		for (; i < j; ) {
			while(array[++i].compareTo(pivot)<0);
			while(array[--j].compareTo(pivot)>0);
			if (i >= j)
				break;
			System.out.println("swapping " + array[i] + " with " + array[j]);
			swap(array,i,j);
		}
		
		swap(array, right-1, i);
		
		for (int k = left; k < right; k++) {
			System.out.print(array[k] + " ");
		}
		System.out.println();
		
		quickSortRecurse(array,left,i-1);
		quickSortRecurse(array,i+1,right);
	}
	
	public void quickSort(T array[] , int  left, int right) {
		T pivot = array[left];
		int i = left;
		int j = right-1; 
		
		for (; i < j;) {
			while(array[i].compareTo(pivot)<0) i++;
			while(array[j].compareTo(pivot)>0) j--;
			
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		QuickSort<Integer> quickSort = new QuickSort<Integer>();
		Integer [] array = new Integer [] {4,2,7,8,5,1,9,3,0,6};
		quickSort.quickSort(array);
		for (int k = 0; k < array.length; k++) {
			System.out.print(array[k] + " ");
		}
	}

}
