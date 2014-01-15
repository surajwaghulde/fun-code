package fibonacci;

public class FibonacciRecursive {
	
	long fibo;

	public long fibonacci(int n) {
		if (n < 0) {
			System.out.println("Invalid input");
		}
		if (n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}					
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	
	public static void main(String[] args) {
		FibonacciRecursive fibo = new FibonacciRecursive();		
		System.out.println(fibo.fibonacci(6));			
	}

	
}
