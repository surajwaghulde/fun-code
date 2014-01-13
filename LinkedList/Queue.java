package LinkedList;

public class Queue<T> {
	
	Node<T> front;
	Node<T> rear;
	
	public Queue() {
		
	}
	
	public Queue(T value) {
		front = rear = new Node<T>(value,null);
	}
		
	public void enqueue(T value) {
		Node<T> temp = new Node<T>(value,null);
		rear.next = temp;
		rear = temp;
	}
	
	public T dequeue() {
		if (front != null) {
			T temp = front.value;
			front = front.next;
			return temp;
		}
		else throw new UnderFlowException("Queue Empty");
	}
	
	public boolean isEmpty() {
		return (front == null);
	}
	
	public void printQueue() {
		Node<T> temp = front;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>(0);		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.printQueue();
		queue.dequeue();
		queue.dequeue();
		queue.printQueue();
		queue.dequeue();
		queue.dequeue();
		queue.printQueue();
//		queue.dequeue();
	}

}
