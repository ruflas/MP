import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Examiner {

	public static void main(String[] args) {
		ArrayList<Nation> a = new ArrayList<Nation>();
		creaPreguntas(a);
		creaPruebas(3,a);
	}
	public static void creaPruebas(int personas, ArrayList<Nation> a) {
		Formatter out = null;
		Scanner teclado = new Scanner(System.in);
		for(int i = 0; i<personas;i++) {
			try {
				int contC = 0, contP = 0;
				out = new Formatter("examen_"+i+".txt");
				for(int j = 0; j<a.size(); j++) {
					Nation n = a.get(j);
					boolean acierto = false;
					out.format("Capital Correcta: %s",n.getCapital());
					System.out.printf("¿Cuál es la capital de %s ?:\n",n.getName());
					String respuesta = teclado.next();
					out.format("\tCapital introducida: %s\n", respuesta);
					if(respuesta.equals(n.getCapital())) {
						acierto = true;
						contC++;
					}
					if(acierto) {
						acierto = false;
						out.format("Poblacion Correcta: %d\t",n.getPopulation());
						System.out.printf("¿Y su población?\n");
						Integer resp = null ;
						try{
							resp = teclado.nextInt();
						}
						catch(InputMismatchException ime) {
							System.err.print("\nerror_de_entrada\n");
							out.format("error_de_entrada");
						}
						out.format("Poblacion Introducida: %s\n", resp);
						if(resp!=null && resp==n.getPopulation()) contP++;
						else System.out.print("Respuesta Incorrecta :(");
					}
					else {
						System.out.print("Respuesta Incorrecta :(");
					}
				}
				out.format("\nHa acertado %d capitales y %d poblaciones.", contC,contP);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				if(out!=null) out.close();
			}
		}
		teclado.close();
	}
	public static void creaPreguntas(ArrayList<Nation> a) {
		Scanner in = null;
		String filename = "RightAnswers2.csv";
		try {
			in = new Scanner(new FileInputStream(filename));
			in.useDelimiter(";|\r\n");
			while(in.hasNext()) {
				String pais = in.next();
				String capital = in.next();
				int habitantes = in.nextInt();
				a.add(new Nation(pais,capital,habitantes));
				if(in.hasNextLine())in.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if(in!=null) in.close();
		}
	}
}
