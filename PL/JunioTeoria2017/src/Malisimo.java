
public class Malisimo extends Malo {
	
	public Malisimo(String nombre, int caramelos){
		super(nombre, caramelos);
	}
	
	@Override
	public int getDaño(){
		return 2 * super.getDaño();
	}
	
	@Override
	public boolean EsEnemigo(Personaje p){
		return true;
	}

}
