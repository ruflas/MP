import java.io.FileInputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class csvMain {
	static final String FILE_NAME_IN1= "EmpresasGijón.csv" ;//Input1
	static final String FILE_NAME_OUT1= "EmpresasGijón.txt" ;//Output1
	static final String FILE_NAME_IN2= "EmpresasGijón.txt" ;//Input2
	static final String FILE_NAME_OUT2= "EmpresasGijónbis.csv" ;//Output2
    
	public static void main(String[] args) {
		try {
			readCSV(FILE_NAME_IN1,FILE_NAME_OUT1);
			System.out.println("First part of the task done");

			writeCSV(FILE_NAME_IN2,FILE_NAME_OUT2);
			System.out.println("Second part of the task done");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public static void readCSV(String fileNameIn, String fileNameOut) throws Exception
	{ 
		Scanner in = null;
		Formatter out = null;
		String fileName = FILE_NAME_IN1;
		String outputFileName = FILE_NAME_OUT1;
		try {
			in = new Scanner(new FileInputStream(fileName));
			in.useDelimiter(",|\r\n");
			out = new Formatter(outputFileName);
			out.format("%-14s%-13s%-9s%-42s%-8s\n","14","13","9","42","9");
			while(in.hasNext()){
				out.format("%-14s%13s%9s%42s%9s\n", in.next(), in.next(), in.next(), in.next(), in.next());	
			}
			
		} catch(IOException e) {
			throw new Exception(e.getMessage());
		} finally {
			if (in!=null) in.close();
			if (out !=null) out.close();
		}
	}
		
	public static void writeCSV(String fileNameIn, String fileNameInOut) throws Exception 	// to be completed 
	{
		Scanner in = null;
		Formatter out = null;
		String fileName = FILE_NAME_IN2;
		String outputFileName = FILE_NAME_OUT2;
		try {
			in = new Scanner(new FileInputStream(fileName));
			out = new Formatter(outputFileName);
			int[] tamaños = new int[5];
			tamaños[0] = in.nextInt();
			for(int i = 1; i<5; i++) {
				tamaños[i] = in.nextInt() + tamaños[i-1];
			}
			in.nextLine(); //Para saltar salto de linea del ultimo elemento.
			while(in.hasNextLine()){
				String s = in.nextLine();
				String s1 =treatBlanks(s.substring(0,tamaños[0]));
				String s2 =treatBlanks(s.substring(tamaños[0],tamaños[1]));
				String s3 =treatBlanks(s.substring(tamaños[1],tamaños[2]));
				String s4 =treatBlanks(s.substring(tamaños[2],tamaños[3]));
				String s5 =treatBlanks(s.substring(tamaños[3],tamaños[4]));
				out.format("%s;%s;%s;%s;%s\n", s1,s2,s3,s4,s5);
			}
			
		} catch(IOException e) {
			throw new Exception(e.getMessage());
		} finally {
			if (in!=null) in.close();
			if (out !=null) out.close();
		}
	}
	


	/**
	 * Removes blank spaces from a string. 
	 * The spaces consecutive and internal next to non blank characters are substituted by a '_'.
	 * This algorithm is coded using techniques based on automata theory
	 * @param s a string with blank spaces
	 * @return another string without blank spaces as prefix or sufix, and the internal ones
	 * are substituted by a '_'
	 */
	public static String treatBlanks(String s) { 
		String output= "";
		int state = 0;
		char c;
		for (int i=0; i<s.length(); i++) {
			c = s.charAt(i);
			switch (state) {
			case 0: if (c!=' '){
						output = output + c;
						state = 1;
					}
					break;
			case 1: if (c!=' ')
						output = output + c;
					else state = 2;
					break;
			case 2: if (c!=' ') {
						output = output + '_' + c;
						state = 1;
					}		
			}
		}	
		return output;
				
	}
		
}
