
public class JuegoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bueno b1 = new Bueno("Pepe Bueno", 5);
		Bueno b2 = new Bueno("Juan Bueno", 3);
		Malo m1 = new Malo("Luis Malo", 4);
		Malo m2 = new Malo("Ana Malo", 5);
		Malisimo ml1 = new Malisimo("Pablo Malisimo", 3);
		Malisimo ml2 = new Malisimo("Javi Malisimo", 2);
		
		Tesoro t1 = new Tesoro("Tesoro 1", 5);
		Tesoro t2 = new Tesoro("Tesoro 2", 4);
		
		Trampa tp1 = new Trampa("Trampa 1", 2);
		Trampa tp2 = new Trampa("Trampa 2", 3);
		
		ElementoDeJuego [] v = {b1, b2, m1, m2, ml1, ml2, t1, t2, tp1, tp2};
		
		/*
		muestra(v);
		
		baraja(v);
		
		muestra(v);
		
		juega(v);
		
		muestra(v);
		
		ordena(v);
		
		muestra(v); 
		*/
		
		juega(v,10); // juega 10 rondas
		
		masCaramelos(v);
		

	}
	
	public static void muestra(ElementoDeJuego [] v){
		for (ElementoDeJuego e: v) System.out.println(e);
	}
	
	public static void baraja(ElementoDeJuego [] v){
		for (int i = 0; i < v.length; i++){
			int j = Dado.tira(v.length)-1;
			ElementoDeJuego tmp = v[i];
			v[i] = v[j];
			v[j] = tmp;
		}
			
	}
	
	public static void juega(ElementoDeJuego [] v){
		for (int i = 0; i < v.length; i++)
			if ((v[i] instanceof Personaje) && ((Personaje)v[i]).estaVivo()) ((Personaje)v[i]).Interacciona(v[(i+1) % v.length]);
	}
	
	public static void ordena(ElementoDeJuego [] v){
		for (int i = 0; i<v.length-1; i++)
			for(int j = i+1; j<v.length; j++)
				if (menor(v[j],v[i])) {
					ElementoDeJuego tmp = v[i];
					v[i] = v[j];
					v[j] = tmp;
				}
	}
	
	public static boolean menor(ElementoDeJuego e1, ElementoDeJuego e2){
		String [] v = {"Bueno","Malo","Malisimo","Tesoro","Trampa"};
		int x1 = -1;
		int x2 = -1;
		int i = 0;
		while (i<v.length && (x1 == -1 || x2 == -1)){
			if (e1.getClass().getName().equals(v[i])) x1 = i;
			if (e2.getClass().getName().equals(v[i])) x2 = i;
			i++;
		}
		return x1 < x2;
	}
	
	public static void juega(ElementoDeJuego [] v, int rondas){
		System.out.println("Juega " + rondas + " rondas: ");
		for (int i = 1; i<=rondas; i++){
			System.out.println("Ronda " + i + ": ");
			juega(v);
			baraja(v);
		}
	}
	
	public static void masCaramelos(ElementoDeJuego [] v){
		int k = -1;
		int mas = 0;
		for (int i = 0; i< v.length; i++)
			if (v[i] instanceof Caramelos){
				Caramelos c = (Caramelos)v[i];
				if (c.getCaramelos() > mas){
					mas = c.getCaramelos();
					k=i;
				}
			}
		if (k == -1) System.out.println("\nNo hay elementos con caramelos");
		else System.out.println("\nEl que tiene más caramelos es: " + v[k]);
	}

}
