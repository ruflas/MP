
/**
 * Main program for the visualisation of circles in a window
 * @author Programming Methodology Professors
 * @version 1.0
 *
 */



public class CirclesMain {

	// Window where to show the circles
	private static MyWindow w = null;
	
	/**
	 * Program's main function
	 * @param args
	 */
	public static void main(String[] args) {

		// total number of circles to show
		final int TOTAL = 10;
		// array of circles with centre
		//CircleWithCentre[] circles = new CircleWithCentre[TOTAL];

		// Create and show the application's window
		// (initially without circles)
		//initializeWindow();

		// Generate circles
		// centre with coordinates X and Y in the range [1..250]
		// and radius [1..50]
		//for(int x = 0; x < TOTAL; x++)
			//circles[x] = new CircleWithCentre(Dice.roll(250),Dice.roll(250),Dice.roll(50));

		// CONSOLE: show circles in text format
		//for(CircleWithCentre c: circles)
			//System.out.println(c);	

		// WINDOW: show circles (in the window)
		//showCircles(circles);

		// We wait until the Enter key is pressed
		// MyKeyboard is a static class defined in MyWindow.java
		int cont = 1;
		while(cont<=10) {
			CircleWithCentre[] circles = new CircleWithCentre[TOTAL];
			initializeWindow();
			for(int x = 0; x < TOTAL; x++)
				circles[x] = new CircleWithCentre(Dice.roll(250),Dice.roll(250),Dice.roll(50));
			for(CircleWithCentre c: circles)
				System.out.println(c);	
			showCircles(circles);
			MyKeyboard.pressEnter();
			//MyWindow x = new MyWindow("CirclesAbsorb"); 
			//int k = Dice.roll();
			//if(k>0) moveCircles(circles,k);
			//while(overlapsCircles(circles) == true) overlapsCircles(circles);
			//MyWindow.showCircles(circles);
			for(int i = 0; i<circles.length; i++) {
				for(int j = i+1; j<circles.length; j++) {
					if(CircleWithCentre.overlaps(circles[i], circles[j]) && circles[i].getRadius()>0 && circles[j].getRadius()>0) {
						System.out.printf("\nSuperficie de Intersección de C%d y C%d : %f\n",i,j,CircleWithCentre.superficieInterseccion(circles[i],circles[j]));
					}
				}
			}
			MyKeyboard.pressEnter();
			w.close();
			//x.close();
			cont++;
		}
		//MyKeyboard.pressEnter();	


		// close and frees the resources used by the window
		closeWindow();


	}

	/**
	 * Creates and show the window with the title "Circles"
	 */
	 private static void initializeWindow()
	 {
		 w = new MyWindow("Circles"); 
	 }
	 
	 /**
	  * Closes the window 
	  */
	 private static void closeWindow()
	 {
		 w.close();
	 }
	 
	 /**
	  * Updates the array of circles to show in the window
	  * and repaint them
	  * @param circles array of circles to show
	  */
	 private static void showCircles(CircleWithCentre[] circles)
	 {
	 	// Show the circles in the window
		MyWindow.showCircles(circles);
	 }
	 
	 public static void moveCircles(CircleWithCentre[] circles,int k) {
		 for(int i = 0; i<circles.length; i++) {
			 int election = Dice.roll(3);
			 int x = k;
			 if(election == 1) {
				 int e = Dice.roll(2);
				 if(e == 2) x=-k;
				 Point aux = circles[i].getCenter();
				 if(aux.getX()+x>0) aux.setX(aux.getX()+x);
				 circles[i].setCenter(aux);
			 }
			 else if(election == 2) {
				 int e = Dice.roll(2);
				 if(e == 2) x=-k;
				 Point aux = circles[i].getCenter();
				 if(aux.getY()+x>0) aux.setY(aux.getY()+x);
				 circles[i].setCenter(aux);
			 }
			 else {
				 int e = Dice.roll(2);
				 if(e==1 && (circles[i].getRadius()+x)>0) circles[i].IncreaseRadius(x);
				 else {
					 if(circles[i].getRadius()-x>0) circles[i].DecreaseRadius(x);
				 }
			 }
		 }
	 }
	 public static boolean overlapsCircles(CircleWithCentre[] circles){
		 showCircles(circles);
		 boolean check = false;
		 for(int i = 0; i<circles.length; i++) {
				for(int j = i+1; j<circles.length; j++) {
					if(CircleWithCentre.overlaps(circles[i], circles[j]) && circles[i].getRadius()>0 && circles[j].getRadius()>0) {
						check = true;
						CircleWithCentre.absorb(circles[i],circles[j]);
						showCircles(circles);
					}
				}
			}
		 return check;
	 }
		 
}
