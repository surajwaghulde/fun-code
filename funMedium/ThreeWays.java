package funMedium;

public class ThreeWays {
	
	int [] waysCount;
	
	public int ways(int n) {
		if(n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		return ways(n-1) + ways(n-2) + ways(n-3);
	}
	
	public void createWaysCount(int size) {
		waysCount = new int [size+1];
	}
	
	public int waysDP(int n) {
		createWaysCount(n);
		return waysCountDP(n, waysCount);
	}
	
	public int waysCountDP(int n, int [] waysCount) {
		if (n < 0 ) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (waysCount[n] > 0) {
			return waysCount[n];
		}
		else {
			waysCount[n] = waysCountDP(n-1, waysCount) + waysCountDP(n-2, waysCount) + waysCountDP(n-3, waysCount);			
		}
		return waysCount[n];
	}
	
	public static void main(String[] args) {
		ThreeWays ways = new ThreeWays();
		System.out.println(ways.ways(7));
		System.out.println(ways.waysDP(7));
	}

}
