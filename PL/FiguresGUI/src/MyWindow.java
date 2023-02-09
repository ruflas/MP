
/** Represents graphically in a window an array of geometric figures
 *  Using polymorphism to apply the interface GeometricFigure
 *  @author Programming Methodology Professors
 *  @version 1.0  */

import javax.swing.JFrame; // needed for the window
import javax.swing.JPanel; // needed for the panel inside of the window
import java.awt.Graphics; // needed to paint the content of the window

import java.io.BufferedReader; // needed (and below) to read keystrokes from the keyboard
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class to represent graphical information using a panel and an objects array
 * to show In this version it inherits directly from JFrame
 * 
 * @author Programming Methodology Professors
 *
 */
public class MyWindow extends JFrame {

	private MyPanel panel; // panel to show the content

	/**
	 * Constructor of MyWindow
	 * 
	 * @param title the title of the window
	 */
	public MyWindow(String title) {
		// set the title of the window using the constructor of JFrame
		super(title);

		// create a panel
		panel = new MyPanel();

		// set what to do when the window is closed -> exit the application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add the panel to the window
		add(panel);
		// set the window dimensions
		setSize(350, 350);
		// make the window visible
		setVisible(true);
	}

	/**
	 * Set the array of objects to be shown and force to update the visualisation
	 * 
	 * @param cirs new array of objects to show
	 */
	public void showCircles(CircleWithCentre[] cirs) {
		panel.setFigs(cirs);
		// force to repaint the circles in the window
		panel.repaint();
	}

	/**
	 * Close the window and frees the used resources
	 */
	public void close() {
		dispose();
	}

}

/**
 * Class MyPanel, represents a content panel to show in a window specifically an
 * array of objects
 * 
 * @author Programming Methodology Professors
 *
 */
class MyPanel extends JPanel {
	// NOTE: this variable definition avoids a warning related to serialised classes
	private static final long serialVersionUID = 1L;

	// array of objects to show
	private CircleWithCentre[] figs = null;

	/**
	 * Observer of figs
	 * 
	 * @return circles
	 */
	public CircleWithCentre[] getFigs() {
		return figs;
	}

	/**
	 * modifier of figs
	 * 
	 * @param figs new array with figures
	 */
	public void setFigs(CircleWithCentre[] figs) {
		this.figs = figs;
	}

	/**
	 * Method to repaint the array of objects
	 * 
	 * @param g the object of class Graphics where to paint (NOTE: JAVA invokes this
	 *          method whenever it is necessary to repaint the panel (eg.: maximise,
	 *          minimise, move the window,...) (NOTE2: polymorphic method as not all
	 *          figures can be painted)
	 */
	public void paintComponent(Graphics g) {
		// ask the parent class to paint its content
		super.paintComponent(g);

		// if there are figures defined, they are repainted
		// through the interface GraphicFigure

		// For each figure from the attribute figs
		// if it is a graphic figure, then it is painted . . .
	}

}

/**
 * Static class MyKeyboard to have access to the pressed keys in the keyboard
 * from the text console. (The windows have a different system, based on events,
 * to detect user interaction)
 * 
 * @author Programming Methodology Professors
 *
 */
class MyKeyboard {
	/**
	 * Waits until the Enter key is pressed
	 */
	static public void pressEnter() {

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Press Enter to continue");
		try {
			keyboard.readLine();
		} catch (IOException ex1) {
		}
	}
}
