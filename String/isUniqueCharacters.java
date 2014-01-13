package String;

public class isUniqueCharacters {

	public boolean isUniqueChars(String str) {
		boolean [] characters = new boolean [256];
		for (int i = 0; i < str.length(); i++) {
			int character = str.charAt(i);
			if (!characters[character]) {
				characters[character] = true;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public boolean isUniqueChars2(String str) {
		int character = 0;
		for (int i = 0; i < str.length(); i++) {
			int numberOfChar = str.charAt(i) - 'a';
			if ((character & (1 << numberOfChar)) > 0) {
				return false;
			}
			else {
				character |= (1 << numberOfChar);
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		isUniqueCharacters unique = new isUniqueCharacters();
		System.out.println(unique.isUniqueChars2("efghijklmnopqrstuvwABCDXYZ"));
	}

}
