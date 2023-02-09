
public class Main {
	public static void juego(ElementoJuego[] v) {
		for(int i = 0; i<v.length;i++) {
			if(v[i] instanceof Personaje) {
				if(i<v.length-1) ((Personaje)v[i]).interact(v[i+1]);
				else ((Personaje)v[i]).interact(v[0]);
			}
		}
	}
	public static void baraja(ElementoJuego[] v) {
		for(int i = 0; i<v.length;i++) {
			int rand = (int) (Math.random()*v.length-1);
			if(rand!=i) v[rand] = v[i];
		}
	}
	public static void muestraJuego(ElementoJuego[] v) {
		for(int i = 0; i<v.length;i++) {
			System.out.printf("\n %s",v[i].toString());
		}
	}
	public static void masCaramelos(ElementoJuego[] v) {
		int masCaramelos = 0;
		Integer pos = null;
		for(int i = 0; i<v.length; i++) {
			if(v[i] instanceof Caramelos) {
				if(((Caramelos)v[i]).getCaramelos()>masCaramelos) {
					masCaramelos = ((Caramelos)v[i]).getCaramelos();
					pos = i;
				}
			}
		}
		if(pos!=null) System.out.printf("\n El elemento que tiene más caramelos es : %s",v[pos].getName());
		else System.out.print("\nNo hay elementos con caramelos en el juego.");
	}
	public static void menor(ElementoJuego e1,ElementoJuego e2) {
		String[] orden = {"PersonajeBueno","PersonajeMalo","PersonajeMalisimo","Tesoro","Trampa"};
		Integer v1=null,v2=null;
		for(int i = 0; i<orden.length; i++) {
			if(e1.getClass().getName()==orden[i]) v1 = i;
		}
		for(int i = 0; i<orden.length; i++) {
			if(e2.getClass().getName()==orden[i]) v2 = i;
		}
		if(v1!=null && v2!=null) {
			if(v1<v2) System.out.print("\n e1 < e2");
			else if(v1==v2) System.out.print("\n e1 = e2");
			else System.out.print("\n e1 > e2");
		}
		else System.out.print("\n Algun elemento es de un tipo no valido.");
	}
	public static void main(String[] args) {
		ElementoJuego[] v = new ElementoJuego[50];
		for(int i = 0; i<v.length; i++) {
			int rand = (int) (Math.random()*2);
			if(rand%2==0) {
				rand = (int) (Math.random()*2);
				if(rand%2==0) v[i] = new Tesoro("Tesoro"+i,(int) (Math.random()*10));
				else v[i] = new Trampa("Trampa"+i,(int) (Math.random()*10));
			}
			else {
				rand = (int) (Math.random()*2);
				if(rand%2==0) v[i] = new PersonajeBueno("PersonajeB"+i,(int) (Math.random()*10)+1,(int) (Math.random()*10));
				else {
					rand = (int) (Math.random()*2);
					if(rand%2==0) v[i] = new PersonajeMalo("PersonajeM"+i,(int) (Math.random()*10)+1,(int) (Math.random()*10));
					else v[i] = new PersonajeMalisimo("PersonajeMALISIMO"+i,(int) (Math.random()*10)+1,(int) (Math.random()*10));
				}
			}
		}
		muestraJuego(v);
		System.out.print("\nBARAJADO");
		baraja(v);
		muestraJuego(v);
		juego(v);
		masCaramelos(v);
		menor(v[0],v[2]);
	}

}
