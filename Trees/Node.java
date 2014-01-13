package Trees;

class Node<T> {

	public T value;
	public Node<T> right;
	public Node<T> left;
	public int size = 0;
	
	public Node (T value, Node<T> right, Node<T> left) {
		this.right = right;
		this.left = left;
		this.value = value;
	}
	
	public Node(T value) {
		this.value = value;
	}
	 
	
}
