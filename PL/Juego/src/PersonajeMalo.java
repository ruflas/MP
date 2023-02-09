
public class PersonajeMalo extends Personaje{
	private int daño = 2;
	public PersonajeMalo(String name,int vida,int caramelos) {
		super(name,vida,caramelos);
		this.setDaño(daño);
	}
	public int getDaño() {
		return daño;
	}
	public void setDaño(int daño) {
		this.daño = daño;
	}
	@Override
	public void interact(Personaje p) {
		if(p.isAlive() && p instanceof PersonajeBueno) {
			p.setCaramelos(p.getCaramelos()-1);
			this.setCaramelos(this.getCaramelos()+1);
			p.setVida(p.getVida()-this.getDaño());
		}
	}
	@Override
	public String toString() {
		return String.format("%s , Daño: %d ", super.toString(),this.getDaño());
	}
}
