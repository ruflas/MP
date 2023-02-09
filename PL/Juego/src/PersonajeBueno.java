
public class PersonajeBueno extends Personaje{
	public PersonajeBueno(String name,int vida,int caramelos) {
		super(name,vida,caramelos);
	}
	
	@Override
	public void interact(Personaje p) {
		if(p.isAlive()) {
			this.setCaramelos(this.getCaramelos()-1);
			p.setCaramelos(p.getCaramelos()+1);
		}
	}
}
