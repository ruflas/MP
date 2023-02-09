package jeroquest.units;

public class Hornet extends Monster {
	// initial values for the attributes
	protected static final int MOVEMENT = 0;
	protected static final int ATTACK = 2;
	protected static final int DEFENCE = 1;
	protected static final int BODY = 2;

	public Hornet(String name) {
		super(name, MOVEMENT, ATTACK, DEFENCE, BODY);
	}
}
