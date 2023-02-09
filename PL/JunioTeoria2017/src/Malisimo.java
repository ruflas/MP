
public class Malisimo extends Malo {
	
	public Malisimo(String nombre, int caramelos){
		super(nombre, caramelos);
	}
	
	@Override
	public int getDa�o(){
		return 2 * super.getDa�o();
	}
	
	@Override
	public boolean EsEnemigo(Personaje p){
		return true;
	}

}
