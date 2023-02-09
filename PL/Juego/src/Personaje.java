
public abstract class Personaje extends ElementoJuego implements Caramelos{
	protected int vida,caramelos;
	public Personaje(String name,int vida,int caramelos) {
		super(name);
		this.setVida(vida);
		this.setCaramelos(caramelos);
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getCaramelos() {
		return caramelos;
	}
	public void setCaramelos(int caramelos) {
		this.caramelos = caramelos;
	}
	public boolean isAlive() {
		return this.getVida()>0;
	}
	public void interact(Item i) {
		if(i.isEstado() && i instanceof Tesoro) {
			this.setCaramelos(this.getCaramelos()+1);
			((Tesoro) i).setCaramelos(((Tesoro) i).getCaramelos()-1);
			if(((Tesoro) i).getCaramelos()==0) ((Tesoro) i).setEstado(false);
			System.out.printf("\n%s -1 caramelos \n %s +1 caramelos", i.getName(),this.getName());
		}
		else if(i.isEstado() && i instanceof Trampa) {
			this.setVida(this.getVida()-((Trampa)i).getPuntos());
			i.setEstado(false);
			System.out.printf("\n%s -%d vida", this.getName(),((Trampa)i).getPuntos());
		}
		else if(!(i instanceof Tesoro) && i.isEstado()==false) i.setEstado(true);
		System.out.printf("\n%s ha interactuado con %s \n Activo(?): %b",this.getName(),i.getName(),i.isEstado());
	}
	
	public abstract void interact(Personaje p);
	
	public void interact(ElementoJuego l) {
		if(l instanceof Item) this.interact((Item) l);
		else if(l instanceof Personaje) this.interact((Personaje) l);
	}
	
	@Override
	public String toString() {
		return String.format("%s , Vida: %d , Caramelos: %d", super.toString(),this.getVida(),this.getCaramelos());
	}
}
