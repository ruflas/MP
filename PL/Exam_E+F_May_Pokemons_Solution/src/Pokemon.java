import java.io.Serializable;

public class Pokemon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String type1;
	private String type2;
	private int attack;
	private int defence;
	
	/**
	 * @param name
	 * @param type1
	 * @param type2
	 * @param attack
	 * @param defence
	 */
	public Pokemon(String name, String type1, String type2, int attack, int defence) {

		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.attack = attack;
		this.defence = defence;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type1
	 */
	public String getType1() {
		return type1;
	}
	/**
	 * @param type1 the type1 to set
	 */
	public void setType1(String type1) {
		this.type1 = type1;
	}
	/**
	 * @return the type2
	 */
	public String getType2() {
		return type2;
	}
	/**
	 * @param type2 the type2 to set
	 */
	public void setType2(String type2) {
		this.type2 = type2;
	}
	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}
	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	/**
	 * @return the defence
	 */
	public int getDefence() {
		return defence;
	}
	/**
	 * @param defence the defence to set
	 */
	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	@Override
	public String toString() {
		return "Pokemon [" + (getName() != null ? "Name=" + getName() + ", " : "")
				+ (getType1() != null ? "Type1=" + getType1() + ", " : "")
				+ (getType2() != null ? "Type2=" + getType2() + ", " : "") + "Attack=" + getAttack()
				+ ", getdefence=" + getDefence() + "]";
	}

	
	
}
