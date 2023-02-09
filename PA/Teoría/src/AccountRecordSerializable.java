
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AccountRecordSerializable implements Serializable {
	private int account;
	private String firstName;
	private String lastName;
	private double balance;

	public AccountRecordSerializable(int account, String firstName, String lastName, double balance) {
		this.account = account;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return String.format("%d\t%s\t%s\t%f", account, firstName, lastName, balance);
	}

	public static void main(String[] args) {

		String filename = "clients.ser";
		// create new record
		AccountRecordSerializable record = new AccountRecordSerializable(1, "John", "Smith", 6351.08);
		System.out.format("Initial record:\n\t%s\n",record);
		
		
		// SERIALIZAR EL OBJETO: guardar el objeto en disco
		serialize(filename, record);

		
		AccountRecordSerializable record2 = deserialize(filename);
		System.out.format("Recovered record:\n\t%s\n",record2);
		
	}

	private static void serialize(String filename, AccountRecordSerializable record) {
		
		ObjectOutputStream out = null;



		try {
			// PASO 1: CREAR EL OBJETO QUE CONECTA CON EL FICHERO
			out = new ObjectOutputStream(new FileOutputStream(filename));

			// PASO 2: ESCRIBIR EL OBJETO EN DISCO
			out.writeObject(record);

		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			// PASO 3: CERRAR EL FICHERO
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	}

	private static AccountRecordSerializable deserialize(String filename) {

		ObjectInputStream input = null;
		AccountRecordSerializable aux = null;
		
		try {
			// 1 CREAR EL OBJETO FICHERO PARA LEER UN OBJETO DESDE EL DISCO
			input = new ObjectInputStream(new FileInputStream(filename));

			// 2 LEER EL OBJETO DEL FICHERO
			aux = (AccountRecordSerializable)input.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			// 3 CERRAR EL FICHERO
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return aux;
	}

}