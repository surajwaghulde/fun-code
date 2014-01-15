package recursion;

import java.util.ArrayList;

public class Permutation {
	
	public ArrayList<String> permute(String input) {
		ArrayList<String> allPermutations = new ArrayList<String>();
		ArrayList<String> permutationsList;
		if(input.length() == 1) {
			permutationsList = new ArrayList<String>();
			permutationsList.add(input);
			return permutationsList;
		}
		char firstChar = input.charAt(0);
		String restString = input.substring(1);
		permutationsList = permute(restString);
		allPermutations.addAll(insertAtAllPositions(firstChar, permutationsList));	
		return allPermutations;
	}
	
	public ArrayList<String> insertAtAllPositions(char firstChar, ArrayList<String> permutationsList) {
		ArrayList<String> allPermutations = new ArrayList<String>();
		StringBuilder strBuilder;
		for(String permutation : permutationsList) {
			for(int i = 0; i <= permutation.length(); i++) {
				strBuilder = new StringBuilder();
				strBuilder.append(permutation.substring(0,i));
				strBuilder.append(firstChar);
				strBuilder.append(permutation.substring(i));
				allPermutations.add(strBuilder.toString());
			}
		}
		return allPermutations;
	}
 	
	public static void main(String[] args) {
		Permutation permutation = new Permutation();
		ArrayList<String> list = permutation.permute("abc");
		System.out.println(list);
	}

}
