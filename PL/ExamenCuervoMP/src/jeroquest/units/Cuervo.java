package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jeroquest.boardgame.Dice;
import jeroquest.boardgame.XYLocation;
import jeroquest.gui.MyKeyboard;
import jeroquest.logic.Game;
import jeroquest.logic.Jeroquest;
import jeroquest.utils.DynamicVectorCharacters;
import jeroquest.utils.DynamicVectorXYLocation;

public class Cuervo extends Character implements Tesorero{
	// initial values for the attributes
	protected static final int MOVEMENT = 7;
	protected static final int ATTACK = 0;
	protected static final int DEFENCE = 1;
	protected static final int BODY = 1;
	private int monedas = 0;
	
	public Cuervo(String name) {
		super(name, MOVEMENT, ATTACK, DEFENCE, BODY);
		this.setMonedas(monedas);
	}

	@Override
	public int defend(int impacts) {
		return 0;
	}
	
	/************************************************
	 * Interface Piece implementation
	 **********************************************/

	/**
	 * Generate a text representation of the character in the board (implementing an
	 * abstract method)
	 * 
	 * @return the text representation of the object in the board
	 */
	public char toChar() {
		return 'c';
	}

	/************************************************
	 * Interface GraphicElement implementation
	 **********************************************/

	// Icon of a cuervo
	private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/cuervo.png"));

	public Icon getImage() {
		return icon;
	}

	@Override
	public int getMonedas() {
		// TODO Auto-generated method stub
		return monedas;
	}

	@Override
	public void setMonedas(int monedas) {
		this.monedas=monedas;
		
	}

	@Override
	public void transfiereTodo(Tesorero P) {
		this.setMonedas(this.getMonedas()+P.getMonedas());
		P.setMonedas(0);
	}
	
	@Override
	public boolean isEnemy(Character c) {
		return (c instanceof Tesorero && ((Tesorero) c).getMonedas()>0)&&!(c instanceof Cuervo);
	}
	
	@Override
	public void resolveTurn(Game currentGame) {
		// Move randomly through the board
		actionMovement(currentGame);
		
		// Attack to a random enemy
		actionCombat(currentGame);

		// Possibles improvement (among others):
		// - Move towards the closest enemy / with less body points /...
		// A.- First in Xs and later in Ys
		// B.- First in the coordinate with difference with the target's position
		// - AI: check if there is free way until the target
		// - What to do if our way is blocked by allies?
		// - Stop is there is an enemy at attack range
		// and if the square is free and inside of the board move to that position

	}
	
	@Override
	public int actionMovement(Game currentGame) {
		System.out.print(this.getName() + this.getPosition() + " moves to ");
		DynamicVectorXYLocation validPositions = validPositions(currentGame);
		int mov = this.getMovement();
		if(this.getMonedas()==0) {
			XYLocation richestLocation = richestCharacter(currentGame);
			XYLocation near = new XYLocation(0,0);
			if(validPositions.length()>0) near = validPositions.get(0);
			for(int i = 0; i<validPositions.length();i++) {
				if((validPositions.get(i).getX()-richestLocation.getX())<(near.getX()-richestLocation.getX())){
					if((validPositions.get(i).getY()-richestLocation.getY())<(near.getY()-richestLocation.getY())){
						near = validPositions.get(i);
					}
				}
			}
			while ((validPositions.length() > 0) && (mov > 0)) {
				currentGame.getBoard().movePiece(this, near);
				mov--;
				System.out.println(this.getPosition());

				// window
				Jeroquest.showGame();
				MyKeyboard.pressEnter();

				validPositions = validPositions(currentGame);
			}
		}
		else {
			XYLocation near = new XYLocation(0,0);
			XYLocation center = new XYLocation(0,0);
			if(validPositions.length()>0) near = validPositions.get(0);
			for(int i = 0; i<validPositions.length();i++) {
				if((validPositions.get(i).getX()-center.getX())<(near.getX()-center.getX())){
					if((validPositions.get(i).getY()-center.getY())<(near.getY()-center.getY())){
						near = validPositions.get(i);
					}
				}
			}
			while ((validPositions.length() > 0) && (mov > 0)) {
				// if it can it moves in a direction chosen randomly
				XYLocation newPosition = validPositions.get(Dice.roll(validPositions.length()) - 1);
				currentGame.getBoard().movePiece(this, newPosition);
				mov--;
				System.out.println(this.getPosition());

				// window
				Jeroquest.showGame();
				MyKeyboard.pressEnter();

				validPositions = validPositions(currentGame);
			}
		}

		System.out.println();
		// window
		Jeroquest.showGame();
		MyKeyboard.pressEnter();

		return this.getMovement() - mov;
	}
	

	public XYLocation richestCharacter(Game currentGame) {
		Tesorero richest = null;
		if(currentGame.getCharacters().length>0) {
			int cont = 0;
			while(cont<currentGame.getCharacters().length) {
				if(currentGame.getCharacters()[cont] instanceof Tesorero) {
					richest =(Tesorero) currentGame.getCharacters()[cont];
					cont = currentGame.getCharacters().length;
				}
				cont++;
			}
		}
		for(int i = 0; i<currentGame.getCharacters().length; i++) {
			Character c = currentGame.getCharacters()[i];
			if(c.isAlive() && this.isEnemy(c) && c instanceof Tesorero && ((Tesorero)c).getMonedas()>richest.getMonedas()) {
				richest = ((Tesorero) c);
			}
		}
		return ((Character) richest).getPosition();
	}
	
	@Override
	public boolean actionCombat(Game currentGame) {
		// Attack a random enemy
		DynamicVectorCharacters targets = validTargets(currentGame);

		if (targets.length() > 0) {
			Character target = targets.get(Dice.roll(targets.length()) - 1);
			this.transfiereTodo((Tesorero)target);
			System.out.println(
					this.getName() + this.getPosition() + " attacks to " + target.getName() + target.getPosition());
			this.combat(target, currentGame);
			return true;
		}
		return false;
	}

}
