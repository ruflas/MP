import java.io.FileInputStream;
import java.io.FileOutputStream;
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
			System.out.println("\nPokemons read:");
			showPokemons(v);
			serialize(v, "icePokemons.ser");
			
			v2 = deserialize("icePokemons.ser");
			System.out.println("Pokemons deserialized:");
			showPokemons(v2);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void serialize(DynamicVectorPokemons v, String filename) throws Exception {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(filename));
			for(int i = 0; i<v.length();i++) {
				out.writeObject(v.get(i));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Excepción en serializacion:" + e.getMessage() + "\n ");
		}
		finally {
			if(out!=null) out.close();
		}
		
	}

	public static DynamicVectorPokemons deserialize(String filename) throws Exception {
		Pokemon d = null;
		DynamicVectorPokemons vP = new DynamicVectorPokemons();
		ObjectInputStream input = null;
		Formatter out = null;
		try {
			input = new ObjectInputStream(new FileInputStream(filename));
			out = new Formatter("DefensiveIcePokemons.csv");
			d = (Pokemon)input.readObject();
			vP.add(d);
			out.format("%s", d);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Excepción en deserializacion:" + e.getMessage() + "\n ");
		}
		finally {
			if(input!=null) input.close();
			if(out!=null)	out.close();
		}
		return vP;
	}

	public static void showPokemons(DynamicVectorPokemons v) {
		for(int i = 0; i<v.length();i++) {
			System.out.print(v.get(i).toString()+"\n");
		}
		
	}

	public static DynamicVectorPokemons readDefensivePokemons(String filename, String type) throws Exception {
		DynamicVectorPokemons d = new DynamicVectorPokemons();
		Scanner in = null;
		int leidosc = 0;
		int ctipo = 0;
		try {
			in = new Scanner(new FileInputStream(filename));
			int line = 0;
			in.useDelimiter(";|\r\n");
			in.nextLine();
			while(in.hasNext()) {
				String name = in.next();
				int card_type = in.nextInt();
				String type2 = "";
				if(card_type == 2) {
					type2 = in.next();
				}
				String type1 = in.next();
				int attack = in.nextInt();
				int defense = in.nextInt();
				System.out.printf("%s %d %s %s %d %d %d\n",name,card_type,type1,type2,attack,defense,line);
				if((type1.equals(type) || type2.equals(type)) && (attack<defense) ) d.add(new Pokemon(name,type1,type2,attack,defense));
				if(card_type!=1 && card_type!=2) {
					String msg = String.format("Encontrado Pokemon %s sin tipos en la linea %d",name,line);
					throw new PokemonTypeException(msg);
				}
				else leidosc++;
				if(type1.equals(type) || type2.equals(type)) ctipo++;
				line++;
				in.nextLine();
			}
		}
		catch(Exception e) {
			throw new Exception("Excepción en lectura:" + e.getMessage() + "\n "+ e.getStackTrace());
		}
		finally {
			if(in!=null) in.close();
			System.out.printf("\nSe han leído %d pokemons defensivos de tipo %s y %d pokemons en total ",ctipo,type,leidosc);
		}
		return d;
	}
}
