

public class DynamicVectorPokemons extends DynamicVectorObjects {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DynamicVectorPokemons() {

	}

	public DynamicVectorPokemons(DynamicVectorPokemons vDE) {
		super(vDE);
	}

	public DynamicVectorPokemons(int size) {
		super(size);
	}

	public DynamicVectorPokemons(Pokemon[] v) {
		super((Object[]) v);
	}

	@Override
	public Pokemon get(int i) {
		return (Pokemon) super.get(i);
	}

	// Other methods
	@Override
	public Pokemon[] vectorNormal() { // returns a Character[] as the integers of vOI
		Pokemon[] temp = new Pokemon[this.length()];
		for (int i = 0; i < temp.length; i++)
			temp[i] = this.get(i);
		return temp;
	}

}
