import java.util.Scanner;

public class Main {
	public static String randName() {
		String[] names = {"Antonio","Maria","Juan","Pedro","Lucia","Laura","David","Dani","Paula","Elena","Luis"};
		int rand = (int)(Math.random()*names.length);
		String name = names[rand];
		String[] lnames = {"García","González","Rodríguez","Fernández","López","Martínez","Sánchez","Pérez","Gómez","Martin","Jiménez","Ruiz"};
		rand = (int)(Math.random()*lnames.length);
		name = name+" " + lnames[rand];
		rand = (int)(Math.random()*lnames.length);
		name = name+" " + lnames[rand];
		return name;
	}
	public static String randDepart() {
		String[] departs = {"Informatica","Matematicas","Estadistica","Fisica","Ciencia"};
		int rand = (int)(Math.random()*departs.length);
		return departs[rand];
	}
	public static long randDNI() {
		return (long) (Math.random() * (999999999- 111111111) + 111111111);
	}
	
	public static double saldoTotal(Persona[] vU) {
		double saldoTotal = 0;
		for(int i = 0; i<vU.length; i++) {
			if(vU[i] instanceof Profesor) saldoTotal -=( ((Profesor) vU[i]).getSalario_anual() + ((Profesor) vU[i]).getCotizacion_anual());
			else {
				if(vU[i] instanceof Doctorado){
					saldoTotal += ((Doctorado) vU[i]).getTasas()-((Doctorado) vU[i]).getBeca();
				}
				else saldoTotal += ((Estudiante) vU[i]).getTasas();
			}
		}
		return saldoTotal;
	}
	
	public static int estudiantesMaster(Persona[] vU,String tipo) {
		int cont = 0;
		for(int i = 0; i<vU.length; i++) {
			if( vU[i] instanceof Master) {
				if( ((Master) vU[i]).getTipo().equals(tipo) ) cont++;
			}
		}
		return cont;
	}
	
	public static double cobroTotal(Persona[] vU) {
		double cobroTotal = 0;
		for(int i = 0; i<vU.length; i++) {
			if(vU[i] instanceof Asalariados) {
				Asalariados a = (Asalariados) vU[i];
				cobroTotal += a.getSalary();
			}
		}
		return cobroTotal;
	}
	
	public static void ordenaPorCobro(Persona[] vU) {
		for(int i = 0; i<vU.length; i++) {
			for(int j = i+1; j<vU.length;j++) {
				if(vU[i] instanceof Asalariados && vU[j] instanceof Asalariados) {
					if(((Asalariados)vU[j]).getSalary()>((Asalariados)vU[i]).getSalary()) {
						Persona aux = vU[i];
						vU[i] = vU[j];
						vU[j] = aux;
					}
				}
				if(!(vU[i] instanceof Asalariados) && vU[j] instanceof Asalariados) {
					Persona aux = vU[i];
					vU[i] = vU[j];
					vU[j] = aux;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		System.out.print("Inserta el numero de empleados a generar: ");
		int tamaño = t.nextInt();
		Persona[] vU = new Persona[tamaño];
		for(int i = 0; i<vU.length; i++) {
			int rand = (int)(Math.random()*2);
			if(rand%2==0) {
				Profesor p = new Profesor(randName(),randDNI(),randDepart(),Math.random()*10000+12000,Math.random()*1000+2000);
				vU[i] = p;
			}
			else{
				rand = (int)(Math.random()*2);
				if(rand%2==0) {
					Grado g = new Grado(randName(),randDNI(),randDepart(),Math.random()*1300+200);
					vU[i] = g;
				}
				else {
					rand = (int)(Math.random()*2);
					if(rand%2==0) {
						Master m = new Master(randName(),randDNI(),randDepart(),Math.random()*2000+2000,Math.random()*1000);
						vU[i] = m;
					}
					else {
						Doctorado d = new Doctorado(randName(),randDNI(),randDepart(),Math.random()*300+200,Math.random()*600,Math.random()*5+5,"PD",Math.random()*100);
						vU[i] = d;
					}
				}
			}
			System.out.println(vU[i].toString());
		}
		System.out.printf("\n Saldo Total institución: $%.2f$",saldoTotal(vU) );
		String tipo = "Informatica";
		System.out.printf("\n Gente cursando Master %s : %d",tipo,estudiantesMaster(vU,tipo));
		System.out.printf("\n Cobro Total Asalariados: $%.2f$",cobroTotal(vU) );
		ordenaPorCobro(vU);
		for(int i = 0; i<vU.length; i++) {
			System.out.printf("\n %s",vU[i].toString());
			if(vU[i] instanceof Doctorado) System.out.printf("\n%s\n", ((Doctorado)vU[i]).getPrograma());
		}
		t.close();
	}
}
