package search;

public class BinarySearch<T extends Comparable<T>> {
	
	int start, end, mid;
	
	public int binarySearch(T[] array, T data) {
		return binarySearch(array, data, 0, array.length-1);
	}
	
	public int binarySearch(T[] array, T data, int start, int end) {
		while(start <= end) {
			mid = (start + end) /2;
			if(data.compareTo(array[mid]) == 0) {
				return mid;
			}
			if (data.compareTo(array[mid]) > 0) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String [] args) {
		BinarySearch<Integer> search = new BinarySearch<Integer>();
		Integer [] array = new Integer [10];
		for(int i = 0; i < 10; i++) {
			array[i] = i;
		}
		System.out.println(search.binarySearch(array, 10));
	}


}
