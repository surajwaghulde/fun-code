package sorting;

public class QuickSort2<T extends Comparable<T>> {

	public void quickSort(T [] input) {
		quickSort(input, 0 , input.length-1);
	}
	
	public void quickSort(T [] input, int low, int high) {
		if (low >= high) return;
			int partitioPosition = partition(input, low, high);
			quickSort(input, low, partitioPosition-1);
			quickSort(input, partitioPosition + 1, high);	
			System.out.println();
			for(T i : input) {
				System.out.print(i + " ");
			}
	}
	
	public int partition(T [] input, int low, int high) {
		int left = low;
		int right = high+1;		
		T pivot = input[low];
		while(left < right) {
			while((input[++left].compareTo(pivot) < 0)) {
				if (left == high) break;
			}
			while((input[--right].compareTo(pivot) > 0)){
				if (right == low) break;
			}
			if(left >= right) {
				break;
			}
			swap(input, left, right);			
		}
		System.out.println("pivot swapping");
		swap(input, low, right);
		return right;
	}
	
	public void swap(T [] input, int i, int j) {
		T temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		System.out.println("swapping " + input[i] + " " + input[j]);
	}
	
	
	public static void main(String[] args) {
		QuickSort2<Integer> quickSort = new QuickSort2<Integer>();
		Integer [] input = new Integer[10];
		for(int i = 0; i < 10; i++) {
			input[i] = (int) (Math.random() * 10);
		}
		for(Integer i : input) {
			System.out.print(i + " ");
		}
		quickSort.quickSort(input);
		System.out.println();
		for(Integer i : input) {
			System.out.print(i + " ");
		}
	}

}
