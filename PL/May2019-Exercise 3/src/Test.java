public class Test {

	public static void main(String[] args) {
		// an array of nations is created
		Nation[] v = {
				new Nation("Spain",   "Madrid",  3200000),
				new Nation("France",  "Paris",   2200000),
				new Nation("Italy",   "Roma",    2800000),
				new Nation("Portugal","Lisbon",  500000)
		};

		// Show the array in the console
		System.out.println("Original nations:");
		showNations(v);

		// Serialize the array to the file "nations.bin"
		System.out.println("Serializing nations...");
		serializeNations(v,"nations.bin");


		// Create an array v2 and assign to it the deserialized nations from "nations.bin"
		System.out.println("Deserializing nations...");
		Nation[] v2  = deserializeNations("nations.bin");

		// Show the array v2 in the console
		System.out.println("Deserialized naciones:");
		showNations(v2);
	}

	/**
	 * Muestra por consola los objetos Nacion del array
	 * @param v - array de objetos Nacion
	 */
	private static void showNations(Nation[] v) {
		for(Nation n: v)
			System.out.println(n);
	}

	/**
	 * Deserializa el array de objetos Nacion almacenados en el fichero 
	 * @param nombre - nombre del fichero
	 * @return el array con los objetos Nacion deserializados
	 */
	private static Nation[] deserializeNations(String name) {
		// COMPLETE
		return null;
	}

	/**
	 * Serializa el array de objetos Nacion en el fichero especificado
	 * @param v - array de objetos Nacion a serializar
	 * @param nombre - nombre del fichero donde serializar el array de objetos Nacion
	 */
	private static void serializeNations(Nation[] v, String name) {
		// COMPLETE		
	}


}
