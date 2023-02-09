

public class VectorDinamicoRegistros extends VectorDinamicoObjects{

	private static final long serialVersionUID = 1L;


	public VectorDinamicoRegistros(){
		
	}
	
	public VectorDinamicoRegistros(VectorDinamicoRegistros vDE){
		super(vDE);
	}
	
	public VectorDinamicoRegistros(int size){
		super(size);
	}
	
	public VectorDinamicoRegistros(Registro [] v){
		super((Object[])v);
	}
	
	@Override	
	public Registro get(int i){
		return (Registro)super.get(i);
	}
	
	
	// Otros metodos
	@Override
	public Registro [] vectorNormal(){ // devuelve un Personaje [] con los enteros de vDE
		Registro [] temp = new Registro[this.length()];
		for (int i = 0; i<temp.length; i++)
			temp[i] = this.get(i);
		return temp;
	}


}




