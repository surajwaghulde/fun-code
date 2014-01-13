package Bot;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BotSavePrinces {
/* Head ends here */
static void displayPathtoPrincess(int n, String [] grid){
        int pos=0;
    
   // System.out.println("n= "+n+" S length = "+grid[1]);
String newArray[] = new String[n*n];
//System.out.println(grid.length);
/*for(int j=0;j<grid.length;j++)
{
	System.out.println(grid[j]);
}*/
//System.out.println("---------------");
for(int i=0,k=0;i<grid.length;i++)
{
	for(int j=0;j<grid[i].length();j++)
	{
		newArray[k] = ""+grid[i].charAt(j);
	//	System.out.println(grid[i]);
		k++;
	}
}
//  for(int i =0;i<newArray.length;i++)
 //           System.out.println(i+" "+newArray[i]);
    if(newArray[0].equals("p"))
        pos = 0;
    else if(newArray[n-1].equals("p"))
        pos = n-1;
    else if(newArray[n*(n-1)].equals("p"))
        pos = n*(n-1);
    else if(newArray[n*(n-1) + (n-1)].equals("p"))
            pos = (n*(n-1) + (n-1));
    
       int m = ((n*n)+1)/2 -1 ;
       
       
        m = (n+1)/2;
       if(pos==0)
       {
           for(int i=0;i<n-m;i++)
           {
             System.out.println("LEFT");
           }
           for(int i=0;i<n-m;i++)
           {
             System.out.println("UP");
           }
       }
       if(pos==n-1)
       {   
           for(int i=0;i<n-m;i++)
           {
             System.out.println("RIGHT");
           }
           
           for(int i=0;i<n-m;i++)
            {
              System.out.println("UP");
            }
       }
       if(pos==n*(n-1))
       {   
           for(int i=0;i<n-m;i++)
           {
             System.out.println("LEFT");
           }
           
           for(int i=0;i<n-m;i++)
            {
              System.out.println("DOWN");
            }
       }
       if(pos==(n*(n-1) + (n-1)))
       {   
           for(int i=0;i<n-m;i++)
           {
             System.out.println("RIGHT");
           }
           
           for(int i=0;i<n-m;i++)
            {
              System.out.println("DOWN");
            }
       }
  }
/* Tail starts here */
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

    displayPathtoPrincess(m,grid);
    }
}