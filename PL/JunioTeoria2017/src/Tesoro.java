
public class Tesoro extends Item implements Caramelos{
	
	int caramelos = 0;
	
	public Tesoro(String nombre, int caramelos){
		super(nombre);
		setCaramelos(caramelos);
		setActivo(true);
	}
	
	public void setCaramelos(int c){
		caramelos = Math.max(0, c);
		if (caramelos == 0) setActivo(false);
	}
	
	public int getCaramelos(){
		return caramelos;
	}
	
	@Override
	public void responde(Personaje p){
		if (!this.getActivo()){
			if (this.getCaramelos()>0) setActivo(true);
		}
		else { // Esta activo
			System.out.println(p.getNombre() + " encuentra el tesoro " + this.getNombre() + " y gana 1 caramelo");
			this.setCaramelos(this.getCaramelos()-1);
			p.setCaramelos(p.getCaramelos()+1);
			this.setActivo(false);
		}
	}
	
	public String toString(){
		return super.toString() + "\nTesoro - caramelos: " + getCaramelos();
	}

}
