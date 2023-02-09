/**
 * Usage example of a class that implements an interface
 * 
 */

public class BicycleDemo {


     public static void main(String[] args) {

          // Create two different Bicycle objects
          Bicycle bike1 = new MountainBike(20, 10, 5, "Dual");
          Bicycle bike2 = new MountainBike(20, 10, 5, "Dual");
          
          // Invoke methods on those objects
          bike1.setCadence(50);
          bike1.speedUp(10);
          bike1.turnLeft(15);
          bike1.setGear(2);
          bike1.printStates();

          bike2.setCadence(50);
          bike2.speedUp(10);
          bike2.setGear(2);
          bike2.setCadence(40);
          bike2.turnRight(34);
          bike2.speedUp(10);
          bike2.setGear(3);
          bike2.printStates();
          
          //Create Driveable object
          Driveable bike3 = new RoadBike(40, 20, 8, 23);
          bike3.turnLeft(5);
          ((Bicycle)bike3).setGear(5);
          ((Bicycle)bike3).printStates();
     }
}


