package String;

public class Int2String {

	/**
	 * @param args
	 */
	
	public char [] int2String(int input) {
		char [] output = new char [10];
		char digit = ' ';
		int number = 0;
		
		if (input < 0) {
			output[number++]  = '-';
			input *= -1;
		}
		
		while(input > 1) {
			digit = (char)((char) input % 10 + '0');
			input /= 10;
			output[number++] = digit;
		}
		
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
		return output;
	}
	
	public static void main(String[] args) {
		Int2String itoa = new Int2String();
		char [] input = itoa.int2String(-5676);
		StringReverse strRev = new StringReverse();
		System.out.println(strRev.reverse(input));
	}

}

