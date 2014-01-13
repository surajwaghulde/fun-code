package String;

import java.util.Scanner;

public class LCS_CommonChild {

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String str1 = in.next();
	        String str2 = in.next();
	                
	        int M = str1.length();
	        int N = str2.length();
	
	        int c[][] = new int[M+1][N+1];
	        
	        for (int i = 1; i <= M; i++)
	            c[i][0] = 0;
	        for (int j = 0; j <= N; j++)
	            c[0][j] = 0;
	
	        for (int i = 1; i <= M; i++) {
	            for (int j = 1; j <= N; j++) {
	                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
	                    c[i][j] = c[i - 1][j - 1] + 1;
	                } else if (c[i - 1][j] >= c[i][j - 1]) {
	                    c[i][j] = c[i - 1][j];
	                } else {
	                    c[i][j] = c[i][j - 1];
	                }
	            }
	        }
	
	        System.out.println(c[M][N]);
	        
	        
	    }
	
	

}
