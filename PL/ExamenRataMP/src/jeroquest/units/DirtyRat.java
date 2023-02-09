package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jeroquest.boardgame.Dice;

public class DirtyRat extends Monster {
	// initial values for the attributes
	protected static final int MOVEMENT = 4;
	protected static final int ATTACK = 2;
	protected static final int DEFENCE = 2;
	protected static final int BODY = 5;
	boolean fearful = false;
	public DirtyRat(String name) {
		super(name, MOVEMENT, ATTACK, DEFENCE, BODY);
	}
	
	public boolean isFearful() {
		return fearful;
	}

	public void setFearful(boolean fearful) {
		this.fearful = fearful;
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
		return 'R';
	}

	/************************************************
	 * Interface GraphicElement implementation
	 **********************************************/

	// Icon of a rat
	private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/rata.png"));
	public void setImage(String iconpath) {
		icon = new ImageIcon(ClassLoader.getSystemResource(iconpath));
	}
	public Icon getImage() {
		return icon;
	}
	
	public int defend(int impacts) {
		int wounds = 0;

		// it tries to block the impacts with the defence
		for (int totalDefenceDices = getDefence(); (impacts > 0) && (totalDefenceDices > 0); totalDefenceDices--)
			if (Dice.roll() == 6) // a 6 is necessary to block an impact
				impacts--;

		// if any unblocked impact, decrement body points
		if (impacts > 0) {
			// the life of a character cannot be lower then zero
			wounds = Math.min(getBody(), impacts);
			setBody(getBody() - wounds);
			if(this.isFearful() && (this.getBody()<=(BODY/2))) {
				this.setBody(0);
			}
			System.out.printf("The monster " + this.getName() + " cannot block %d impacts%s", impacts,
					(isAlive() ? "\n" : " and dies\n"));
			this.setFearful(true);
			this.setImage("jeroquest/gui/images/rata_asustada.png");
		} else {
			System.out.printf("The monster %s blocks the attack\n", this.getName());
			this.setFearful(false);
			this.setImage("jeroquest/gui/images/rata.png");
		}

		return wounds;
	}
	
	public void regenerate() {
		if((this.getBody()+1)<=BODY) this.setBody(this.getBody()+1);
	}
	
	public boolean isEnemy(Character c) {
		return super.isEnemy(c) || (c.getBody()>this.getBody());
	}
}
