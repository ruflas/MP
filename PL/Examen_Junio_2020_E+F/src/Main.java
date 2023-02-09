import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		procesaFichero("Calidad_aire_Gijón.csv");
		registrosATexto("valores_excesivos.txt");
	}

	private static void procesaFichero(String filename) throws Exception {
		Scanner in = null;
		VectorDinamicoRegistro vR = new VectorDinamicoRegistro();
		ObjectOutputStream out1 = null;
		ObjectOutputStream out2 = null;
		ObjectOutputStream out3 = null;
		try {
			in = new Scanner(new FileInputStream(filename));
			int line = 0;
			in.useDelimiter(";|,|\r\n");
			out1 = new ObjectOutputStream(new FileOutputStream("pm10.ser"));
			out2 = new ObjectOutputStream(new FileOutputStream("pm25.ser"));
			out3 = new ObjectOutputStream(new FileOutputStream("no2.ser"));
			in.nextLine();
			while(in.hasNext()) {
				try {
					String fecha = in.next();
					String zona = in.next();
					int pm10 = in.nextInt();
					int pm25 = in.nextInt();
					int no2 = in.nextInt();
					System.out.printf("%s %s %d %d %d %d\n", fecha,zona,pm10,pm25,no2,line);
					if(fecha == null) System.err.printf("Fecha null in line %d\n", line);
					if(zona == null) System.err.printf("Zona null in line %d\n", line);
					if(pm10>50 || pm25>25 || no2>50) {
						Registro r = null;
						if(pm10>50) {
							r = new Registro(fecha,zona,"PM10",pm10);
							out1.writeObject(r);
						}
						if(pm25>25) {
							r = new Registro(fecha,zona,"PM25",pm25);
							out2.writeObject(r);
						}
						if(no2>50) {
							r = new Registro(fecha,zona,"NO2",no2);
							out3.writeObject(r);
						}
						if(r!=null) vR.add(r);
					}
				}
				catch(InputMismatchException e) {
					System.err.printf("Algun valor de la linea %d tiene como ultimos tres valores un no entero.\n",line);
				}
				in.nextLine();
				line++;
			}
		}
		catch(Exception e) {
			throw new Exception("Ha ocurrido otra excepcion");
		}
		finally {
			if (in != null)
				in.close();
			if (out1 != null)
				out1.close();
			if (out2 != null)
				out2.close();
			if (out3 != null)
				out3.close();
		}
	}

	private static void registrosATexto(String filename) throws Exception {
		ObjectInputStream in = null;
		Registro aux = null;
		Formatter out = null;
		try {
			out = new Formatter(filename);
			out.format("%-20s %15s %10s %10s\n","Fecha","Zona","Cont.","Valor");
			in = new ObjectInputStream(new FileInputStream("pm10.ser"));
			aux = (Registro)in.readObject();
			out.format("%s\n",aux.toString());
			in = new ObjectInputStream(new FileInputStream("pm25.ser"));
			aux = (Registro)in.readObject();
			out.format("%s\n",aux.toString());
			in = new ObjectInputStream(new FileInputStream("no2.ser"));
			aux = (Registro)in.readObject();
			out.format("%s\n",aux.toString());
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}
}
