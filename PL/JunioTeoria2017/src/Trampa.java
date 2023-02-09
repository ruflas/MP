
public class Trampa extends Item {
	
	int daño;
	
	public Trampa(String nombre, int daño){
		super(nombre);
		setDaño(daño);
	}
	
	public void setDaño(int d){
		daño = d;
	}
	
	public int getDaño(){
		return daño;
	}
	
	@Override
	public void responde(Personaje p){
		if (!this.getActivo()) setActivo(true);
		else{
			System.out.println(p.getNombre() + " cae en la trampa " + this.getNombre() + " y pierde " + getDaño() + " puntos de vida ");
			p.setVida(p.getVida()+getDaño());
			setActivo(false);
		}
	}
	
	public String toString(){
		return super.toString() + "\nTrampa - daño: " + getDaño();
	}

}
