package String;

public class IndexOf {

	char [] inputString = {'a','b','s','a','e','w','r','z','x','d','a','f','r','c'};
	
	public int indexOf(String str) {
		int length = inputString.length;
		char [] searchChars = str.toCharArray();
		int searchLength = searchChars.length;
		for (int i = 0; i < length; i++) {
			if (inputString[i] == searchChars[0]) {
				int startIndex = i;
				int j=1;
				while ((j < searchLength) && (inputString[++i] == searchChars[j])) {
					j++;
				}
				System.out.println(j);
				if (j == searchLength) {	
					return startIndex;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		IndexOf indexOf = new IndexOf();
		System.out.println(indexOf.indexOf("xad"));

	}

}
