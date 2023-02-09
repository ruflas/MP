package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jeroquest.boardgame.Dice;
import jeroquest.logic.Game;
import jeroquest.utils.DynamicVectorCharacters;

public class Zombi extends Monster {
	// initial values for the attributes
	protected static final int MOVEMENT = 4;
	protected static final int ATTACK = 3;
	protected static final int DEFENCE = 0;
	protected static final int BODY = 3;

	/**
	 * Create a zombi from its name
	 * 
	 * @param name name of the zombi
	 */
	public Zombi(String name) {
		super(name, MOVEMENT, ATTACK, DEFENCE, BODY);
	}
	
	public int defend(int impacts) {
		return super.defend(0);
	}
	
	public boolean actionCombat(Game currentGame) {
		// Attack a random enemy
		DynamicVectorCharacters targets = validTargets(currentGame);

		if (targets.length() > 0) {
			int pos = -1;
			for(int i = 0; i<targets.length();i++) {
				if(targets.get(i) instanceof Barbarian) pos = i;
			}
			Character target = null;
			if(pos>-1) target = targets.get(pos);
			else target = targets.get(Dice.roll(targets.length()) - 1);
			System.out.println(
					this.getName() + this.getPosition() + " attacks to " + target.getName() + target.getPosition());
			this.combat(target, currentGame);
			return true;
		}
		return false;
	}
	
	public void degradacion() {
		this.setBody(this.getBody()-1);
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
		return 'Z';
	}

	/************************************************
	 * Interface GraphicElement implementation
	 **********************************************/

	// Icon of a zombi
	private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/zombi.gif"));

	public Icon getImage() {
		return icon;
	}

}
