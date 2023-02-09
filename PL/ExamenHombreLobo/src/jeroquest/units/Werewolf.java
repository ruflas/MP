package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jeroquest.boardgame.Dice;
import jeroquest.logic.Game;

public class Werewolf extends Barbarian {

	public Werewolf(String name, String player) {
		super(name, player);
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
		return 'W';
	}

	/************************************************
	 * Interface GraphicElement implementation
	 **********************************************/
	
	// Barbarian icon
	private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/barbarian.gif"));
    //Werefolf Icon
	private static Icon icon2 = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/hombrelobo.png"));
	public void transformacion(boolean noche) {
		if(noche)icon = icon2;
		else icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/barbarian.gif"));
	}
	public Icon getImage() {
		return icon;
	}
	
	public void regeneracion() {
		if(this.getBody()<this.getBodyInitial()) this.setBody(this.getBodyInitial()+1);
	}
	
	@Override
	public void combat(Character c, Game currentGame) { // attacks to c and c defends itself
		int defensa = c.defend(this.attack());
		while(defensa>0 || !(c.isAlive())) {
			defensa = c.defend(this.attack());
		}
		if (!c.isAlive()) {
			currentGame.getBoard().removePiece(c);
		}
	}
	
	@Override
	public boolean isEnemy(Character c) {
		if(this.getImage()==icon2) {
			return super.isEnemy(c)&&!(c instanceof Werewolf || c instanceof Barbarian);
		}
		else return super.isEnemy(c);
	}
	
	@Override
	public int defend(int impacts) {
		if(this.getImage()==icon2) {
			impacts = impacts/2;
			if(impacts%2!=0) {
				int r = Dice.roll(2);
				if(r==1) return super.defend(impacts/2);
				else return super.defend(impacts/2+1);
			}
			else return super.defend(impacts);
		}
		else return super.defend(impacts);
	}
}
