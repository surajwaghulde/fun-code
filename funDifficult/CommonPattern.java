package funDifficult;

	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.Set;

	public class CommonPattern {

	 
	  HashMap<String, Integer> pageMap = new HashMap<String, Integer>();
	  HashMap<String, Integer> sequenceCountMap = new HashMap<String, Integer>();
	  HashMap<String, String> userVisitSequenceMap = new HashMap<String, String>();

	  public void countSequenceFrequency() {
	    Set<String> visitMapKeySet = userVisitSequenceMap.keySet();
	    for (String key : visitMapKeySet) {
	      String visitSequence = userVisitSequenceMap.get(key);
	      String[] sequence = visitSequence.split(",");
	      if(sequence.length > 2) {        
	        String sequence1 = sequence[0];
	        String sequence2 = sequence[1];
	        for (int i = 2; i < sequence.length; i++) {
	          String sequence3 = sequence[i];
	          StringBuilder newSequence = new StringBuilder();
	          newSequence.append(sequence1);
	          newSequence.append(",");
	          newSequence.append(sequence2);
	          newSequence.append(",");
	          newSequence.append(sequence3);
	          String sequenceString = newSequence.toString();
	          // System.out.println(sequenceString);
	          
	          sequence1 = sequence2;
	          sequence2 = sequence3;
	          
	          if (sequenceCountMap.containsKey(sequenceString)) {
	            sequenceCountMap.put(sequenceString,
	                sequenceCountMap.get(sequenceString) + 1);
	          }
	 else {
	            sequenceCountMap.put(sequenceString, 1);
	          }
	        }
	      }
	      else {
	        break;
	      }
	    }
	  }

	  public String mostCommonSequence() {
	    Set<String> countMapKeys = sequenceCountMap.keySet();
	    int maxCount = 0;
	    String maxCountSequence = null;
	    for (String key : countMapKeys) {
	      if (sequenceCountMap.get(key) > maxCount) {
	        maxCount = sequenceCountMap.get(key);
	        maxCountSequence = key;
	        System.out.println(key);
	        // System.out.println(convertKeySequence(key));
	        System.out.println(maxCount);
	      }
	    }
	    return maxCountSequence;
	  }

	  public String convertKeySequence(String key) {
	    System.out.println(key);
	    String[] sequence = key.split(",");
	    StringBuilder keySequenceWithNames = new StringBuilder();
	    for (int i = 0; i < sequence.length; i++) {
	      System.out.println("sequeunce i " + sequence[i]);
	      keySequenceWithNames.append(pageMap.get(sequence[i]));
	      keySequenceWithNames.append("->");
	    }
	    return keySequenceWithNames.toString();
	  }

	  public void generateMaps(String inputFile) {

	    BufferedReader br = null;

	    try {

	      String sCurrentLine;
	      int count = 0;
	      br = new BufferedReader(new FileReader(
	          inputFile));

	      while ((sCurrentLine = br.readLine()) != null) {
	        int sequenceId;
	        StringBuilder userVisitSequence = new StringBuilder();
	        String[] splits = sCurrentLine.split("\t");
	        String userId = splits[0];
	        if (!pageMap.containsKey(splits[1])) {
	          sequenceId = count;
	          pageMap.put(splits[1], count++);
	        }
	 else {
	          sequenceId = pageMap.get(splits[1]);
	        }
	        if (userVisitSequenceMap.containsKey(userId)) {
	          String visitSequence = userVisitSequenceMap.get(userId);
	          userVisitSequence.append(visitSequence);
	          userVisitSequence.append("," + sequenceId);
	          userVisitSequenceMap.put(userId, userVisitSequence.toString());
	        }
	 else {
	          userVisitSequence.append(sequenceId);
	          userVisitSequenceMap.put(userId, userVisitSequence.toString());
	        }
	      }
	      // System.out.println("userVisitSequenceMap " +
	      // userVisitSequenceMap.size());
	      // Set<String> visitKeys = userVisitSequenceMap.keySet();
	      // for (String visitKey : visitKeys) {
	      // System.out.println(userVisitSequenceMap.get(visitKey));
	      // }
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        if (br != null)
	          br.close();
	      } catch (IOException ex) {
	        ex.printStackTrace();
	      }
	    
	  }
	  }
	  
	  public static void main(String[] args) {
	    CommonPattern commonPattern = new CommonPattern();
	    commonPattern
	        .generateMaps("/Users/swaghulde/Downloads/sample-query-log-data.txt");
	    commonPattern.countSequenceFrequency();
	    System.out.println(commonPattern.mostCommonSequence());
	  }

	}
