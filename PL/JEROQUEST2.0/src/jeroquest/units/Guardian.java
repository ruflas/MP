package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jeroquest.logic.Game;

public class Guardian extends Character {
	// initial values for the attributes
	protected static final int MOVEMENT = 5;
	protected static final int ATTACK = 5;
	protected static final int DEFENCE = 5;
	protected static final int BODY = 5;
	Weapon handcuffs = new Weapon("handcuffs",0);
	//Constructor
	public Guardian(String name) {
		super(name, MOVEMENT, ATTACK, DEFENCE, BODY);
	}
	
	public char toChar() {
		return 'X';
	}
	
	// Guardian icon
	private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/guardian.png"));

	public Icon getImage() {
		return icon;
	}
	
	public boolean isEnemy(Character c) {
		boolean check = false;
		if(!(c instanceof Guardian)) check = ((Suspect) c).getViolent();
		return check;
	}
	
	public boolean actionCombat(Game currentGame) {
		for(int x = 0; x<currentGame.getCharacters().length; x++) {
			Character c = currentGame.getCharacters()[x];
			if( c instanceof Suspect && ((Suspect) c).getViolent()) {
				for(int i = 0; i<currentGame.getCharacters().length; i++) {
					if(currentGame.getCharacters()[i] instanceof Guardian) ((Guardian) currentGame.getCharacters()[i]).Penalice(c);
				}
			}
		}
		return true;
	}
	
	public void Penalice(Character c) {
		if(c instanceof Suspect && isEnemy(c)) {
			if(c instanceof Hero && ((Hero) c).getWeapon() != null) {
				((Hero) c).setWeapon(null);
			}
			else if(c instanceof Hero && ((Hero) c).getWeapon() == null) {
				((Hero) c).setWeapon(handcuffs);
			}
			else {
				((Monster) c).setPenalty(2);
			}
			((Suspect) c).setViolent(false);
			
			System.out.print(this.getName() +" penalize " + c.getName());
		}
	}
	public void guard() {
		System.out.printf("\n %s está vigilando.\n", this.getName());
	}
	
	@Override
	public int defend(int impacts) {
		return 0;
	}
	
}
