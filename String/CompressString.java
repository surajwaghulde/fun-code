package String;

public class CompressString {
	
	public String compressString(String input) {
		char [] inputChars = input.toCharArray();
		StringBuilder strBuilder = new StringBuilder();
		char last = inputChars[0];
		int count = 1;
		for (int i = 1; i < inputChars.length; i++) {
			if (inputChars[i] == last) {
				count++;
			}
			else {
				strBuilder.append(last);
				strBuilder.append(Integer.toString(count));
				if (i <= inputChars.length-1) {
					last = inputChars[i];
					count = 1;
				}
			}
		}
		strBuilder.append(last);
		strBuilder.append(Integer.toString(count));
		String output = strBuilder.toString();
		System.out.println("output " + output);
		if (output.length() < input.length()) {
			return output;
		}
		return input;
	}
	
	public static void main(String[] args) {
		CompressString compressString = new CompressString();
		compressString.compressString("abcdeeff ");
	}

}
