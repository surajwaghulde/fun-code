package String;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Combinations
{
    // A set to hold the generated combination results.
    private Set combinations = new HashSet();
 
    /**
    * The constructor.
    *
    * Simply makes a call to the generate method
    * to generate all the possible combinations of the
    * String "wxyz"
    */
    public Combinations(String sInputString)
    {
        generate(sInputString);
        System.out.println("*** Generated " + combinations.size() + " combinations ***");
        System.out.println(combinations);
    }
 
    /**
    * The recursive method does the work of generating all the possible
    * combinations for a given String.
    */
    public void generate(String word)
    {
        // Add this word to our combination results set
        // System.out.println(word);
        combinations.add(word);
        System.out.println(word);
        // If the word has only one character we break the
        // recursion
        if (word.length() == 1)
        {
//            combinations.add(word);
//            System.out.println("addinf to combinations " + word);
            return;
        }
 
        // Go through every position of the word
        for (int i = 0; i < word.length(); i++)
        {
            // Remove the character at the current position
            // all call this method with that String (Recursion!)
            generate(word.substring(0,i) + word.substring(i+1));
            
        }
    }
 
 
    /**
     * Request and read input from the command line (System.in)
     * 
     * @param inputMessage
     *      The message to be displayed as a request to the user
     *      
     * @return
     *      The input from the command line
     *      
     * @throws IOException
     *      Any problems while reading the input
     */
    public static String readCommandLineInput(String inputMessage)
    {
        System.out.println(inputMessage);
        Scanner scanner = new Scanner(System.in);
 
        String inputLine = scanner.nextLine();
        return inputLine;
    }
 
    /**
    * Entry point to this program.
    * Instantiates the StringCombinations program.
    *
    */
    public static void main(String args[])
    {
		// Request and read user input
		String sInstruction = "Enter a String: \n";
		String sInputString = readCommandLineInput(sInstruction);
        new Combinations(sInputString);
    }
 
}// End of StringCombinations