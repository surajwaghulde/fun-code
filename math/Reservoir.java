package math;

public class Reservoir {

	public void reservoir(int [] data, int k) {
		
		int [] reservoir = new int [k];
		int i = 0;
		int j = 0;
		
		for(; i < k; i++) {
			reservoir[i] = data[i];
		}
		
		for(; i< data.length; i++) {
			j = (int) (Math.random() * (i));
			if(j < k) {
				reservoir [j] = data[i];
			}
		}		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
