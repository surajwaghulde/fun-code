package matrix;

import java.util.ArrayList;

public class FillZeros {

	public void fillZeros(int[][] matrix) {
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		ArrayList<Integer> rowIds = new ArrayList<Integer>(numRows);
		ArrayList<Integer> colIds = new ArrayList<Integer>(numCols);	

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if(matrix[i][j] == 0) {
					rowIds.add(i);
					colIds.add(j);
				}
			}
		}
		
		for(int i : rowIds) {
			for (int j = 0; j < numCols; j++) {
				matrix[i][j] = 0;
			}
		}
		
		for(int i = 0; i < numCols; i++) {
			for(int j : colIds) {
				matrix[i][j] = 0;
			}
		}		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
