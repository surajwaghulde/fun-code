package Multithreading;

public enum SingletonEnum {
	INSTANCE;
	
	private SingletonEnum() {};
	
	public void printThis() {
		System.out.println("This is a test");
	}
}
