package LinkedList;

public class Stack<T> {

	
	private Node<T> top;
	
	public void push(T value) {
		Node<T> temp = new Node<T>(value, null);
		temp.next = top;
		top = temp;
	}
	
	public T top() {
		if (top == null)
			throw new UnderFlowException("Stack Empty");
		else 
			return top.value;
	}
	
	public T pop() {
		if (top == null)
			throw new UnderFlowException("Stack Empty");
		else 
			{
				T temp = top.value;
				top = top.next;
				return temp;
			}
	}
	
	public boolean isEmpty() {
		return (top==null);
	}	
	
	public void printStack() {
		Node<T> temp = top;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.printStack();
		stack.pop();
		stack.printStack();
		System.out.println(stack.isEmpty());
		System.out.println(stack.top());
		stack.printStack();
		stack.push(4);
		stack.printStack();
		stack.pop();
		stack.pop();
		stack.printStack();
		stack.pop();
		stack.pop();
		stack.printStack();
		stack.pop();
	}	
}	