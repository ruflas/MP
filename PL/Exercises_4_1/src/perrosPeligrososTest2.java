import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class perrosPeligrososTest2 {
	public static DynamicVectorStrings ordenaRaza(String fileName) {
		Scanner in = null;
		DynamicVectorStrings razasOrdenadas = new DynamicVectorStrings();
		try {
			in = new Scanner(new FileInputStream(fileName));
			while(in.hasNext()){
				String raza = in.next();
				in.nextLine();
				int i = 0;
				while(i<razasOrdenadas.length() && raza.compareTo(razasOrdenadas.get(i))>0) {
					i++;
				}
				if(i==razasOrdenadas.length() || raza.compareTo(razasOrdenadas.get(i))<0) razasOrdenadas.insert(i, raza);
			}
		}
		catch(IOException e) {
			System.err.println(e.getMessage());
		} finally {
		if (in!=null) in.close();
	}
		return razasOrdenadas;
	}
	public static void main(String[] args) {
		String fileName = "censoPerrosPeligrosos.txt";
		DynamicVectorStrings v =ordenaRaza(fileName);
		for(int i = 0; i<v.length(); i++) {
			System.out.println(v.get(i));
		}
	}

}
