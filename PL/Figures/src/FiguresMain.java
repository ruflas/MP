/**
 * Main program Programa to test figures in text mode
 * using the interface GeometricFigure
 * @author Programming Methodology Professors
 * @version 1.0
 *
 */

import java.util.Random; // random numbers generator

public class FiguresMain {

	public static void showFigures(GeometricFigure[] figures) {
		for(int i = 0; i<figures.length; i++) {
			System.out.print(figures[i]);
		}
	}
	
	public static GeometricFigure[] sortAscending(GeometricFigure[] v) {
		for(int i = 0; i < v.length-1; i++) {
			for(int j = i+1; j < v.length; j++) {
				GeometricFigure aux = v[i];
	    		  if(v[j].area()<v[i].area()) {
	    			  v[i] = v[j];
	    			  v[j] = aux;
	    		  }
			}
		}
		return v;
	}
	
	public static boolean BiggerArea(GeometricFigure[] v) {
		double cArea = 0, tArea = 0;
		for(int i = 0; i < v.length; i++) {
			if(v[i] instanceof Circle) {
				cArea += v[i].area();
			}
			else if(v[i] instanceof Triangle) {
				tArea += v[i].area();
			}
		}
		return cArea > tArea;
	}
	
	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args) {

		// Constants to control the number of figure to create
		final int TOTALCIRCLES = 5;
		final int TOTALCIRCLESWITHCENTRE = 5;
		final int TOTALTRIANGLES = 5;

		// create a random numbers generator
		Random gen = new Random();
		
		// array of figures
		GeometricFigure[] figures = new GeometricFigure[TOTALCIRCLES + TOTALCIRCLESWITHCENTRE + TOTALTRIANGLES];
		
		
		// Create the circles
		for(Integer x = 0; x < TOTALCIRCLES; x++){
			figures[x] = new Circle(gen.nextInt(50));
		}
		
		// Creathe the circles with centre
		for(Integer x = 0; x < TOTALCIRCLESWITHCENTRE; x++){
			figures[TOTALCIRCLES + x] = new CircleWithCentre(gen.nextInt(300),gen.nextInt(300),gen.nextInt(50));
		}
		
		// Create the triangles
		for(Integer x = 0; x < TOTALTRIANGLES; x++){
			figures[TOTALCIRCLES + TOTALCIRCLESWITHCENTRE + x] = new Triangle(gen.nextInt(300),gen.nextInt(300),
					gen.nextInt(300),gen.nextInt(300),
					gen.nextInt(300),gen.nextInt(300));
		}
		
		
		// Define static methods to:
		// Show all geometric figures in text mode
		showFigures(figures);
		// Compute the total area of the figures in the vector
		System.out.printf("\nTotal area of the figures in the vector: %.2f\n", GeometricFigure.totalArea(figures));
		// Sort the figures according to the area from smallest to greatest 
		showFigures(sortAscending(figures));
		System.out.print("\n");
		System.out.print("New Vector: \n");
		GeometricFigure[] v = new GeometricFigure[6];
		for(Integer x = 0; x <= 3; x++){
			v[x] = new Circle(gen.nextInt(50));
		}
		for(Integer x = 3; x < 6; x++){
			v[x] = new Triangle(gen.nextInt(300),gen.nextInt(300),
					gen.nextInt(300),gen.nextInt(300),
					gen.nextInt(300),gen.nextInt(300));
		}
		System.out.print("\n");
		showFigures(v);
		System.out.printf("\nCircles have more area that triangles?: %b", BiggerArea(v));
		System.out.print("\n");
		showFigures(sortAscending(v));
	}


	 
}
