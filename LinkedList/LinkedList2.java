package LinkedList;

// To demonstrate few methods on linked list like 1. reverse, 2. quick sort, 3. detect loop 

public class LinkedList2 {
	
	private Node<Integer> header;
	
	public LinkedList2() {
		
	}
	
	
	public void addNode(Node<Integer> node) {
		if (header ==  null)
			header = node;
		else {
			Node<Integer> temp = header;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
	public boolean searchNode(int node) {
		Node<Integer> temp = header;
		while (temp != null) {
			if (temp.value == node)
				return true;
			temp = temp.next;
		}
		return false;
	}
	
	public void insertAfter(Node<Integer> afterNode, Node<Integer> node) {
		Node<Integer> temp = header;
		while(temp.next != afterNode) {
			temp = temp.next;
		}
		temp = temp.next;
		node.next = temp.next;
		temp.next = node;
	}
	
	public boolean detectLoop() {
		Node<Integer> slowPointer = header;
		Node<Integer> fastPointer = header;
		while(fastPointer.next != null && fastPointer.next.next != null && slowPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			if (fastPointer == slowPointer || fastPointer.next == slowPointer) {
				return true;
			}
		}
		return false;
	}
	
	public void printList() {
		Node<Integer> temp = header;
		while (temp!= null) {
			System.out.print(temp.value);
			temp = temp.next;
		}
	}
	
	public void reverseList() {
		Node<Integer> first = header;
		Node<Integer> second = header.next;
		Node<Integer> third = second.next;
		first.next = null;
		while (third != null) {
			second.next = first;
			first = second;
			second = third;
			third = third.next;
		}
		second.next = first;
		header = second;
	}
	
	public Integer get(int index) {
		Node<Integer> temp = header;
		for (int i = 0; i < index; i++) {
			if(temp.next != null) 
				temp = temp.next;
			else 
				System.out.println("Index not valid");
		}
		return temp.value;
	}
	
	public void nth2Last(int n) {
		Node<Integer> temp = header;
		while(temp.next != null && n-- > 0) 
			temp = temp.next;
		while(temp!=null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	
	public void deleteNode(Node<Integer> node) {
		Node<Integer> temp = header;
		if(node.value == temp.value) {
			header = header.next;
		}
		while(temp.next != null) {
			if(node.value == temp.next.value) 
				temp.next = temp.next.next;				
			else 
				temp = temp.next;
		}
	}
	
	public void quickSort() {
		header = quickSort(header);		
	}
	
	public Node<Integer> quickSort(Node<Integer> head) {
		Node<Integer> leftHead = null;
		Node<Integer> rightHead = null;
		Node<Integer> pivot = head;
		Node<Integer> temp = head.next;
		Node<Integer> first = null;
		Node<Integer> traverse = null;
		
		while(temp != null) {
			System.out.println("temp value " + temp.value);
			if (temp.value <= pivot.value) {
				if(leftHead == null) {
					Node<Integer> node = new Node<Integer>(temp.value);
					leftHead = node;
					leftHead.next = null;
				} else {
					Node<Integer> node = new Node<Integer>(temp.value);
					node.next = leftHead;
					leftHead = temp;
				}
			} else {
				System.out.println(" in right");
				if(rightHead == null) {
					Node<Integer> node = new Node<Integer>(temp.value);
					rightHead = node;
					rightHead.next = null;
				} else {
					Node<Integer> node = new Node<Integer>(temp.value);
					node.next = rightHead;
					rightHead = temp;
				}
			}
			temp  = temp.next;
		}
		
		System.out.println("left partition ");
		temp = leftHead;
		while(temp!=null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}

		System.out.println("right partition ");
		temp = rightHead;
		while(temp!=null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}

		
		if (leftHead != null) {
			if (leftHead.next != null) {
				leftHead = quickSort(leftHead);				
			}
		}
		
		if (rightHead != null) { 
			if(rightHead.next != null) {
				rightHead = quickSort(rightHead);
			}
		}
		
		if (leftHead == null) {
			first = pivot;
		} else {
			first = leftHead;
			temp = leftHead;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = pivot;
		}
		pivot.next = rightHead;

		return first;		
	}
	
	public void quickSortHT() {
		Node<Integer> temp = header;
		while(temp.next != null) {
			temp = temp.next;
		}
		header = quickSortHeadTail(header, null);
	}
	
	public Node<Integer> quickSortHeadTail(Node<Integer> head, Node<Integer> tail) {
		Node<Integer> pivot = head;
		Node<Integer> first = null;
		
		Node<Integer> leftHead = null;
		Node<Integer> leftTail = null;
		Node<Integer> rightHead = null;
		Node<Integer> rightTail = null;

		if (head == tail) {
			return head;
		}
		
		Node<Integer> temp = pivot.next;
		System.out.println("pivot is " + pivot.value);
		
		while (temp != null) {
			System.out.println("temp value " + temp.value);
			if(temp.value <= pivot.value) {
				if(leftHead == null) {
					leftHead = temp;
					leftTail = temp;
				} else {
					 leftTail.next = temp;
					 leftTail = leftTail.next;
				}
			}
			else {
				if(rightHead == null) {
					rightHead = temp;
					rightTail = temp;
				} else {
					 rightTail.next = temp;
					 rightTail = rightTail.next;
				}				
			}
			temp = temp.next;
		}
		
		if (leftTail != null)
		leftTail.next = null;
		if (rightTail != null)
		rightTail.next = null;
		
		System.out.println("Printing the left partition");		
		temp = leftHead;
		while(temp!=null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		
		System.out.println("Printing the right partition");
		temp = rightHead;
		while(temp!=null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}

		if(leftHead != leftTail) {
			leftHead = quickSortHeadTail(leftHead, leftTail);
		}
		if (rightHead!=rightTail) {
			rightHead = quickSortHeadTail(rightHead,rightTail);			
		}
		
		if (leftHead != null) {
			first = leftHead;
			temp = leftHead;
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next = pivot;
		} else {
			first = pivot;
			first.next = rightHead;
		}
		pivot.next = rightHead;
		
		System.out.println("Returning ");
		temp = first;
		while(temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		
		return first;
		
	}
	
	public static void main(String[] args) {
		LinkedList2 list = new LinkedList2();
		list.addNode(new Node<Integer>(4,null));
		list.addNode(new Node<Integer>(2,null));
		list.addNode(new Node<Integer>(8,null));
		list.addNode(new Node<Integer>(7,null));
		list.addNode(new Node<Integer>(5,null));
		list.addNode(new Node<Integer>(1,null));
		list.addNode(new Node<Integer>(9,null));
		list.addNode(new Node<Integer>(0,null));
		list.addNode(new Node<Integer>(3,null));
		list.addNode(new Node<Integer>(6,null));		
		list.printList();
//		list.insertAfter(list.header.next, new Node<Integer>(1,null));
//		list.printList();
//		list.reverseList();
//		list.printList();
//		list.deleteNode(new Node<Integer>(4,null));
//		list.printList();
//		System.out.println("getting 2 " + list.get(1));
		System.out.println(list.searchNode(3));
//		list.nth2Last(3);
		System.out.println(list.detectLoop());
//		list.header.next = list.header;
//		System.out.println(list.detectLoop());
		list.quickSortHT();
		System.out.println();
		list.printList();		
	}

}
