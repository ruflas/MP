package exercise1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {

		try {
			String typeAttack = "Fire";
			String typeDefend = "Water";

			float e = getEfficiency(typeAttack, typeDefend);
			System.out.println(typeAttack + " vs " + typeDefend +" "+ e);
		} catch (Exception e1) {
			System.err.println(e1.getMessage());
		}

	}


	private static float getEfficiency(String typeAttacker, String typeDefender) throws PokemonTypeException {

		// load pokemon types
		Scanner in = null;
		boolean found = false;
		float value = 0;
		try {
			in = new Scanner(new FileInputStream("efficiency.csv"));
			in.useDelimiter(";|\r\n");

			// discarding the header
			in.nextLine();

			String type1, type2;

			while (in.hasNext() && !found) {
				type1 = in.next();
				type2 = in.next();
				value = in.nextFloat();
				if((value != 0)&&(value != 0.5)&&(value != 1)&&(value != 2))
					throw new PokemonTypeException(String.format("Wrong Multiplier in database: %s %s %.2f\n",type1,type2,value));

				if(type1.equals(typeAttacker) && type2.equals(typeDefender) )
					found = true;
			}
		} catch (FileNotFoundException e) {
			throw new PokemonTypeException("Error in Pokemon database: " + e.getMessage());
		}
		finally {
			if (in != null)
				in.close();
		}
		if(found)
			return value;
		else
			throw new PokemonTypeException("Unknown effectivity of "+typeAttacker + " vs " + typeDefender );
	}
}


