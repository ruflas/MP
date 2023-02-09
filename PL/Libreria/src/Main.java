import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Articulos[] vA = new Articulos[10];
		for(int i = 0; i<vA.length; i++) {
			int rand = (int) (Math.random()*2);
			if(rand%2==0) vA[i] = new LibroPapel("Libro"+i,"autor"+i,"editorial"+i,99999999,i+1990,i,3);
			else {
				rand = (int) (Math.random()*2);
				if(rand%2==0) vA[i] = new LibroDigital("LibroD"+i,"autor"+i,"editorial"+i,99999999,i+1990,i,3);
				else {
					rand = (int) (Math.random()*2);
					if(rand%2==0) vA[i] = new LibroDigital("LibroD"+i,"autor"+i,"editorial"+i,99999999,i+1990,i,3,new CertificadoCalidad("entidad"+1,1990));
					else {
						rand = (int) (Math.random()*2);
						
						if(rand%2==0) {
							ArrayList<Cancion> canciones = new ArrayList();
							canciones.add(new Cancion("Cancion1","Artista"+i));
							canciones.add(new Cancion("Cancion2","Artista"+i));
							vA[i] = new Disco("Disco"+i,"Artista"+i,1990+i,10,100,canciones);
						}
						else {
							ArrayList<String> actores = new ArrayList();
							actores.add("Julian");
							actores.add("xd");
							vA[i] = new Pelicula("Pelicula"+i,"director"+i,1990,10,1000,actores,120);
						}
					}
				}
			}
			System.out.print(vA[i]);
		}
	}

}
