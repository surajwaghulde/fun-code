package series;

import java.util.ArrayList;

public class CountNumberSeries {


public void printSeries(int input, int numberOfLines) {
    int [] inputArray = new int [1000];
    int [] outputArray = new int [1000];
    
    int inputLength = 1;
    int outputLength = 0;
    int element = -1;
    int prevElement = -1;
    int count = 0;
    int j = 0; //output Array index
    
    inputArray[0] = input;
   
   for (int n =0; n < numberOfLines; n++) {
    
    for (int i = 0; i < inputLength; i++) {
        element = inputArray[i];  
        if (prevElement == element || prevElement ==-1) {
            count++;
        }
        else {
            outputArray[j++] = count;
            outputArray[j++] = prevElement;
            outputLength += 2;
            count = 1;
            prevElement = element;
        } 
        if (i == inputLength - 1) {
            outputArray[j++] = count;
            outputArray[j++] = element;
            outputLength += 2;
            count = 0;
            
            for (int k = 0; k < outputLength; k++) {
                System.out.print(outputArray[k]);
            }
            System.out.println();
            inputArray = outputArray.clone();
        }  
        prevElement = element;     
    }
    
    prevElement = -1;
    inputLength = outputLength;
    j = 0;
    outputLength = 0;
    
   }
    
}

	public void printSeries2(int input, int numberOfLines) {
		ArrayList<Integer> inputList = new ArrayList<Integer>();
		ArrayList<Integer> outputList;
		
		inputList.add(input);
		
		for(int i = 0; i < numberOfLines; i++) {
			
			int element = -1;
			int prevElement = -1;
			int count = 0;
			outputList = new ArrayList<Integer>();
			
			for(int j = 0; j < inputList.size(); j++) {
				element = inputList.get(j);
				if (prevElement == -1 || element == prevElement) {
					count++;
					prevElement = element;
				}
				else {
					outputList.add(count);
					outputList.add(prevElement);
					count = 1;
					prevElement = element;
				}
			}
			outputList.add(count);
			outputList.add(element);
			for (int k : outputList) {
				System.out.print(k);
			}
			System.out.println();
			inputList = outputList;
		}
		
	}

	public static void main(String[] args) {
		CountNumberSeries series = new CountNumberSeries();
		series.printSeries(1, 9);

	}

}
