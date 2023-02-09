package cartaRestaurante;

public class Main {

	public static void main(String[] args) {
		Producto[] vP = {
				new BebidaAlcohol("botella de sidra", 3, 750, .12, 1.25) // bebida alcoholica: botella de sidra, 3 euros, 750 mililitros, 12% alcohol, 1.25 euros media ración
				, new BebidaOtros("agua grande", 2.5, 1000) // otra bebida: agua grande, 2.5 euros, 1000 mililitros
				, new Entrante("croquetas de jamón", 12.00, "18/05/2022", 8, 10.50) // entrante: croquetas, 8 unidades, 12 euros racion, 10.50 euros media ración, fecha de entrada en carta 18/5/22
				, new Principal("fabada", 18, "1/01/1901", "ensalada") // principal: fabada, 18 euros racion, fecha de entrada en carta 1/1/1901, guarnición ensalada
				, new Postre("arroz con leche", 6, "1/01/1901", false) // postre: arroz con leche, 6 euros racion, fecha de entrada en carta 1/1/1901, no es casero
		};

		muestraplatoMasCaro(vP);
		System.out.println("\nMedias raciones:\n");
		muestraPreciosMediasRaciones(vP);
		System.out.println("\nOrdenando:\n");
		ordenavP(vP);
		for(Producto p: vP) System.out.println(p);
	}


	private static void ordenavP(Producto[] vP) {

		for(int x = 0; x < vP.length - 1; x++)
			for(int y = x+1; y < vP.length; y++)
				if( (vP[x] instanceof Bebida) && (vP[y] instanceof Plato)) {
					Producto aux = vP[x];
					vP[x] = vP[y];
					vP[y] = aux;
				}
	}

	private static void muestraPreciosMediasRaciones(Producto[] vP) {
		for(Producto p: vP)
			if (p instanceof MediaRacion)
				System.out.printf("%s %.2f €\n", p.getNombre(), ((MediaRacion)p).getPrecioMediaRacion());
	}

	private static void muestraplatoMasCaro(Producto[] vP) {
		Producto max = null;

		for(Producto p: vP)
			if ((p instanceof Plato) && (max == null || p.getPrecio() > max .getPrecio()))
				max = p;


		System.out.println("Plato más caro: "+ (max==null?"no hay platos":max));

	}


}
