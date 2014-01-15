package maps;

import java.util.LinkedList;

public class HashMAP<K, V> {

	private final int MAX_SIZE = 10;
	LinkedList<Cell<K, V>> [] mapList;
	
	public HashMAP() {
		mapList = (LinkedList<Cell<K, V>> []) new LinkedList [MAX_SIZE];
	}
	
	public int hashCode(K key) {
		return key.toString().length()%MAX_SIZE;
	}
	
	private class Cell<K, V> {
		K key;
		V value;
		
		public Cell(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public void put(K key, V value) {
		int index = hashCode(key);
		if(mapList[index] == null) {
			mapList[index] = new LinkedList<Cell<K, V>>();
		}
		
		LinkedList<Cell<K, V>> list = mapList[index];
	}
	
	public V get(K key) {
		int index = hashCode(key);
		LinkedList<Cell<K, V>> list = mapList[index];
		if (list == null) {
			return null;
		}
		for(Cell<K, V> cell : list) {
			if(cell.key.equals(key)) {
				return cell.value;
			}
		}
		return null; //just to complete
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
