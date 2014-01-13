package String;

public class WC {

	public void wc(String input) {
		
		int length = input.length();
		char prevChar = '0';
		int wordCount = 0;
		int lineCount = 0;
		int i = 0;
		while(i < length-1) {
			char inputChar = input.charAt(i);
			if((inputChar == ' ' || inputChar == '\n') && !(prevChar == ' ' || prevChar == '\n')) {
				System.out.print("inputChar " + inputChar);
				System.out.println("prevChar " + prevChar);
				wordCount++;
			}
			if(inputChar == '\n') {
				lineCount++;
			}
			prevChar = inputChar;
			i++;
		}
		System.out.println();
		if(input.charAt(length-1) == ' ') {
			System.out.println(lineCount+1 + " " + wordCount + " " + length);
		} else if (input.charAt(length-1) == '\n'){
			System.out.println(lineCount + " " + wordCount + " " + length);			
		}
		System.out.println(lineCount+1 + " " + (wordCount+1) + " " + length);			
	}
	
	public static void main(String[] args) {
		WC wC = new WC();
		wC.wc("kjkj kaj,sdf j kjsjasdfj kjo \n\nkjj\nkjj");

	}

}
