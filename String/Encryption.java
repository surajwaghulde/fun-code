package String;

import java.util.Scanner;

public class Encryption {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char [] chars = str.toCharArray();
        int length = str.length();
        int width;
        if(Math.sqrt(length) > Math.floor(Math.sqrt(length))) {
        	width = ((int)Math.floor(Math.sqrt(length))) + 1;
        }
        else {
        	width = (int)Math.floor(Math.sqrt(length));
        }
        
        int height = length/width;
        if (length % width > 0) {
        	height++;
        }
        
        char[][] grid = new char[height][width];
         
        for(int row = 0; row < height; row++) {
            for(int i = 0; i < width; i++) {
            	int cell = row*width+i;
            	if(cell < chars.length) {
                	grid[row][i] = chars[(row * width) + i];            		
            	}
            	else {
            		break;
            	}
            }        	
        }
        
        char [] out = new char [height*width];
        
//        for(int  i = 0; i < grid.length; i++) {
//        	for (int j = 0; j < grid[i].length; j++) {
//        		System.out.print(grid[i][j] + " ");
//        	}
//        	System.out.println(i);
//        }
        
        for(int col = 0; col < width; col++) {
        	for(int row = 0; row < height; row++) {
        		int cell = col * height + row;
//        		System.out.println(cell + " cell value " + grid [row][col]);
        		if (cell < out.length) {        			
            		out[cell] = grid[row][col];       			
        		}
        		else {
        			out[cell] = "".charAt(0);
        		}
        	}
        }
        
//        for(int k = 0; k < out.length; k++) {
//        	System.out.print(out[k] + " ");
//        }
        
        for(int k = 0; k < out.length; ) {
            for(int i = 0; i < height; i++) {
            	if(out[k] != '\u0000') {
                	System.out.print(out[k]);            		
            	}
            	if(++k >= out.length) {
            		break;
            	}
            }        
            if(k < out.length) {
                System.out.print(" ");            	
            }
        }
    }
	
}
