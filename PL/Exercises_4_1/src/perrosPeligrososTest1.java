import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class perrosPeligrososTest1 {
	public static void main(String[] args) throws CPException {
		Scanner in = null;
		String fileName = "censoPerrosPeligrosos.txt";
		try {
			in = new Scanner(new FileInputStream(fileName));
			System.out.printf("%-33s%-10s%-7s%-25s%-3s\n","RAZA","TAMAÑO","CP","BARRIO","CANTIDAD");
			int grandes = 0, medianos = 0, pequeños = 0, cant = 0,line = 1;
			while(in.hasNext()){
				try {
					String Raza = in.next();
					System.out.printf("%-33s", Raza);
					String Tamaño = in.next();
					System.out.printf("%-10s", Tamaño);
					int cp = in.nextInt();
					if(cp>33999 || cp<33000) throw new CPException(line);
					System.out.printf("%-7d",cp);
					String Barrio = in.next();
					System.out.printf("%-25s",Barrio);
					if(Tamaño.equals("Grande")) {
						cant = in.nextInt();
						grandes += cant;
						System.out.printf("%-3d\n", cant);
					}
					else if(Tamaño.equals("Mediano")) {
						cant = in.nextInt();
						medianos += cant;
						System.out.printf("%-3d\n", cant);
					}
					else if(Tamaño.equals("Pequeño")) {
						cant = in.nextInt();
						pequeños += cant;
						System.out.printf("%-3d\n", cant);
					}
					line++;
				}
				catch(CPException c) {
					System.err.printf("\n%s \n", c.getMessage());
					in.nextLine();
				}
			}
			System.out.printf("\n Grandes: %d \t Medianos: %d \t Pequeños: %d\n", grandes,medianos,pequeños);
		} catch(IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (in!=null) in.close();
		}

	}
}
