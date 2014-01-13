package ListIntersection;

import java.util.*;

public class ListIntersection {
	
	ArrayList<ArrayList<Integer>> listOfLists;
	ArrayList<Integer> intersectionList = new ArrayList<Integer>();
	ArrayList<Integer> listIndexes = new ArrayList<Integer>();
	
 	public ArrayList<Integer> intersection() {
		listOfLists = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> intList1 = new ArrayList<Integer>();
		intList1.add(2);
		intList1.add(3);
		intList1.add(4);
		listOfLists.add(intList1);
		listIndexes.add(0);
		ArrayList<Integer> intList2 = new ArrayList<Integer>();
		intList2.add(2);
		intList2.add(4);
		intList2.add(5);
		listOfLists.add(intList2);
		listIndexes.add(0);
		ArrayList<Integer> intList3 = new ArrayList<Integer>();
		intList3.add(2);
		intList3.add(6);
		intList3.add(8);
		listOfLists.add(intList3);
		listIndexes.add(0);
		for(int i = 0 ; i < intList1.size(); i++) {
			int commonInt = intList1.get(i);
			for (int j = 1; j < listOfLists.size(); j++) {
				int counter = listIndexes.get(j);
				while (commonInt > listOfLists.get(j).get(counter) && listOfLists.get(j).size() >= counter) {
//					System.out.println(listOfLists.get(j).get(counter));
					counter++;
					listIndexes.set(j, counter);
				}
					
				if(commonInt == listOfLists.get(j).get(counter)) {
						if (j == (listOfLists.size()-1))
							intersectionList.add(commonInt);
				}
				else if (commonInt > listOfLists.get(j).get(counter))
					break;
			}
		}
		return intersectionList;
 	}
	
	public static void main(String [] args) {
		ListIntersection intersection = new ListIntersection();
		ArrayList<Integer> list = intersection.intersection();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
