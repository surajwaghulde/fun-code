package funDifficult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;


public class MiniChallengeA {

	static TreeMap<Integer,Integer> mapOfPrime;
	static {
		 mapOfPrime = new TreeMap<Integer,Integer>();
		for(int i=0; i< 200000; i++) {
			if(isPrime(i)) {
				mapOfPrime.put(i, i);
			}
		}
	}
	
	public String shortestSubstring(String s) {
		ArrayList<String> shortestSubstringList = new ArrayList<String>();
		HashMap<String, Integer> foundSubStrings = new HashMap<String, Integer>();
		String subString;
		for(int i = 0; i <= s.length(); i++) {
			for (int j = 0; j <= s.length()-i; j++) {
				subString = s.substring(j,j+i);
				if (foundSubStrings.containsKey(subString)) {
					foundSubStrings.put(subString, foundSubStrings.get(subString)+1);
				} else {
					foundSubStrings.put(subString, 1);					
				}
			}			
			Set<String> keySet = foundSubStrings.keySet();
			Iterator<String> keySetIterator = keySet.iterator();
			while(keySetIterator.hasNext()) {
				String key = keySetIterator.next();
				if (foundSubStrings.get(key) == 1) {
					return key;
				}
			}
		}
		return "";
	}
	
	
	public int mostCommonSum(int k) {
		int sumOfDigits = sumOfDigits(k);
		int counter = 0;
		for (int i = 0; i <= k; i++) {
			if (sumOfDigits(i) == sumOfDigits) {
				counter++;
			}
		}
		return counter;
	}
	
	public int sumOfDigits(int number) {
		int digit = 0;
		int sum = 0;
		while (number > 0) {
			digit = number % 10;
			number /= 10;
			sum += digit;
		}
		return sum;
	}
	
	public int primes(int k) {
		int found = Integer.MAX_VALUE;
		Set keySet = mapOfPrime.keySet();
		Iterator<Integer> keySetIterator = keySet.iterator();
		while(keySetIterator.hasNext()) {
			int next = keySetIterator.next();
			if (next > k) {
				if (found < Integer.MAX_VALUE) {
					return found;
				} else {
					return -1;					
				}
			} else {
				if (mapOfPrime.containsKey(k - next)) {
					if (next < (k - next) && next < found) {
						found = next;
					} else if ((k-next) < found) {
						found = k - next;
					}
				}
			}
		}
		return found;
	}

	public static boolean isPrime (int n)
	{
	   if (n<=1) return false;
	   if (n==2) return true;
	   if (n%2==0) return false;
	   int m=(int)Math.sqrt(n);

	   for (int i=3; i<=m; i+=2)
	      if (n%i==0)
	         return false;

	   return true;
	}
	
	
	public static void main(String [] args) {
		MiniChallengeA a = new MiniChallengeA();
		System.out.println(a.mostCommonSum(50));
		System.out.println(a.primes(377));
		System.out.println(a.shortestSubstring("kinnikinnik"));
	}
	
	
}
