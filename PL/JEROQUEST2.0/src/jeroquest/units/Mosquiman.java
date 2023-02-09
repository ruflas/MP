package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jeroquest.boardgame.Dice;
import jeroquest.boardgame.XYLocation;
import jeroquest.logic.Game;
import jeroquest.utils.DynamicVectorCharacters;
import jeroquest.utils.DynamicVectorXYLocation;

public class Mosquiman extends Monster {
	// initial values for the attributes
		protected static final int MOVEMENT = 4;
		protected static final int ATTACK = 2;
		protected static final int DEFENCE = 2;
		protected static final int BODY = 2;
		protected int energy = 0;
		
		/**
		 * Create a mosquiman from its name
		 * 
		 * @param name name of the mosquiman
		 */
		public Mosquiman(String name) {
			super(name, MOVEMENT, ATTACK, DEFENCE, BODY);
			this.setEnergy(energy);
		}
		

		public int getEnergy() {
			return energy;
		}
		
		@Override
		public boolean isEnemy(Character c) {
			return (c instanceof WarmBlood); //The mosquiman is not like other Monsters and he only attacks the Characters that implements the WarmBlood interface.
		}
		
		@Override
		public boolean actionCombat(Game currentGame) {
			// Attack a random enemy
			DynamicVectorCharacters targets = validTargets(currentGame);
			if (targets.length() > 0) {
				//Character target = targets.get(Dice.roll(targets.length()) - 1);
				Character target = targets.get(0);
				for(int i = 0; i<targets.length();i++) { //This for compares if there is other target with a higher heatLevel().
					if(((WarmBlood) targets.get(i)).heatLevel()>((WarmBlood)target).heatLevel()) target = targets.get(i); //If it exist it changes the target to the highest heatLevel() at range.
				}
				System.out.println(
						this.getName() + this.getPosition() + " attacks to " + target.getName() + target.getPosition());
				this.combat(target, currentGame);
				return true;
			}
			return false;
		}
		
		@Override
		public void combat(Character c, Game currentGame) { // attacks to c and c defends itself
			int def = c.defend(this.attack());
			if(def>0 && this.getEnergy()<3) this.setEnergy(this.getEnergy()+1); //If a mosquiman hits an enemy and his energy level is not at the max, it increase in one point.
			if (!c.isAlive()) {
				currentGame.getBoard().removePiece(c);
			}
		}
		
		@Override
		public int defend(int impacts) {
			int wounds = 0;
			if(impacts>0) {
				if(Dice.roll()%2==0) { //If the impact is upper than 1, the mosquiman has a 50% of chance to scape from the attack.
					System.out.printf("The monster %s scape from the attack\n", this.getName());
				}
				else { //In the other case it defends normally.
					// it tries to block the impacts with the defence
					for (int totalDefenceDices = getDefence(); (impacts > 0) && (totalDefenceDices > 0); totalDefenceDices--)
						if (Dice.roll() == 6) // a 6 is necessary to block an impact
							impacts--;
					// if any unblocked impact, decrement body points
					if (impacts > 0) {
						// the life of a character cannot be lower then zero
						wounds = Math.min(getBody(), impacts);
						setBody(getBody() - wounds);
						System.out.printf("The monster " + this.getName() + " cannot block %d impacts%s", impacts,
								(isAlive() ? "\n" : " and dies\n"));
					} else {
						System.out.printf("The monster %s blocks the attack\n", this.getName());
					}
				}
			}
			return wounds;
		}
		
		@Override
		public DynamicVectorXYLocation validPositions(Game currentGame) {

			DynamicVectorXYLocation positions = new DynamicVectorXYLocation();

			XYLocation position = this.getPosition().south();
			
			if (currentGame.getBoard().freeSquare(position))
				positions.add(position);

			position = this.getPosition().west();
			if (currentGame.getBoard().freeSquare(position))
				positions.add(position);

			position = this.getPosition().east();
			if (currentGame.getBoard().freeSquare(position))
				positions.add(position);

			position = this.getPosition().north();
			if (currentGame.getBoard().freeSquare(position))
				positions.add(position);
			
			//------------------------------------------------
			//-Now with this part of code the mosquiman can move diagonally.-
			XYLocation position1 = this.getPosition().north();
			XYLocation position2 = this.getPosition().east();
			if(currentGame.getBoard().freeSquare(position1) && currentGame.getBoard().freeSquare(position2)) {
				position = new XYLocation(position1.getX(),position2.getY());
				positions.add(position);
			}
			position1 = this.getPosition().north();
			position2 = this.getPosition().west();
			if(currentGame.getBoard().freeSquare(position1) && currentGame.getBoard().freeSquare(position2)) {
				position = new XYLocation(position1.getX(),position2.getY());
				positions.add(position);
			}
			position1 = this.getPosition().south();
			position2 = this.getPosition().west();
			if(currentGame.getBoard().freeSquare(position1) && currentGame.getBoard().freeSquare(position2)) {
				position = new XYLocation(position1.getX(),position2.getY());
				positions.add(position);
			}
			position1 = this.getPosition().south();
			position2 = this.getPosition().east();
			if(currentGame.getBoard().freeSquare(position1) && currentGame.getBoard().freeSquare(position2)) {
				position = new XYLocation(position1.getX(),position2.getY());
				positions.add(position);
			}

			return positions;
		}
		
		//This method is used to increase the body of the mosquiman in one unit.
		public void moreStrength() {
			this.setBody(this.getBody()+1);
		}
		
		public void setEnergy(int energy) {
			if(energy<=3 && energy>0) this.energy = energy;
			else System.out.print("The level of energy must be between 0-3.");
		}
		
		@Override
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
			return 'Q';
		}

		/************************************************
		 * Interface GraphicElement implementation
		 **********************************************/

		// Icon of a mosquiman
		private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/mosquiman.png"));
		
		@Override
		public Icon getImage() {
			return icon;
		}
}
