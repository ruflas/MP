import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		DynamicVectorPokemons v = null;
		DynamicVectorPokemons v2 = null;

		try {
			v = readDefensivePokemons("PokemonsMay.csv", "Ice");
			System.out.println("Pokemons read:");
			showPokemons(v);

			serialize(v, "icePokemons.ser");

			v2 = deserialize("icePokemons.ser");
			System.out.println("Pokemons deserialized:");
			showPokemons(v2);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Show in the console the pokemons from the vector
	 * 
	 * @param v vector of pokemons
	 */
	private static void showPokemons(DynamicVectorPokemons v) {
		for (Pokemon p : v.vectorNormal())
			System.out.println(p);
	}

	private static DynamicVectorPokemons readDefensivePokemons(String fileName, String type) throws Exception {
		DynamicVectorPokemons v = null;
		int totalPokemons = 0;
		int totalPokemonsType = 0;

		Scanner in = null;
		v = new DynamicVectorPokemons();
		try {
			in = new Scanner(new FileInputStream(fileName));
			// discarding the header
			in.nextLine();
			in.useDelimiter(";|\r\n");
			String name, type1, type2;
			int cardType, attack, defense;

			while (in.hasNext()) {
				try {
					name = in.next();
					cardType = in.nextInt();
					if (cardType == 0)
						throw new PokemonTypeException(
								String.format("Found Pokemon %s with erroneous number of types. Continuing.", name));
					type1 = in.next();
					if (cardType == 1)
						type2 = "-";
					else
						type2 = in.next();
					attack = in.nextInt();
					defense = in.nextInt();

					totalPokemons++;
					if ((type.equals(type1) || type.equals(type2)) && attack < defense) {
						v.add(new Pokemon(name, type1, type2, attack, defense));
						totalPokemonsType++;
					}
				} catch (PokemonTypeException e) {
					System.err.println(e.getMessage());
					in.nextLine();// discardind the rest of the line
				}

			}
		} catch (FileNotFoundException e) {
			throw new Exception("Exception in read " + e.getMessage());
		} finally {
			if (in != null)
				in.close();
		}

		System.out.printf("%d defensive %s pokemons and %d pokemons have been read in total\n", totalPokemonsType, type,
				totalPokemons);

		return v;
	}

	private static void serialize(DynamicVectorPokemons v, String fileName) throws Exception {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(v);
		} catch (IOException e) {
			throw new Exception("Exception in serialization: " + e.getMessage());
		} finally {
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					throw new Exception("Exception in serialization: " + e.getMessage());
				}
		}
	}

	private static DynamicVectorPokemons deserialize(String fileName) throws Exception {
		ObjectInputStream in = null;
		Formatter out = null;
		DynamicVectorPokemons v = null;

		try {
			in = new ObjectInputStream(new FileInputStream(fileName));
			v = (DynamicVectorPokemons) in.readObject();

			out = new Formatter("defensiveIcePokemons");
			for (Pokemon p : v.vectorNormal()) {
				out.format("%s;%s;%s;%s;%s\n", p.getName(), p.getType1(), p.getType2(), p.getAttack(),
						p.getDefence());
			}
		} catch (IOException e) {
			throw new Exception("Exception in serialization: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new Exception("Exception in serialization: " + e.getMessage());
		} finally {
			if (out != null)
				out.close();
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					throw new Exception("Exception in serialization: " + e.getMessage());
				}
		}
		return v;
	}

}
