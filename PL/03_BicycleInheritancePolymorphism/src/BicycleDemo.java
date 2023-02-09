/**
 * Simple example using polymorphism and downcasting
 * 
 */

class BicycleDemo {
	public static void main(String[] args){
	    Bicycle bike01, bike02, bike03, bike04;
	    
	    bike01 = new Bicycle(20, 10, 1);
		bike02 = new MountainBike(20, 10, 5, "Dual");
		bike03 = new RoadBike(40, 20, 8, 23);
        bike04 = new MountainBike(20,15,6,"Individual");
		// JVM calls the appropriate method for the referenced object
		// and not the method for the variable type
		//bike01.printStates();
		//bike02.printStates();
		//bike03.printStates();
		
		Bicycle [] vectBikes = {bike01, bike02, bike03, bike04};
		
		for (int i = 0; i < vectBikes.length; i++){
			System.out.format("%nBycicle [%d]:%n",i);
			vectBikes[i].printStates();
		}
		
		// To use the specific methods for each class
		// it is necessary to do downcast
		
		//MountainBike m2 = (MountainBike) bike02;
		//m2.setSuspension("Mono");
		((MountainBike)bike02).setSuspension("Mono");
		
		for (int i = 0; i < vectBikes.length; i++){
			System.out.format("%nBycicle [%d]:%n",i);
			vectBikes[i].printStates();
		}
		
		for(int i = 0; i<vectBikes.length; i++) {
			System.out.format("%nBycicle [%d]:%n",i);
			if(vectBikes[i] instanceof MountainBike) System.out.printf("Suspension: %s",((MountainBike) vectBikes[i]).getSuspension());
			else if(vectBikes[i] instanceof RoadBike) System.out.println("The RoadBike has " + ((RoadBike) vectBikes[i]).getTireWidth()+ " MM tires.");
			else vectBikes[i].printStates();
		}
	}
}



