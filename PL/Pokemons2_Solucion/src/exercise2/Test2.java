package exercise2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test2 {



	public static void main(String[] args) {
		try {
			DynamicVectorEfficiency v = loadBinary("serialized_efficiency.ser");
			show(v);

			String typeAttack = "Fire";
			String typeDefend = "Water";

			float e = getEfficiency(v, typeAttack, typeDefend);
			System.out.println(typeAttack + " vs " + typeDefend +" "+ e);
		} catch (Exception e1) {
			System.err.println(e1.getMessage());
		}

	}

	/**
	 * Utility method to show on console every object of the efficiency multipliers
	 * @param v - dynamic vector of Efficiency instances
	 */
	private static void show(DynamicVectorEfficiency v) {
		for(int x = 0; x < v.length(); x++)
			System.out.println(v.get(x));
	}

	/**
	 * Utility method to get the efficiency of a pokemon attack
	 * @param v - dynamic vector of Efficiency objects
	 * @param typeAttack - type of the attacker pokemon 
	 * @param typeDefend - type of the defender pokemon
	 * @return the multiplier of the attack
	 * @throws RuntimeException if the efficiency is unknown
	 */
	private static float getEfficiency(DynamicVectorEfficiency v, String typeAttack, String typeDefend) {
		for(int x = 0; x < v.length(); x++)
			if (v.get(x).getAttackType().contentEquals(typeAttack) && 
					v.get(x).getDefenderType().contentEquals(typeDefend))
				return v.get(x).getValue();

		throw new RuntimeException("Unknown Efficiency");
	}

	private static DynamicVectorEfficiency loadBinary(String fileName) throws Exception {
		ObjectInputStream in = null;
		DynamicVectorEfficiency  v = null;

		try {
			in = new ObjectInputStream (new FileInputStream(fileName));
			try {
				v = (DynamicVectorEfficiency) in.readObject();
			} catch (ClassNotFoundException e) {
				System.err.println(e.getMessage());
				throw new Exception(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			throw new Exception(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw new Exception(e.getMessage());
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
					throw new Exception(e.getMessage());
				}
		}

		return v;
	}
}


