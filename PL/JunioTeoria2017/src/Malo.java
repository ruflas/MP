
public class Malo extends Personaje {

	private static final int DA�O = 1;
	
	public Malo(String nombre, int caramelos){
		super(nombre,caramelos);
	}
	
	@Override
	public void InteraccionaConPersonaje(Personaje p){
		if (EsEnemigo(p) && estaVivo()) Ataca(p);
	}
	
	public int getDa�o(){
		return DA�O;
	}
	
	public boolean EsEnemigo(Personaje p){
		return p instanceof Bueno;
	}
	
	private void Ataca(Personaje p){
		System.out.println(this.getNombre() + " ataca a " + p.getNombre());
		p.setVida(p.getVida()-getDa�o());
		p.setCaramelos(p.getCaramelos()-1);
	}

}
