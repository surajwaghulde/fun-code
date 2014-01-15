package funMedium;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
	private final HashMap<Integer, String> cache = new HashMap<Integer, String>();
	private final LinkedList<Integer> insertionOrder = new LinkedList<Integer>();
	private final int MAX_CACHE_SIZE = 100;

	public String get(Integer id) {
		String value = (String) cache.get(id);
		if (value != null) {
			// make the instance "newer" if it's not already the "newest"
			if (!id.equals(insertionOrder.getLast())) {
				insertionOrder.remove(id);
				insertionOrder.add(id);
			}
		}
		return value;
	}

	public void set(Integer id, String value) {
		cache.put(id, value);
		insertionOrder.add(id);
		if (insertionOrder.size() > MAX_CACHE_SIZE) {
			Integer victimId = (Integer) insertionOrder.removeFirst();
			cache.remove(victimId);
		}
	}
}
