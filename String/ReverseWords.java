package String;

public class ReverseWords {

	public void reverseWords(String input) {
		StringBuilder reverse = new StringBuilder();
		int i = input.length()-1;
		while (i > 0) {
			int counter = 0;
			while (input.charAt(i)!= ' ' && i != 0) {
				i--;
				counter++;
			}
			if (i == 0) {
				i--;
				counter++;
			}
			for(int j = 0; j < counter; j++) {
				reverse.append(input.charAt(i+j+1));
			}
			i--;
			reverse.append(' ');
		}
		System.out.println(reverse);
	}
	
	public static void main(String [] args) {
		ReverseWords reverseWords = new ReverseWords();
		reverseWords.reverseWords("building scalable web sites ");
	}
}
