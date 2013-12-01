package Multithreading;

/*
 * Class to simulate cars to cross the bridge.
 */
public class CarsController {

    private Car[] cars; 
    private Bridge bridge;

    /*
     * Simulate cars creating those many number of thread instances.
     */
    public void simulateCars(int numberOfCars) {
        cars = new Car[numberOfCars];
        bridge = new Bridge();
        int carDirection;
        
        for (int i = 0; i < numberOfCars; i++) {        	
        	carDirection = (((int) (Math.random()*10))/5);
            cars[i] = new Car(i, bridge, carDirection, cars);
            cars[i].start();
        }
    }	
	
	public static void main(String[] args) {
		CarsController carsController = new CarsController();
		carsController.simulateCars(1000);		
	}

}
