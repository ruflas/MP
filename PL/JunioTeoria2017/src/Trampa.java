
public class Trampa extends Item {
	
	int da�o;
	
	public Trampa(String nombre, int da�o){
		super(nombre);
		setDa�o(da�o);
	}
	
	public void setDa�o(int d){
		da�o = d;
	}
	
	public int getDa�o(){
		return da�o;
	}
	
	@Override
	public void responde(Personaje p){
		if (!this.getActivo()) setActivo(true);
		else{
			System.out.println(p.getNombre() + " cae en la trampa " + this.getNombre() + " y pierde " + getDa�o() + " puntos de vida ");
			p.setVida(p.getVida()+getDa�o());
			setActivo(false);
		}
	}
	
	public String toString(){
		return super.toString() + "\nTrampa - da�o: " + getDa�o();
	}

}
