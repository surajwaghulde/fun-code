package String;
public class LongestCommonPrefix {
	
	public static String longestCommonPrefix(String phrase1, String phrase2) {
		
		StringBuilder strBuilder = new StringBuilder();
		int length = 0;
	
		if(phrase1 == null || phrase2 == null) {
			return null;
		}
		
		if(phrase1.length() < phrase2.length()) {
			length = phrase1.length();
		} 
		else {
			length = phrase2.length();
		}
		
		for (int i =0; i < length; i++) {
			int index = i;
			while (i < length && ((phrase1.charAt(i) != ' ') || phrase2.charAt(i) != ' ')){
				if(! (phrase1.charAt(i) == phrase2.charAt(i))) {
					return strBuilder.toString();
				}
				i++;
			}
			
			if(i < length && !(phrase1.charAt(i) == phrase2.charAt(i))) {
				return strBuilder.toString();
			}
			
			if  (!(index == 0)) strBuilder.append(' ');
			
			strBuilder.append(phrase1.substring(index,i));
		}
		return strBuilder.toString();
	}

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix("hi", "hi"));
	}

}
