package Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * This Bridge class handles all the logic of concurrent access to the bridge for controlling traffic of cars entering and leaving the bridge
 */
public class Bridge {
	private AtomicInteger direction = new AtomicInteger(-1);	// direction -1 is default which does not indication any direction. 
																// For simplicity I am keeping simple integer direction 0 and 1.
	private static final int CARS_ALLOWED = 3;	// cars allowed to be on the bridge at any point of time.
	AtomicInteger [] numberOfCarsInDirection = new AtomicInteger [2];	// keep track of number of cars waiting to enter the bridge.
	private AtomicInteger carsFromOneDirection = new AtomicInteger(0);	// keep track of the number of cars entered the bridge from one direction.
	private AtomicInteger previousFlowOfTraffic = new AtomicInteger(0); // keep track of the previous direction of the traffic flow
	private AtomicInteger carsExitedInDirection = new AtomicInteger(0); // keep track of the number of cars exited the bridge in current direction of traffic.

	public Bridge() {
		numberOfCarsInDirection[0] = new AtomicInteger(0);	// initialize the number of cars waiting to enter the bridge to be 0.
		numberOfCarsInDirection[1] = new AtomicInteger(0);		
	}

	public Boolean enter(Car car) {
		int carDirection = car.carDirection;
		int licensePlate = car.licensePlate;

		synchronized (car.bridge) {
			if (this.direction.get() == -1) {	// if the direction of traffic flow is not set when the car wants to enter the bridge
				if ((previousFlowOfTraffic.get() == carDirection) && (numberOfCarsInDirection[(carDirection+1)%2].get() > 0)) {	// if previous traffic direction is the same then check
					car.bridge.notifyAll();
					return Boolean.FALSE;																						// if there are cars in opposite direction. If not proceed.
				}
				System.out.println("car " + licensePlate + " is on the bridge.." + " direction " + car.carDirection);
				this.direction.set(carDirection);	// set the direction of the traffic.
				previousFlowOfTraffic.set(carDirection);
				carsFromOneDirection.set(1);
			} else if (this.direction.get() != carDirection) {	// if the direction of traffic is opposite to the cars direction.
				System.out.println( licensePlate + " cant enter bridge, waiting to enter in direction " + carDirection);
				car.bridge.notifyAll();
				if(numberOfCarsInDirection[(carDirection+1)%2].get() == 0) {	// if there are no cars on the other side waiting to cross the bridge, better get on the bridge.
					System.out.println("all vehicles in other direction have passed.");
					System.out.println("car " + licensePlate + " is on the bridge.." + " direction " + car.carDirection);
					this.direction.set(carDirection);
					previousFlowOfTraffic.set(carDirection);
					carsFromOneDirection.set(1);
					carsExitedInDirection.set(0);
					car.bridge.notifyAll();
					return Boolean.TRUE;
				}
				return Boolean.FALSE;
			} else if (this.direction.get() == carDirection) {	// direction of traffic is in the same direction as car
				if (carsFromOneDirection.get() < CARS_ALLOWED) {	// check that less than 3 cars are on the bridge
					System.out.println("car " + licensePlate + " is on the bridge. direction " + carDirection);
					System.out.println("Total vehicles on the bridge "
							+ carsFromOneDirection.incrementAndGet()
							+ " in direction " + direction.get());
				} else {
					System.out.println(licensePlate + " cant enter bridge, already 3 vehicles are on the bridge in direction " + carDirection);
					car.bridge.notifyAll();
					return Boolean.FALSE;
				}
			}
		}
		return Boolean.TRUE;
	}

	public void exit(Car car) {	// exit is simple 
		int carDirection = car.carDirection;
		synchronized (car.bridge) {
			if (direction.get() == carDirection) {	// this condition should be met since no car should enter if opposite direction of traffic. 8-x otherwise accidents can happen. 
				System.out.println("Car " + car.licensePlate + " left the bridge.");
				numberOfCarsInDirection[carDirection].decrementAndGet();
				car.bridge.notifyAll();
				if(carsExitedInDirection.incrementAndGet() == CARS_ALLOWED) {	// when allowed number of cars passes the bridge from one direction reset the direction of traffic.
					System.out.println("3 vehicles passed from direction " + carDirection);
					direction.set(-1);
					carsFromOneDirection.set(0);
					carsExitedInDirection.set(0);
					car.bridge.notifyAll();
				}
			} else {
				System.out.println("car can not exit in this direction");
			}
		}
	}

}
