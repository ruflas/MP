package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jeroquest.boardgame.Dice;
import jeroquest.logic.Game;
import jeroquest.utils.DynamicVectorCharacters;

public class Swarm extends Monster{

	// initial values for the attributes
	protected static final int MOVEMENT = 5;
	private final int swarmBodyInitial;
	private final int swarmAttackInitial;
	private final int swarmDefenceInitial;
	private DynamicVectorCharacters waspv;
	
	public Swarm(String name,int wasps) {
		super(name,MOVEMENT, 0, 0, 0);
		waspv = new DynamicVectorCharacters();
		for(int i = 0; i<=wasps; i++) {
			if (Dice.roll() % 2 == 0) {
				waspv.insert(i, new Wasp("Wasp" + i));
			}
			else{
				waspv.insert(i, new Hornet("Hornet" + i));
			}
			this.setBody(this.getBody() + waspv.get(i).getBody());
			this.setDefence(this.getDefence() + waspv.get(i).getDefence());
			this.setAttack(this.getAttack() + waspv.get(i).getAttack());
		}
		this.swarmBodyInitial= this.getBody();
		this.swarmDefenceInitial = this.getDefence();
		this.swarmAttackInitial = this.getAttack();
	}
	
	@Override public int getAttackInitial(){return swarmAttackInitial;
	}
	@Override public int getDefenceInitial() {return swarmDefenceInitial;
	}
	@Override public int getBodyInitial() {return swarmBodyInitial;
	}
	
	
	/************************************************
	 * Interface Piece implementation
	 **********************************************/

	public int getSwarmBodyInitial() {
		return swarmBodyInitial;
	}


	public int getSwarmAttackInitial() {
		return swarmAttackInitial;
	}


	public int getSwarmDefenceInitial() {
		return swarmDefenceInitial;
	}


	/**
	 * Generate a text representation of the character in the board (implementing an
	 * abstract method)
	 * 
	 * @return the text representation of the object in the board
	 */
	public char toChar() {
		return 'S';
	}

	/************************************************
	 * Interface GraphicElement implementation
	 **********************************************/

	// Icon of a mummy
	private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/swarm.gif"));

	public Icon getImage() {
		return icon;
	}
	/*
	public int defend(int impacts) {
		int wounds = 0;

		// it tries to block the impacts with the defence
		for (int totalDefenceDices = getDefence(); (impacts > 0) && (totalDefenceDices > 0); totalDefenceDices--)
			if (Dice.roll() == 6) // a 6 is necessary to block an impact
				impacts--;

		// if any unblocked impact, decrement body points
		if (impacts > 0) {
			// the life of a character cannot be lower then zero
			impacts = 1;
			int i = 0;
			while(i<waspv.length()) {
				if(waspv.get(i).isAlive()==false) i++;
			}
			wounds = Math.min(getBody(), impacts);
			waspv.get(i).setBody(getBody() - wounds);
			System.out.printf("The monster " + waspv.get(i).getName() + " cannot block %d impacts%s", impacts,
					(isAlive() ? "\n" : " and dies\n"));
		} else {
			System.out.printf("The monster %s blocks the attack\n", this.getName());
		}

		return wounds;
	}
	*/
	@Override 
	public int defend(int impacts) {
		// reduce impacts to 1
		impacts= Math.min(1, impacts);
		// find the first alive wasp
		int pos= 0;
		while(!waspv.get(pos).isAlive())pos++;
		// the chosen wasp makes the defence
		int wounds= waspv.get(pos).defend(impacts);
		// update the attributes of the swarm
		this.setBody(this.getBody() -wounds);if(!waspv.get(pos).isAlive()) { 
			//if it dies, its attributes don’t count 
			//for the swarm
			this.setDefence(this.getDefence() -waspv.get(pos).getDefence());
			this.setAttack(this.getAttack() -waspv.get(pos).getAttack());}
		return wounds;}

	public void combat(Character c, Game currentGame) { // attacks to c and c defends itself
		c.defend(this.attack());
		int cont = 0;
		for(int i = 0; i<waspv.length();i++) {
			if(waspv.get(i).isAlive()==false) cont++;
		}
		if (cont==waspv.length()) {
			currentGame.getBoard().removePiece(c);
		}
	}
	
	public DynamicVectorCharacters getWasps() {
		return waspv;
	}
	
	@Override
	public String toString() {
		String s = this.getName();
		s += "\n";
		for(int i = 0; i<waspv.length(); i++) {
			s+=waspv.get(i).toString();
			s+="\n";
		}
		return s;
	}
}
