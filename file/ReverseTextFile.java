package file;

import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class ReverseTextFile {	
	
	public void reverseTextFile() {
		
		Stack<Character> stack = new Stack<Character>();
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream("text1.txt"));
			int c;
		       while ((c = isr.read()) != -1)
		           stack.push(Character.valueOf((char)c));
		    isr.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		while(!stack.empty()) {
			try {
				OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("text2.txt"));
				osw.write((Character)stack.pop());
				osw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
