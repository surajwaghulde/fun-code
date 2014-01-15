package maps;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class WordCount {

	protected HashMap<String, ValueObject> dictionary = new HashMap<String, ValueObject>();
	protected HashMap<String, Integer> countMap = new HashMap<String, Integer>();
	
	
	public void populateCountMap() {
		Set<String> keySet = new HashSet<String>();
		keySet = dictionary.keySet();
		Iterator<String> keySetIterator = keySet.iterator();
			while (keySetIterator.hasNext()) {
				String key = keySetIterator.next();
				ValueObject valueObject = dictionary.get(key);
				ArrayList<String> values = valueObject.getValues();
				Iterator<String> valuesIterator = values.iterator();
				while (valuesIterator.hasNext()) {
					String value = valuesIterator.next();
						if (countMap.containsKey(value)) {
							int count = countMap.get(value);
							countMap.put(value, ++count);
						}
						else {
							countMap.put(value, 1);							
						}
				}
			}	
	}
	
	public int getCount(String word) {
		return countMap.get(word);
	}
	
	public static void main(String[] args) {
		ValueObject valueObject = new ValueObject();
		ArrayList<String> values = new ArrayList<String>();
		values.add("w2");
		values.add("w3");
		values.add("w4");
		valueObject.setValues(values);

		ValueObject valueObject1 = new ValueObject();
		ArrayList<String> values1 = new ArrayList<String>();
		values1.add("w3");
		values1.add("w5");
		valueObject1.setValues(values1);

		WordCount wordCount = new WordCount();
		wordCount.dictionary.put("w1", valueObject);
		wordCount.dictionary.put("w2", valueObject1);
		wordCount.populateCountMap();
		
		System.out.println(wordCount.getCount("w2"));
		System.out.println(wordCount.getCount("w3"));
		System.out.println(wordCount.getCount("w4"));
		System.out.println(wordCount.getCount("w5"));
		
	}

}
