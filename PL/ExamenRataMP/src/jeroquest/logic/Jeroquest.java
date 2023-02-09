package jeroquest.logic;

import jeroquest.boardgame.Dice;
import jeroquest.boardgame.XYLocation;
import jeroquest.gui.JeroquestWindow;
import jeroquest.gui.MyKeyboard;
import jeroquest.units.Character;
import jeroquest.units.DirtyRat;
import jeroquest.units.Hero;
import jeroquest.units.Monster;

/**
 * Programming Methodology Practice. Jeroquest - An example of Object Oriented
 * Programming. Class Jeroquest - Represents the game Jeroquest and allows to
 * play it. For that it offers a method to create a new game and start the game.
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @author Juan Luis Mateo
 *
 */

// The class Jeroquest includes an object Game and the method toPlay
// that implements the logic of the game

public class Jeroquest {

	private Game currentGame; // current game
	private static JeroquestWindow monitor;
	private int cont = 0;
	public static void showGame() {
		if (monitor != null)
			monitor.showGame();
	}

	/**
	 * Simulate a Jeroquest game
	 */
	public void toPlay() {
		// GUI - Create the window for the current game
		monitor = new JeroquestWindow(currentGame);

		// Start the game
		System.out.println("START OF THE GAME");

		// CONSOLE - print the initial state of the game
		System.out.println(currentGame);

		// GUI - update the game in the window
		monitor.showGame();
		MyKeyboard.pressEnter();

		// resolve the game in successive rounds
		while (noEndOfGame()) {
			// resolve the current round
			resolveRound();

			// CONSOLE - print the current state of the game
			System.out.println(currentGame);

			// GUI - update the game in the window
			monitor.showGame();
			MyKeyboard.pressEnter();

			// increment round
			nextRound();
		}

		// CONSOLE - show the end of the game
		System.out.println("END OF THE GAME");
		System.out.println("Winners: " + highestBody());
		for(int i = 0; i<currentGame.getCharacters().length; i++) {
			for(int j = i+1; j<currentGame.getCharacters().length; j++) {
				Character c1 = currentGame.getCharacters()[i];
				Character c2 = currentGame.getCharacters()[j];
				if(c1.getBody()>c2.getBody()) {
					currentGame.getCharacters()[j] = c1;
					currentGame.getCharacters()[i] = c2;
				}
			}
		}
		for(int i = 0; i<currentGame.getCharacters().length; i++) {
			if(currentGame.getCharacters()[i] instanceof DirtyRat && currentGame.getCharacters()[i].isAlive()) {
				System.out.println(currentGame.getCharacters()[i].toString());
			}
			else if(currentGame.getCharacters()[i] instanceof DirtyRat && currentGame.getCharacters()[i].isAlive()==false) cont++;
		}
		System.out.println(cont);
		MyKeyboard.pressEnter();

		// GUI - Close the window
		monitor.close();
	}

	/**
	 * create a new game from its components
	 * 
	 * @param numHeroes   how many heroes
	 * @param numMonsters how many monsters
	 * @param rows        height of the board
	 * @param columns     width of the board
	 * @param totalRounds total number of rounds
	 */
	public void newGame(int numHeroes, int numMonsters, int rows, int columns, int totalRounds) { // Ready for round 1
		currentGame = new Game(numHeroes, numMonsters, rows, columns, totalRounds);

		// place the characters in the board randomly
		placeCharacters();
	}

	/**
	 * Go to the next round
	 */
	private void nextRound() {
		currentGame.setCurrentRound(currentGame.getCurrentRound() + 1);
		for(int i = 0; i<currentGame.getCharacters().length; i++) {
			Character c = currentGame.getCharacters()[i];
			if(c instanceof DirtyRat) {
				if(((DirtyRat)c).isFearful()) {
					((DirtyRat)c).setFearful(false);
					((DirtyRat)c).setImage("jeroquest/gui/images/rata.png");
				}
				else ((DirtyRat) c).regenerate();
			}
		}
	}

	/**
	 * Check it is the end of the game
	 * 
	 * @return true if the total number of turns has been reached or there no more
	 *         alive characters in both sides, false otherwise
	 */
	private boolean noEndOfGame() {
		return ((currentGame.getCurrentRound() <= currentGame.getTotalRounds()) && opponentsLeft());
	}

	/**
	 * Execute the round of the game: each alive character resolve its turn The
	 * round ends immediately if in any moment there are no any alive character in
	 * both sides
	 */
	private void resolveRound() {
		System.out.println("Round: " + currentGame.getCurrentRound());

		for (int x = 0; (x < currentGame.getCharacters().length) && opponentsLeft(); x++) {
			Character c = currentGame.getCharacters()[x];
			if (c.isAlive()) {
				if(c instanceof DirtyRat && ((DirtyRat)c).isFearful()) {
					System.out.printf("%s esta asustada.",c.getName());
				}
				else c.resolveTurn(currentGame);
			}
		}
	}

	/**
	 * Place the characters in the board randomly in valid positions: (free and
	 * inside of the board)
	 */
	private void placeCharacters() {
		int rows = currentGame.getBoard().getRows();
		int columns = currentGame.getBoard().getColumns();

		for (Character p : currentGame.getCharacters()) {
			// search a random position inside of the board
			int row = Dice.roll(rows) - 1;
			int col = Dice.roll(columns) - 1;
			// while the position is not valid
			while (!currentGame.getBoard().movePiece(p, new XYLocation(row, col))) {
				// search a new random position
				row = Dice.roll(rows) - 1;
				col = Dice.roll(columns) - 1;
			}
		}
	}

	/**
	 * Obtain which side has in total more body points
	 * 
	 * @return the name of the side with more body points
	 */
	private String highestBody() { // Returns the name of the class with highest value for the total body points in
									// the current state of the game
		int cHeroes = 0;
		int cMonsters = 0;

		for (Character c : currentGame.getCharacters()) {
			if (c instanceof Hero)
				cHeroes += c.getBody();
			else if (c instanceof Monster)
				cMonsters += c.getBody();
			// System.out.println(p.getClass());
		}
		if (cMonsters > cHeroes)
			return "Monsters";
		else if (cHeroes > cMonsters)
			return "Heroes";
		else
			return "Draw";
	}

	/**
	 * Check if there are characters alive of both sides
	 * 
	 * @return true if there are at least one character alive for each side
	 */

	public boolean opponentsLeft() { // Returns true if both sides have characters alive
		boolean heroesAlive = false;
		boolean monstersAlive = false;
		int x = 0;
		while ((x < currentGame.getCharacters().length) && !(heroesAlive && monstersAlive)) {
			if (currentGame.getCharacters()[x].isAlive())
				if (currentGame.getCharacters()[x] instanceof Hero)
					heroesAlive = true;
				else // this second if is necessary since there can be "neutral" characters (they
						// don't inherit neither from Monster nor from Hero)
				if (currentGame.getCharacters()[x] instanceof Monster)
					monstersAlive = true;
			x++;
		}

		return heroesAlive && monstersAlive;
	}

}
