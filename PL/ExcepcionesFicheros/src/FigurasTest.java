import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Formatter;
import java.util.Scanner;

public class FigurasTest {
	public static void main(String[] args) throws Exception {
			VectorDinamicoFiguraGeometrica v = null;
			try {
				v= leeFichero("Datos.txt");
			} catch (Exception e) {
				throw e;
			}
			for(int i=0;i<v.length();i++) {
				System.out.println(v.get(i).toString());
			}
			escribeFichero("Salida.txt",v);
			
			
			VectorDinamicoFiguraGeometrica v2 = new VectorDinamicoFiguraGeometrica();
			v2.add(new Triangulo(1,2,3,4,5,6));
			v2.add(new Circulo(7));
			v2.add(new CirculoConCentro(8,9,10));
			
			serializaVDFiguraGeometrica(v2,"Serializado.ser");
			VectorDinamicoFiguraGeometrica w= deserializaVDFiguraGeomtrica("Serializado.ser");
			System.out.print("\n-------------------------------\n");
			for(int i=0;i<w.length();i++) {
				System.out.println(w.get(i).toString());
			}
			
	}

	public static VectorDinamicoFiguraGeometrica leeFichero(String nombreFichero) throws Exception {
		Scanner in = null;
		VectorDinamicoFiguraGeometrica v = new VectorDinamicoFiguraGeometrica();
		try {
			in = new Scanner(new FileInputStream(nombreFichero));
			in.useDelimiter(",|\r\n");
			while(in.hasNext()) {
				try {
					int id = in.nextInt();
					if(id == 0) v.add(new Circulo(in.nextInt()));
					else if(id == 1) v.add(new CirculoConCentro(in.nextInt(),in.nextInt(),in.nextInt()));
					else if(id == 2) v.add(new Triangulo(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt()));
					else throw new IdRangeException();
				}
				catch(IdRangeException i) {
					i.printStackTrace();
				}
				finally {
					if(in.hasNextLine()) in.nextLine();
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage()+" \n Fallo en lectura del archivo.");
		}
		finally {
			if(in!=null) in.close();
		}
		return v;
	}
	
	public static void escribeFichero(String nombreFichero, VectorDinamicoFiguraGeometrica v) {
		Formatter out = null;
		try {
			out = new Formatter(nombreFichero);
			int cont = 0;
			for(int i = 0; i<v.length(); i++) {
				if(v.get(i) instanceof Triangulo) {
					cont++;
					String msg = String.format("El triangulo %d:\t(%d,%d);\t(%d,%d);\t(%d,%d) y su perimetro es %-10.4f\n", cont,((Triangulo)v.get(i)).getV1().getX(),((Triangulo)v.get(i)).getV1().getY(),((Triangulo)v.get(i)).getV2().getX(),((Triangulo)v.get(i)).getV2().getY(),((Triangulo)v.get(i)).getV3().getX(),((Triangulo)v.get(i)).getV3().getY(),((Triangulo)v.get(i)).perimetro());
					out.format(msg);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if(out!=null)out.close();
		}
	}
	
	public static void serializaVDFiguraGeometrica(VectorDinamicoFiguraGeometrica v1,String fichero) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(fichero));
			out.writeObject(v1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(out!=null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static VectorDinamicoFiguraGeometrica deserializaVDFiguraGeomtrica(String fichero_in) {
		ObjectInputStream in = null;
		VectorDinamicoFiguraGeometrica v = new VectorDinamicoFiguraGeometrica();
		try {
			in = new ObjectInputStream(new FileInputStream(fichero_in));
			v = (VectorDinamicoFiguraGeometrica)in.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return v;
	}
}



