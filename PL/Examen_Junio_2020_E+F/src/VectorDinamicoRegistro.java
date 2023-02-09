
public class VectorDinamicoRegistro extends VectorDinamicoObjects{

	public VectorDinamicoRegistro(){
		
	}
	
	public VectorDinamicoRegistro(VectorDinamicoRegistro vDE){
		super(vDE);
	}
	
	public VectorDinamicoRegistro(int size){
		super(size);
	}
	
	public VectorDinamicoRegistro(Registro[] v){
		super((Object[])v);
	}
	
	@Override	
	public Registro get(int i){
		return (Registro)super.get(i);
	}
	
	
	// Otros m�todos
	@Override
	public Registro [] vectorNormal(){ // devuelve un Registro [] con los registros del din�mico
		Registro [] temp = new Registro[this.length()];
		for (int i = 0; i<temp.length; i++)
			temp[i] = this.get(i);
		return temp;
	}

}




