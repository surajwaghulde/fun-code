package fibonacci;

public class FibonacciIterative {

	public void fibonacci(int n) {
		long first = 1;
		long second = 1;
		long count = 2;
		long third = 2;
		
		if (n <= 0) {
			System.out.println("Invalid input");
		}
		if (n > 1) {
			System.out.print(1 + ",");
		}
		if (n == 2) {
			System.out.println(1);
		}
		else {
			System.out.print(1 + ",");
		}
		while (count < n-1) {
			count++;
			third = first + second;
			first = second;
			second = third;
			System.out.print(third + ",");
		}
		System.out.println(first + second);
	}
	
	public static void main(String[] args) {
		FibonacciIterative fibo = new FibonacciIterative();
		fibo.fibonacci(5);
	}

}
