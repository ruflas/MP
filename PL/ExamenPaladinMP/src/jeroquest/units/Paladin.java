package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jeroquest.boardgame.XYLocation;
import jeroquest.logic.Game;
import jeroquest.utils.DynamicVectorCharacters;

public class Paladin extends Hero{
	// initial values for the attributes
		protected static final int MOVEMENT = 6;
		protected static final int ATTACK = 2;
		protected static final int DEFENCE = 2;
		protected static final int BODY = 10;
		protected int energia = (int) Math.random()*2+2;
		/**
		 * Create a barbarian from its name and the player name
		 * 
		 * @param name   barbarian's name
		 * @param player name of the player that controls it
		 */
		public Paladin(String name,String player) {
			super(name, MOVEMENT, ATTACK, DEFENCE, BODY,player,new Weapon("Longsword", 3));
		}
		
		public int getEnergia() {
			return energia;
		}



		public void setEnergia(int energia) {
			this.energia = energia;
		}

		@Override
		public boolean actionCombat(Game currentGame) {
			// Attack a random enemy
			DynamicVectorCharacters targets = validTargets(currentGame);
			if (targets.length() > 0) {
				for(int i = 0; i<targets.length();i++) {
					Character target = targets.get(i);
					if(i<3) {
						int energia_empleada = (int) Math.random()*this.getEnergia();
						this.setAttack(this.getAttack()+energia_empleada);
						this.setEnergia(this.getEnergia()-energia_empleada);
					}
					//int aux = this.getAttack();
					if(target instanceof Demons) this.setAttack(this.getAttack()*2); 
					System.out.println(
							this.getName() + this.getPosition() + " attacks to " + target.getName() + target.getPosition());
					this.combat(target, currentGame);
					this.setAttack(this.getAttackInitial());
				}
				return true;
			}
			return false;
		}
		
		public boolean isWithinRange(XYLocation pos) {
			// pos to the North from this character
			if ((this.getPosition().getX() == pos.getX() - 1) && (this.getPosition().getY() == pos.getY()))
				return true;

			// po to the South from this character
			if ((this.getPosition().getX() == pos.getX() + 1) && (this.getPosition().getY() == pos.getY()))
				return true;

			// pos to the East from this character
			if ((this.getPosition().getY() == pos.getY() - 1) && (this.getPosition().getX() == pos.getX()))
				return true;

			// pos2 to the West from this character
			if ((this.getPosition().getY() == pos.getY() + 1) && (this.getPosition().getX() == pos.getX()))
				return true;
			
			if(((this.getPosition().getY() == pos.getY() + 1)) && (this.getPosition().getX() == pos.getX() + 1))
				return true;
			if(((this.getPosition().getY() == pos.getY() + 1)) && (this.getPosition().getX() == pos.getX() - 1))
				return true;
			if(((this.getPosition().getY() == pos.getY() - 1)) && (this.getPosition().getX() == pos.getX() + 1))
				return true;
			if(((this.getPosition().getY() == pos.getY() - 1)) && (this.getPosition().getX() == pos.getX() - 1))
				return true;
			return false;
		}
		
		public void healing(Game currentGame) {
			DynamicVectorCharacters validHealing = new DynamicVectorCharacters();
			for (Character character : currentGame.getCharacters()) {
				if (character.isAlive() && !(this.isEnemy(character))) {
					if (isWithinRange(character.getPosition()))
						validHealing.add(character);
				}
			}
			for(int i = 0; i<validHealing.length();i++) {
				validHealing.get(i).setBody(validHealing.get(i).getBody()+1);
			}
			if(this.getBody()<BODY) {
				this.setBody(this.getBody()+1);
			}
		}
		
		@Override
		public void resolveTurn(Game currentGame) {

			// Attack to a random enemy
			actionCombat(currentGame);

			// Move randomly through the board
			actionMovement(currentGame);
			if(this.getEnergia()>1) this.healing(currentGame);
			// Possibles improvement (among others):
			// - Move towards the closest enemy / with less body points /...
			// A.- First in Xs and later in Ys
			// B.- First in the coordinate with difference with the target's position
			// - AI: check if there is free way until the target
			// - What to do if our way is blocked by allies?
			// - Stop is there is an enemy at attack range
			// and if the square is free and inside of the board move to that position

		}

		
		public void regenerateEnergy() {
			if(this.getEnergia()<4) this.setEnergia(this.getEnergia()+(int) Math.random());
		}
		
		@Override
		/************************************************
		 * Interface Piece implementation
		 ************************************************
		/**
		 * Generate a text representation of the character in the board (implementing an
		 * abstract method)
		 * 
		 * @return the text representation of the object in the board
		 */
		public char toChar() {
			return 'P';
		}

		/************************************************
		 * Interface GraphicElement implementation
		 **********************************************/
		
		// Paladin icon
		private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/paladin.png"));

		public Icon getImage() {
			return icon;
		}

}
