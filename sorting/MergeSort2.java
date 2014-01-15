package sorting;

public class MergeSort2<T extends Comparable> {

	public void mergeSort(T [] input) {
		T [] aux = input.clone();
		mergeSort(input, aux, 0, input.length-1);
	}
	
	public void mergeSort(T [] input, T [] aux, int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(input, aux, start, mid);
			mergeSort(input, aux, mid+1, end);
			merge(input, aux, start, mid, end);
		}		
	}
	
	public void merge(T [] input, T [] aux, int leftStart, int mid, int rightEnd) {
		int leftEnd = mid;
		int rightStart = mid + 1;
		int numberOfElements = rightEnd - leftStart + 1;
		int position = leftStart;
		while(leftStart <= leftEnd && rightStart <= rightEnd) {
			if(input[leftStart].compareTo(input[rightStart]) < 0) {
				aux[position++] = input[leftStart++];
			} else {
				aux[position++] = input[rightStart++];
			}
		}
		
		while(leftStart<= leftEnd) {
			aux[position++] = input[leftStart++];
		}
		
		while(rightStart <= rightEnd) {
			aux[position++] = input[rightStart++];
		}
		
		for(int i = 0 ; i < numberOfElements; i++) {
			input[rightEnd - i] = aux[rightEnd - i];
		}
		
	}
	
	public static void main(String[] args) {
		MergeSort2<Integer> mergeSort = new MergeSort2<Integer>();
		Integer [] input = new Integer[100];
		for(int i = 0; i < 100; i++) {
			input[i] = (int) (Math.random() * 100);
		}
		for(Integer i : input) {
			System.out.print(i + " ");
		}
		mergeSort.mergeSort(input);
		System.out.println();
		for(Integer i : input) {
			System.out.print(i + " ");
		}

	}

}
