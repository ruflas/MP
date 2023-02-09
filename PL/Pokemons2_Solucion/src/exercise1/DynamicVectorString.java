package exercise1;


public class DynamicVectorString extends DynamicVectorObjects {

	public DynamicVectorString() {

	}

	public DynamicVectorString(DynamicVectorString vDE) {
		super(vDE);
	}

	public DynamicVectorString(int size) {
		super(size);
	}

	public DynamicVectorString(String[] v) {
		super((Object[]) v);
	}

	@Override
	public String get(int i) {
		return (String) super.get(i);
	}

	// Other methods
	@Override
	public String[] vectorNormal() { // returns a Character[] as the integers of vOI
		String[] temp = new String[this.length()];
		for (int i = 0; i < temp.length; i++)
			temp[i] = this.get(i);
		return temp;
	}

}
