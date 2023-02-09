/**
 * Class that allows representing dynamic vectors of Strings
 * It includes operations like insert, remove, set, get, ...
 *
 */

public class DynamicVectorStrings extends DynamicVectorObjects{

	public DynamicVectorStrings(){
		
	}
	
	public DynamicVectorStrings(DynamicVectorStrings vDS){
		super(vDS);
	}
	
	public DynamicVectorStrings(int size){
		super(size);
	}
	
	public DynamicVectorStrings(String[] v){
		super((Object[])v);
	}
	
	@Override	
	public String get(int i){
		return (String)super.get(i);
	}

	
	
	// Other methods
	@Override
	public String [] vectorNormal(){ // returns a String []
		String [] temp = new String[this.length()];
		for (int i = 0; i<temp.length; i++)
			temp[i] = this.get(i);
		return temp;
	}


}




