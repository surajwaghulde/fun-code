package Trees;

public class CreateBST<T> {

	public Node<T> createBST(T[] data) {
		return createBST(data, 0 , data.length-1);
	}
	
	public Node<T> createBST(T[] data, int start, int end) {
		if (end >= start) {
			int mid = (start + end) /2;
			Node<T> node = new Node<T>(data[mid]);
			node.left = createBST(data, start, mid-1);
			node.right = createBST(data, mid+1, end);
			return node;
		}
		return null;
	}
	
	public void inorder(Node<T> root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);			
		}
	}
	
	private static class Node<T> {
		Node<T> left, right = null;
		T data;
		
		public Node(T value) {
			this.data = value;
		}
	}
	
	public static void main(String[] args) {
		CreateBST<Integer> bst = new CreateBST<Integer>();
		Integer [] data = new Integer [] {1,2,3,4,5,6,7,8,9};
		Node<Integer> root = bst.createBST(data);
		bst.inorder(root);
	}

}
