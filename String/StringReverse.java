package String;

public class StringReverse {	
	
	public char [] reverse(String str) {
		char [] input = str.toCharArray();
		int length = input.length;
		char tmp;
		for(int i = 0; i < length / 2; i++) {
			tmp = input[i];
			input[i] = input[length-i-1];
			input[length-i-1] = tmp;
		}
		return input; 
	}	
	
	public char [] reverse(char [] input) {
		char temp = ' ';
		for (int i = 0; i < (input.length)/2; i++) {
			temp = input[input.length-i-1];
			input[input.length-i-1] = input[i];
			input[i] = temp;
		}
		return input;		
	}
	
	public static char[] reverseString(char[] chars, int start, int end)
	{
		if (end < start)
		{
			return chars;
		}

		if (chars.length == 0 || chars.length == 1)
		{
			return chars;
		}
		char temp = chars[start];
		chars[start] = chars[end];
		chars[end] = temp;
		
		return reverseString(chars, ++start, --end);
	}
	
	public static char[] reverseString(String str) {
		return reverseString(str.toCharArray(), 0, str.length()-1);
	}
	
	public static void main(String [] args) {
		StringReverse strRev = new StringReverse();
		System.out.println(strRev.reverse("Hello"));
		System.out.println(strRev.reverse("Here"));
		System.out.println(reverseString("Here is the test"));
	}

}
