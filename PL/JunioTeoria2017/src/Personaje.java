
public abstract class Personaje extends ElementoDeJuego implements Caramelos {
	
	private static final int VIDA = 4;
	private int caramelos;
	private int vida;
	

	public Personaje(String nombre, int caramelos){
		super(nombre);
		setCaramelos(caramelos);
		setVida(VIDA);
	}
	
	public void setCaramelos(int c){
		caramelos = c;
	}
	
	public int getCaramelos(){
		return caramelos;
	}
	
	public void setVida(int v){
		vida = Math.max(0,v);
	}
	
	public int getVida(){
		return vida;
	}
	
	public boolean estaVivo(){
		return getVida() > 0;
	}
	
	public String toString(){
		return super.toString() + "\nPersonaje " + getClass().getName() + 
				" - Esta Vivo: " + (estaVivo() ? "SI" : "NO") +
				" - caramelos: " + getCaramelos() + " - vida: " + getVida();
	}
	
	public void Interacciona(ElementoDeJuego e){
		if (e instanceof Personaje && ((Personaje)e).estaVivo()) InteraccionaConPersonaje((Personaje)e);
		else if (e instanceof Item) InteraccionaConItem((Item)e);
	}
	
	public abstract void InteraccionaConPersonaje(Personaje p);
	
	public void InteraccionaConItem(Item e){
			e.responde(this);	
	}
}
