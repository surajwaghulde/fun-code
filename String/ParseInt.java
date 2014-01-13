package String;

public class ParseInt {

	public static int parseInt(String stringToParse)
			throws IntegerFormatException {

		if (stringToParse == null) {
			throw new IntegerFormatException();
		}

		int result = 0;
		boolean negative = false;
		int i, length = stringToParse.length();
		int digit;

		if (length > 0) {
			char firstChar = stringToParse.charAt(0);
			if (firstChar < '0') { 							// check if number starts with a sign
				if (firstChar == '-') {
					negative = true;
				} else if (firstChar != '+')
					throw new IntegerFormatException();
				if (length == 1) 							// single character without digit is not possibly an integer
					throw new IntegerFormatException();
			} else {
				digit = stringToParse.charAt(0) - '0';
				result += digit;
			}
			for (i = 1; i < length; i++) {
				result *= 10;
				digit = stringToParse.charAt(i) - '0';
				result += digit;
			}
		} else {
			throw new NumberFormatException();
		}
		return negative ? -result : result;
	}

	public static void main(String[] args) {
		System.out.println(parseInt("-134"));
	}

}
