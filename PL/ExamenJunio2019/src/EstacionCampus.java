import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Formatter;
import java.util.Scanner;

public class EstacionCampus {

	public static void main(String[] args) throws Exception {
		VectorDinamicoRegistros v = lectura("RegistrosCampusGijon.csv");
		 String serfile = "SerializaVDRegistros.ser";
		 serializaVDRegistros(v,serfile);
		 String desserfile = serfile;
		 deserializaVDRegistrosyEscribe(desserfile);
	}
	 public static VectorDinamicoRegistros lectura(String filename) throws Exception {
		 VectorDinamicoRegistros v = new VectorDinamicoRegistros();
		 Scanner in = null;
		 Formatter out1 = null;
		 Formatter out2 = null;
		 try {
			 in = new Scanner(new FileInputStream(filename));
			 out1 = new Formatter("RegistrosCampus.txt");
			 out2 = new Formatter("ResumenCampus.txt");
			 double temptotal = 0, prepacum = 0,tempant = 15;
			 int cont = 0;
			 in.useDelimiter(";|\r\n");
			 out1.format("%s\t%s\t%s\t%s\n", in.next(),in.next(),in.next(),in.next());
			 out2.format("%s\t%s\n", "Temperatura Media","Precipitacion acumluada");
			 in.nextLine();
			 while(in.hasNext()) {
				 String instante= in.next();
				 double temp = in.nextDouble();
				 if(tempant>=temp+10 || tempant<=temp-10) {
					 String msg = String.format("Posible error en el valor del registro de la temperatura de las %s",instante);
					 throw new TempException(msg);
				 }
				 tempant = temp;
				 int prep = in.nextInt();
				 double presion=in.nextDouble();
				 temptotal += temp;
				 prepacum += prep;
				 if(presion>=1012)v.add(new Registro(instante,temp,prep,presion));
				 out1.format("%24s %20f %22d %17f\n", instante,temp,prep,presion);
				 cont++;
			 }
			 out2.format("%.2f\t%.2f",temptotal/cont,prepacum);
		 }
		 catch(Exception e){
			 e.printStackTrace();
			throw new Exception();
		 }finally {
			 if(in != null) in.close();
			 if(out1!=null) out1.close();
			 if(out2!=null) out2.close();
		 }
		 return v;
	 }
	 public static void serializaVDRegistros(VectorDinamicoRegistros v,String filename) throws Exception {
		 ObjectOutputStream out = null;
		 try {
			 out = new ObjectOutputStream(new FileOutputStream(filename));
			 out.writeObject(v);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 throw new Exception();
		 }
		 finally {
			 if(out!=null) out.close();
		 }
	 }
	 public static void deserializaVDRegistrosyEscribe(String filename) throws Exception{
		 ObjectInputStream in = null;
		 VectorDinamicoRegistros aux = new VectorDinamicoRegistros();
		 Formatter out = null;
		 try {
			 in = new ObjectInputStream(new FileInputStream(filename));
			 aux = (VectorDinamicoRegistros)in.readObject();
			 out = new Formatter("Anticiclonicos.csv");
			 for(int i = 0; i<aux.length();i++) {
				 out.format("%s;\n", aux.get(i).toString());
			 }
			 
		 }
		 catch(Exception e) {
			 throw new Exception();
		 }
		 finally {
			 if(in!=null) in.close();
			 if(out!=null) out.close();
		 }
	 }
}
