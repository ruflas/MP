
public class Main {
	public static String randName() {
		String[] names = {"Antonio","Maria","Juan","Pedro","Lucia","Laura","David","Dani","Paula","Elena","Luis"};
		int rand = (int)(Math.random()*names.length);
		String name = names[rand];
		String[] lnames = {"García","González","Rodríguez","Fernández","López","Martínez","Sánchez","Pérez","Gómez","Martin","Jiménez","Ruiz"};
		rand = (int)(Math.random()*lnames.length);
		name = name+" " + lnames[rand];
		rand = (int)(Math.random()*lnames.length);
		name = name+" " + lnames[rand];
		return name;
	}
	
	public static void jugadoresDefensivosOfensivos(Jugador[] vJ) {
		int contdef = 0, contof = 0;
		for(int i = 0; i<vJ.length;i++) {
			if(vJ[i] instanceof Ofensivo) contof++;
			else if(vJ[i] instanceof Defensivo) contdef++;
		}
		System.out.printf("Defensivos: %d, Ofensivos: %d", contdef,contof);
	}
	
	public static int balanceDeGolesEquipo(Jugador[] vJ) {
		int golM = 0, golE = 0;
		for(int i = 0; i<vJ.length; i++) {
			if(vJ[i] instanceof Ofensivo) golM += ((Ofensivo) vJ[i]).getGoles();
			else if(vJ[i] instanceof Porteros) golE += ((Porteros) vJ[i]).getGencajados();
		}
		return golM-golE;
	}
	
	public static Jugador jugadorCampoMaxRecuperaciones(Jugador[] vJ) {
		Jugador j = null;
		int x = 0;
		while(x<vJ.length) {
			if(vJ[x] instanceof Defensivo) {
				j = vJ[x];
				x=vJ.length;
			}
		}
		if(j!=null) {
			for(int i = 0; i<vJ.length; i++) {
				if(vJ[i] instanceof Defensivo && ((Defensivo)vJ[i]).getRecuperaciones()>((Defensivo)j).getRecuperaciones()) j= vJ[i];  
			}
		}
		return j;
	}
	
	public static void ordenaPrimeroProterosLuegoElResto(Jugador[] vJ) {
		for(int i = 0; i<vJ.length;i++) {
			for(int j = i+1;j<vJ.length;j++) {
				if(vJ[j] instanceof Porteros && !(vJ[i] instanceof Porteros)) {
					Jugador aux = vJ[j];
					vJ[j] = vJ[i];
					vJ[i] = aux;
				}
			}
		}
	}
	
	public static void imprimeVector(Jugador[] j) {
		for(int i = 0; i<j.length; i++) {
			System.out.printf("\n%s", j[i].toString());
		}
	}
	public static void main(String[] args) {
		Jugador[] vJ = new Jugador[11];
		for(int i = 0; i<vJ.length; i++) {
			int rand = (int) (Math.random()*2);
			if(rand%2==0) vJ[i] = new Porteros(randName(), (int)(Math.random()*99), (int)(Math.random()*95)+1,(int)(Math.random()*5)+1,(int)(Math.random()*5)+1);
			else {
				rand = (int) (Math.random()*2);
				if(rand%2==0) vJ[i] = new Defensa(randName(), (int)(Math.random()*99), (int)(Math.random()*95)+1,(int)(Math.random()*25)+1);
				else {
					rand = (int) (Math.random()*2);
					if(rand%2==0) vJ[i] = new Medios(randName(), (int)(Math.random()*99), (int)(Math.random()*95)+1,(int)(Math.random()*25)+1,(int)(Math.random()*25)+1,(int)(Math.random()*3)+1);
					else vJ[i] = new Delantero(randName(), (int)(Math.random()*99), (int)(Math.random()*95)+1,(int)(Math.random()*25)+1,(int)(Math.random()*3)+1);
				}
			}
		}
		imprimeVector(vJ);
		jugadoresDefensivosOfensivos(vJ);
		ordenaPrimeroProterosLuegoElResto(vJ);
		imprimeVector(vJ);
	}
}
