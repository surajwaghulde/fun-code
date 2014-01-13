package LinkedList;

import java.io.IOException;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
	
	private Node<T> head;
	
	public void add(T data) {
		if(head == null) {
			head = new Node<T>(data);
		}
		else {
			Node<T> temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node<T>(data);	
		}
	}
	
	public void print() {
		if(head == null) 
			return;
		else {
			Node<T> temp = head;
			while (temp != null) {
				System.out.print(temp.data);
				temp = temp.next;
			}
		}
	}
	
	public Iterator<T> iterator() {
		return new LinkedListIterator();		
	}
		
	public void reverse() {
		Node<T> first;
		Node<T> second;
		Node<T> third;
		if(head != null) {
			first = head;			
		}
		else {
			return;
		}
		if(first.next != null) {
			second = head.next;			
		}
		else {
			return;
		}
		first.next = null;
		if (second.next == null) {
			second.next = first;
		}
		while (second.next != null) {
			third = second.next;
			second.next = first;
			first = second;
			second = third;
		}
		second.next = first;
		head = second;			
	}
	
	private class LinkedListIterator implements Iterator<T> {

		private Node<T> nextNode;
		
		public LinkedListIterator() {
			nextNode = head;
		}
		
		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public T next() {
			if(!hasNext()) 
				return null;
			T data = nextNode.data;
			nextNode = nextNode.next;
			return data;
		}

		@Override
		public void remove() {
			
		}
		
	}

	private static class Node<T> {	
		T data;
		Node<T> next;
		
		public Node(T data) {
			this.data = data;
			this.next = null;			
		}
	}
	
	public static void main(String args[]) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(4);
		list.add(7);
		list.add(9);
		list.add(5);
		list.print();
		list.reverse();
		list.print();
		Iterator iterator = list.iterator();
		System.out.println();
		while (iterator.hasNext()) {
			System.out.print(iterator.next());
		}
	}
	
}
