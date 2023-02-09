
public class PersonajeMalisimo extends PersonajeMalo{
	private int daño = super.getDaño()*2;
	public PersonajeMalisimo(String name,int vida,int caramelos) {
		super(name,vida,caramelos);
		this.setDaño(daño);
	}
	
	@Override
	public void interact(Personaje p) {
		if(p.isAlive()) {
			p.setCaramelos(p.getCaramelos()-1);
			this.setCaramelos(this.getCaramelos()+1);
			p.setVida(p.getVida()-this.getDaño());
		}
	}
}
