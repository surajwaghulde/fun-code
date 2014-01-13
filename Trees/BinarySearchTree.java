package Trees;

import java.util.ArrayList;

import LinkedList.Queue;
import LinkedList.Stack;
import java.util.Iterator;
import java.util.LinkedList;
import LinkedList.Queue;


public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

	private Node<T> root;
	private Integer lastChecked = Integer.MIN_VALUE;
	public void add(T value) {
		root = add(root, value);
	}
	
	public Node<T> add(Node<T> root, T value) {
		if (root == null) {
			return new Node<T>(value);
		}
		else {
			if (value.compareTo(root.value) > 0) {
				root.right = add(root.right, value);
			}
			else {
				root.left = add(root.left, value);
			}
		}
		return root;
	}
	
	public void insert(T value) {
		if(root == null) {
			root = new Node<T>(value);
		}
		else {
			Node<T> temp = root;
			Node<T> parent = root;
			while(temp != null) {
				if(value.compareTo(temp.value) < 0) {
					parent = temp;
					temp = temp.left;
				}
				else {
					parent = temp;
					temp = temp.right;
				}
			}
			if(value.compareTo(parent.value) < 0) {
				parent.left = new Node<T>(value);
			} 
			else {
				parent.right = new Node<T>(value);
			}
		}
	}
		
	public void inorder() {
		inorder(root);
	}
	
	public void inorder(Node<T> root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.value + " ");
			inorder(root.right);			
		}
	}
	
	public int height() {
		return height(root);
	}
	
	public int height(Node<T> node) {
		if (node != null) {
			return 1 + Math.max(height(node.left), height(node.right));
		}
		return -1;
	}
	
	public int size() {
		return size(root);
	}
	
	public int size(Node<T> node) {
		if (node != null) {
			return 1 + size(node.left) + size(node.right);
		}
		return 0;
	}
	
	public int width() {
		int maxWidth = 0;
		int width = 0;
		for (int i = 1; i < height()-1; i++) {
			width = width(root,i);
			if(maxWidth < width) {
				maxWidth = width;
			}
		}
		return maxWidth;
	}
	
	public int width(Node<T> root, int depth) {
		if(root == null) {
			return 0;
		}
		else if(depth == 0) {
			return 1;
		}
		else {
			return width(root.left, depth-1) + width(root.right, depth-1);
		}
	}
	
	public int countLeaves() {
		return countLeaves(root);
	}
	
	public int countLeaves(Node<T> root) {
		if(root.left == null && root.right == null) {
			return 1;
		}
		else {
			if(root.left != null && root.right == null) {
				return countLeaves(root.left);
			}
			else if(root.right != null && root.left == null) {
				return countLeaves(root.right);
			}
			else {
				return countLeaves(root.left) + countLeaves(root.right);
			}
		}
	}
	
	public int diameter() {
		 return diameter(root);
	}
	
	
	public int diameter(Node<T> root) {
		if(root == null) {
			return 0;
		}
		else {
				int length1 = height(root.left) + height(root.right) + 3;
				
				int length2 = Math.max(diameter(root.left), diameter(root.right));
				
				return Math.max(length1, length2);
		}
	}
	
	public boolean isBalanced() {
		return isBalanced(root);
	}
	
	public int checkHeight(Node<T> root) {
		if(root == null) {
			return 0;
		}
		
		int leftHeight = checkHeight(root.left);
		int rightHeight = checkHeight(root.right);
		
		if((leftHeight == -1) || (rightHeight == -1)) {
			return -1;
		}
		else {
			if(Math.abs(leftHeight - rightHeight) > 1) {
				return -1;
			} 
			else {
				return 1 + Math.max(leftHeight, rightHeight);
			}			
		}
	}
	
	public boolean isBalanced(Node<T> root) {
		if(checkHeight(root) == -1) {
			return false;			
		}
		else {
			return true;
		}
	}
	
	public void printLevels(Node<T> root) {
	    Queue<Node<T>> queue = new Queue<Node<T>>();
	    
	    if(root!=null) {    
	        queue.enqueue(root);
	        queue.enqueue(null);
	    }
	    
	    while(!queue.isEmpty()) {
	        Node<T> temp = queue.dequeue();
	        if(temp!=null) {
	            System.out.print(temp.value + " ");
	            if(temp.left!= null) {
	                queue.enqueue(temp.left);
	            }
	            if(temp.right!=null) {
	                queue.enqueue(temp.right);
	            }
	        }
	        else {
	            System.out.println();
	            queue.enqueue(null);
	        }
	    }
	}



	
	public void BFSLists() {
		ArrayList<LinkedList<Node<T>>> BFSlists = new ArrayList<LinkedList<Node<T>>>(height(root)+1);
		LinkedList<Node<T>> list = new LinkedList<Node<T>>();
		list.add(root);
		BFSlists.add(list);
		for (int i =1; i<=height(root); i++) {
			LinkedList<Node<T>> newList = new LinkedList<Node<T>>();
			for(Node<T> data : list) {
				if (data.left != null) {
					newList.add(data.left);					
				}
				if (data.right != null) {
					newList.add(data.right);
				}
			}
			BFSlists.add(newList);
			list = newList;
		}
		for (LinkedList<Node<T>> l : BFSlists) {
			for (Node<T> data : l) {
				System.out.print(data.value + " ");				
			}
			System.out.println();
		}
	}
	
	private static class Node<T> {
		Node<T> left, right;
		T value;
		
		public Node(T data) {
			this.value = data;
			this.left = this.right = null;
		}
	}	
	
	public boolean checkBST(Node<Integer> root) {
		if(root == null) return true;
		
		if(!checkBST(root.left)) {
			return false;
		}
		
		if (lastChecked.compareTo(root.value) > 0) {
			return false;
		}
		
		if(!checkBST(root.right)) {
			return false;
		}
		
		return true;
	}
	
	public boolean checkBST2(Node<Integer> root) {
		return checkBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean checkBST2(Node<Integer> root, Integer min, Integer max) {
		if (root == null) {return true;}
		
		if(root.value.compareTo(min) < 0 || root.value.compareTo(max) > 0) {
			return false;
		}
		
		return (checkBST2(root.left, min, root.value) && checkBST2(root.right, root.value, max));
		
	}
	
	public T commonAncestor(Node<T> node1, Node<T> node2) {
		return commonAncestor(root, node1, node2).value;
	}

	
	public Node<T> commonAncestor(Node<T> root, Node<T> node1, Node<T> node2) {
		if(root == null) {
			return null;
		}
		if(root.value.compareTo(node1.value) == 0 || root.value.compareTo(node2.value) == 0) {
			return root;			
		}
		boolean node1_left = covers(root.left, node1);
		boolean node2_left = covers(root.left, node2);
		
		if(node1_left != node2_left) {
			return root;
		}
		
		Node<T> node = node1_left ? root.left : root.right;
		return commonAncestor(node, node1, node2);				
	}
	
	public boolean covers(Node<T> root, Node<T> node) {
		if(root == null) {
			return false;
		}
		if(root.value.compareTo(node.value) == 0) {
			return true;
		}
		return covers(root.left, node) || covers(root.right, node);
	}
	
	
	public void nonRecursivePreorder() {
		Stack<Node<T>> stack = new Stack<Node<T>>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node<T> temp = stack.pop();
			System.out.print(temp.value + " ");
			if(temp.right != null) {
				stack.push(temp.right);
			}
			if(temp.left != null) {
				stack.push(temp.left);
			}
		}
	}
	
	public void nonRecursiveInorder() {
		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node<T> temp = root;
		stack.push(temp);
		while(temp.left != null) {
			stack.push(temp.left);
			temp = temp.left;
		}
		
		while(!stack.isEmpty()) {
			Node<T> tmp = stack.pop();
			System.out.print(tmp.value + " ");
			if(tmp.right != null) {
				Node<T> rightNode = tmp.right;
				stack.push(rightNode);
				while(rightNode.left != null) {
					stack.push(rightNode.left);
					rightNode = rightNode.left;
				}
			}
		}
	}
	
	
	@Override
	public Iterator<T> iterator() {		
		return new PreOrderIterator<T>();
	}	
	
	
	private class TreeInOrderIterator<T> implements Iterator<T> {

		Stack<Node<T>> stack = new Stack<Node<T>>();
		
		public TreeInOrderIterator() {
			Node<T> tmp = (Node<T>)root;
			while (tmp != null) {
				stack.push(tmp);
				tmp = tmp.left;
			}
		}
		
		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public T next() {
			Node<T> current = stack.pop(); 
			Node<T> tmp = current.right;			
			while(tmp != null) {
				stack.push(tmp);	
				tmp = tmp.left;
			}
			return current.value;
		}

		@Override
		public void remove() {
		}		
	}

	private class PreOrderIterator<T> implements Iterator<T> {

		Stack<Node<T>> stack = new Stack<Node<T>>();
		
		public PreOrderIterator() {
			stack.push((Node<T>)root);
		}
		
		@Override
		public boolean hasNext() {			
			return !stack.isEmpty();
		}

		@Override
		public T next() {
			Node<T> current = stack.pop();
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
			return current.value;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		int [] input = new int [] {3,4,1,0,5,2,9,7};
		for (int i : input) {
			bst.insert(i);
		}
		bst.inorder();
		System.out.println();
		System.out.println("height " + bst.height());
		System.out.println("size " + bst.size());
		System.out.println("width " + bst.width());
		for(int i = 0; i < 5; i++) {
			System.out.println("width " + bst.width(bst.root,i));
		}
		System.out.println("leaves " + bst.countLeaves());
		System.out.println("diameter " + bst.diameter());
		System.out.println("balanced " + bst.isBalanced());
		bst.BFSLists();
		System.out.println(bst.checkBST(bst.root));
		System.out.println(bst.checkBST2(bst.root));
		System.out.println(bst.commonAncestor(new Node<Integer>(1), new Node<Integer>(5)));
		
		System.out.println("here");
		for (Integer data : bst) {
			System.out.println(data);
		}
		
		System.out.println();
		bst.nonRecursivePreorder();
		
		System.out.println();
		bst.nonRecursiveInorder();
		
		System.out.println("print levels");
		bst.printLevels(bst.root);
	}

}

	