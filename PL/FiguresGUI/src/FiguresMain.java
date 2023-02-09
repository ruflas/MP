
/**
 * Main program to visualise figures in a window
 * using the interface GraphicFigure
 * @author Programming Methodology Professors
 * @version 1.0
 *
 */

import java.util.Random; //  random numbers generator

public class FiguresMain {

	// window to show the figures
	private static MyWindow w = null;

	/**
	 * Main function
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Look at this
		GraphicFigure gf = new Triangle(1, 2, 3, 4, 5, 6);
		System.out.println(gf.getLabel());

		// And check that all this works well
		Circle c = new CircleWithCentre(2, 3, 4);
		System.out.println(((GraphicFigure) c).getLabel());

		// And that this does not work, why?
		Circle c1 = new Circle(4);
		System.out.println(((GraphicFigure) c1).getLabel());

		// Now we create a vector of objects with labels

		// Constants to control the number of figure to create
		final int TOTALCIRCLES = 5;
		final int TOTALCIRCLESWITHCENTRE = 5;
		final int TOTALTRIANGLES = 5;

		// create a random numbers generator
		Random gen = new Random();

		// array of figures
		GeometricFigure[] figures = new GeometricFigure[TOTALCIRCLES + TOTALCIRCLESWITHCENTRE + TOTALTRIANGLES];

		// Create and show the application's window
		// initializeWindow();

		// Create the circles
		for (Integer x = 0; x < TOTALCIRCLES; x++) {
			figures[x] = new Circle(gen.nextInt(50));
			// Set "C"+x as label

		}

		// Create the circles with centre
		for (Integer x = 0; x < TOTALCIRCLESWITHCENTRE; x++) {
			figures[TOTALCIRCLES + x] = new CircleWithCentre(gen.nextInt(300), gen.nextInt(300), gen.nextInt(50));
			// Set "C"+x as label

		}

		// Create the triangles
		for (Integer x = 0; x < TOTALTRIANGLES; x++) {
			figures[TOTALCIRCLES + TOTALCIRCLESWITHCENTRE + x] = new Triangle(gen.nextInt(300), gen.nextInt(300),
					gen.nextInt(300), gen.nextInt(300), gen.nextInt(300), gen.nextInt(300));
			// Set "T"+x as label

		}

		// Reuse the algorithms from the previous exercise

		// Sort the vector by area from smallest to largest

		// show the figures
		// w.showFigures(figures);

		// compute and show the total area
		System.out.printf("The total area is: %.2f\n", totalArea(/* COMPLETE */));

		// Keyboard pause
		MyKeyboard.pressEnter();

		// close and frees the resources used by the window
		// closeWindow();
	}

	private static void initializeWindow() {
		w = new MyWindow("Geometric figures");
	}

	private static void closeWindow() {
		w.close();
	}

}
