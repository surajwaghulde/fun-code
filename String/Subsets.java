package String;

import java.util.*;

public class Subsets {

	public ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> set) {
		return getSubSets(set, 0);
	}

	public ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSubsets;
		if (index == set.size()) {
			allSubsets = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> emptySet = new ArrayList<Integer>();
			allSubsets.add(emptySet);
			return allSubsets;
		}
		else {
			allSubsets = getSubSets(set, index+1);
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			Integer item = set.get(index);
			for(ArrayList<Integer> subset : allSubsets) {
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
		}
		return allSubsets;
	}
	
	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 2; i++) {
			list.add(i);
		}
		ArrayList<ArrayList<Integer>> out = subsets.getSubSets(list);
		
		for(ArrayList<Integer> outList : out) {
			for (int i : outList) {
				System.out.println(i);
			}
			System.out.println("--");
		}
	}
	

}
