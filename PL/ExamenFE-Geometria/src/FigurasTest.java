import java.io.FileInputStream;
import java.util.Scanner;

public class FigurasTest {
	public static void main(String[] args) throws Exception {
		VectorDinamicoFiguraGeometrica v;
		v= leeFichero("Datos.txt");
		leeFichero("Datos.txt");
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
		for(int i=0;i<w.length();i++) {
			System.out.println(w.get(i).toString());
		}
		
	}
	public static VectorDinamicoFiguraGeometrica leeFichero(String nombreFichero) {
		VectorDinamicoFiguraGeometrica v = new VectorDinamicoFiguraGeometrica();
		Scanner in = null;
		try {
			in = new Scanner(new FileInputStream(nombreFichero));
			in.useDelimiter(",");
			int line = 0;
			while(in.hasNext()) {
				int type = in.nextInt();
				if(type==0) v.add(new Circulo(in.nextInt()));
				else if(type==1) v.add(new CirculoConCentro(in.nextInt(),in.nextInt(),in.nextInt()));
				else if(type==2) v.add(new Triangulo(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt()));
				else throw new GeometricTypeException(line);
				in.nextLine();
				line++;
			}
		}
		catch(Exception e) {
			
		}
		finally {
			if(in!=null) in.close();
		}
		return v;
	}
	public static void escribeFichero(String nombreFichero, VectorDinamicoFiguraGeometrica v) {
		
	}
	public static void serializaVDFiguraGeometrica(VectorDinamicoFiguraGeometrica v1,String fichero) {
		
	}
	public static VectorDinamicoFiguraGeometrica deserializaVDFiguraGeomtrica(String fichero_in) {
		VectorDinamicoFiguraGeometrica v = new VectorDinamicoFiguraGeometrica();
		return v;
	}
}
