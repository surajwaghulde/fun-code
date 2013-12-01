package Multithreading;

/*
 * Simulating car as a thread.
 */
public class Car extends Thread {

    int licensePlate; 	// Car license plate.
    int carDirection; 	// Direction in which car is moving with respect to bridge.
    Bridge bridge;


    public Car(int licensePlate, Bridge bridge, int carDirection, Car [] cars) {
        this.licensePlate = licensePlate;
        this.bridge = bridge;        
        this.carDirection = carDirection;
    }

    /*
     * Run method calls the bridge enter and exit methods passing its own car instance.
     */
   public void run() {
        try {
        	System.out.println("car " + licensePlate + " has arrived at bridge in direction " + carDirection); 
        	bridge.numberOfCarsInDirection[carDirection].incrementAndGet();                            	 
            while(!bridge.enter(this)) {	// enter the bridge, if method return false that means car was not able to enter so continuous retry in while loop.
            	Thread.sleep(10);	
            }
            bridge.exit(this);	// exit the bridge.
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
