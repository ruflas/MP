
public class Bueno extends Personaje{
	
	public Bueno(String nombre, int caramelos){
		super(nombre, caramelos);
	}
	
	@Override
	public void InteraccionaConPersonaje(Personaje p){
		DaCaramelo(p);
	}
	
	private int DaCaramelo(Personaje p){
		System.out.println(this.getNombre() + " da caramelos a " + p.getNombre());
		if (this.getCaramelos()>0){
			this.setCaramelos(this.getCaramelos()-1);
			p.setCaramelos(p.getCaramelos()+1);
		}
		return getCaramelos();
	}
	
}
