package funMedium;

import java.util.*;

public class MaximumSequence {

	public int maxSequence(ArrayList<Integer> list)  {
		int sum = 0;
		int maxsum = 0;
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			sum += itr.next();
			if (sum < 0)
				sum = 0;
			if (sum > maxsum)
				maxsum = sum;
		}
		return maxsum;
	}
	
	public static void main(String[] args) {
		MaximumSequence maxSum = new MaximumSequence();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(-3);
		list.add(5);
		list.add(-2);
		list.add(-1);
		list.add(2);
		list.add(6);
		list.add(-2);
		System.out.println(maxSum.maxSequence(list));
	}

}
