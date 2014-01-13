package ListIntersection;

public class ArrayIntersection {
	
	int [] [] arrayOfArray = new int [10] [10];
	int [] arrayIndexes = new int [10];
	int [] intersectionArray = new int [10];
	
	public int [] intersection() {
		int [] array1 = {1,2,4};
		int [] array2 = {2,4,5};
		int [] array3 = {4,6,8};
		
		arrayOfArray [0] = array1;
		arrayOfArray [1] = array2;
		arrayOfArray [2] = array3;
		
		arrayIndexes[0] = arrayIndexes[1] = arrayIndexes[2] = 0;
		
		for(int i = 0; i < array1.length; i++) {
			int counter = 0;
			int intersectionArrayCounter = 0;
			int commonInt = array1[i];
			for (int j = 1; j < arrayOfArray.length; j++) {
				while (commonInt > arrayOfArray[j][counter] && counter <= arrayOfArray[j].length)
					counter++;
				if (commonInt == arrayOfArray[j][counter] && j == arrayOfArray.length-1)
					intersectionArray[intersectionArrayCounter++] = commonInt;
				else 
					if (commonInt > arrayOfArray[j][counter])
						break;
			}
		}
		
		return intersectionArray;
	}
	
	public static void merge(int[] a, int[] b, int n, int m) 
	{ 
		int k = m + n - 1; 
		// Index of last location of array b 
		int i=n-1;//Indexoflastelementinarrayb 
		int j=m-1;//Indexoflastelementinarraya
				
	// Start comparing from the last element and merge a and b 
		while(i>=0&&j>=0){
			if (a[i] > b[j]) { 
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			} 
		}
		while(j>=0){
			a[k--] = b[j--];
		} 
	}
	
	public static void main(String [] args) {
		ArrayIntersection intersect = new ArrayIntersection();
		int [] intersection = intersect.intersection();
		for(int i = 0; i < intersection.length; i++) 
			System.out.println(intersection[i]);
	}
	
	
}
