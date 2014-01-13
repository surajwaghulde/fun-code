package String;

import java.util.Arrays;

	public class IsomorphicString {
		private String s1;
		private String s2;
		
		public IsomorphicString(String s1, String s2) {
			this.s1 = s1;
			this.s2 = s2;
		}
		
		public boolean isIsomorphic() {
			int[] s1_arr = new int[256];
			int[] s2_arr = new int[256];
			if( s1.length() != s2.length() ) {
				return false;
			}
			for( int i = 0; i < s1.length(); i++ ) {
				s1_arr[s1.charAt(i)] = s1_arr[s1.charAt(i)] + 1;
				s2_arr[s2.charAt(i)] = s2_arr[s2.charAt(i)] + 1;
			}
			Arrays.sort(s1_arr);
			Arrays.sort(s2_arr);
			for( int i = 0; i < s1_arr.length; i++ ) {
				if( s1_arr[i] != s2_arr[i] ) {
					return false;
				}
			}
			return true;
		}
		
		public static void main(String[] args) {
			IsomorphicString is = new IsomorphicString("Hello", "Yekko");
			System.out.println(is.isIsomorphic());
		}
	}
