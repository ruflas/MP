package jeroquest.units;

public class Wasp extends Monster{
	// initial values for the attributes
	protected static final int MOVEMENT = 0;
	protected static final int ATTACK = 1;
	protected static final int DEFENCE = 1;
	protected static final int BODY = 1;

	public Wasp(String name) {
		super(name, MOVEMENT, ATTACK, DEFENCE, BODY);
	}
}
