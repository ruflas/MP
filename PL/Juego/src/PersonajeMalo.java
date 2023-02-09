
public class PersonajeMalo extends Personaje{
	private int da�o = 2;
	public PersonajeMalo(String name,int vida,int caramelos) {
		super(name,vida,caramelos);
		this.setDa�o(da�o);
	}
	public int getDa�o() {
		return da�o;
	}
	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}
	@Override
	public void interact(Personaje p) {
		if(p.isAlive() && p instanceof PersonajeBueno) {
			p.setCaramelos(p.getCaramelos()-1);
			this.setCaramelos(this.getCaramelos()+1);
			p.setVida(p.getVida()-this.getDa�o());
		}
	}
	@Override
	public String toString() {
		return String.format("%s , Da�o: %d ", super.toString(),this.getDa�o());
	}
}
