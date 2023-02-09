package exercise2;


public class DynamicVectorEfficiency extends DynamicVectorObjects {



	public DynamicVectorEfficiency() {

	}

	public DynamicVectorEfficiency(DynamicVectorEfficiency vDE) {
		super(vDE);
	}

	public DynamicVectorEfficiency(int size) {
		super(size);
	}

	public DynamicVectorEfficiency(Efficiency[] v) {
		super((Object[]) v);
	}

	@Override
	public Efficiency get(int i) {
		return (Efficiency) super.get(i);
	}

	// Other methods
	@Override
	public Efficiency[] vectorNormal() { // returns a Character[] as the integers of vOI
		Efficiency[] temp = new Efficiency[this.length()];
		for (int i = 0; i < temp.length; i++)
			temp[i] = this.get(i);
		return temp;
	}

}
