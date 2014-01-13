package String;

public class ReverseW {

	public void reverseWords(String input) {
		char [] outputChars = new char [input.length()]; 
		int count = input.length() -1;
		int index = 0;
		while(count > 0) {
			int totalAlphabetsInWord = 0;
			while(input.charAt(count) != ' ' && count > 0) {
				count--;
				totalAlphabetsInWord++;
			}
			if(count == 0) {
				outputChars[index++] = input.charAt(count);
			}
			for(int i = 0; i < totalAlphabetsInWord; i++) {
				outputChars[index++] =  input.charAt(count+i+1);
			}
			if (count != 0 ) {
				outputChars[index++] = ' ';				
			}
			count--;
		}
		for(char c : outputChars) {
			System.out.print(c);
		}
	}
	
	public static void main(String[] args) {
		ReverseW reverse = new ReverseW();
		reverse.reverseWords("This is a test. asf asdfasdin assgkd ");
	}

}
