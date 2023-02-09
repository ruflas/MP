package exercise2;

import java.io.Serializable;

public class Efficiency implements Serializable{

	private String attackType;
	private String defenderType;
	private float value;

	/**
	 * @param attackType
	 * @param defenderType
	 * @param value
	 */
	public Efficiency(String attackType, String defenderType, float value) {
		super();
		this.attackType = attackType;
		this.defenderType = defenderType;
		this.value = value;
	}
	

	public String getAttackType() {
		return attackType;
	}
	
	public String getDefenderType() {
		return defenderType;
	}
	
	public float getValue() {
		return value;
	}


	@Override
	public String toString() {
		return "Efficiency [attackType=" + attackType + ", defenderType=" + defenderType + ", value=" + value + "]";
	}
	
}
