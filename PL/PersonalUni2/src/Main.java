
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
	public static String randServ() {
		String[] serv = {"Limpieza","Becario","Administrador","Mantenimiento"};
		int rand = (int)(Math.random()*serv.length);
		return serv[rand];
	}
	
	public static void departamentoPDI(Personal[] vP) {
		PDI mayor = null;
		int i = 0, j = i+1;
		while(i<vP.length) {
			if(vP[i] instanceof PDI) {
				mayor = (PDI) vP[i];
				while(j<vP.length) {
					if(vP[j] instanceof PDI && (vP[i].getSalario() > vP[j].getSalario())) mayor =(PDI) vP[j];
					j++;
				}
				i = vP.length;
			}
			else i++;
		}
		if(mayor!=null) System.out.printf("\nEl departamento del PDI que más gana es :  %s] \n", mayor.getDepartamento());
		else System.out.print("\n -\n");
	}
	
	public static double calculaDespido(Personal[] vP) {
		double coste = 0;
		for(int i = 0; i<vP.length; i++) {
			if(vP[i] instanceof PAS || (vP[i] instanceof PDI && (((PDI)vP[i]).isFuncionario()==false))){
				coste += vP[i].indemnizacion();
			}
		}
		return coste;
	}
	
	public static String mayorServicio(Personal[] vP) {
		String[] serv = {"Limpieza","Becario","Administrador","Mantenimiento"};
		int[] nempleados = new int[serv.length];
		for(int i = 0; i<nempleados.length; i++) {
			nempleados[i] = 0;
		}
		for(int i = 0; i<vP.length; i++) {
			if(vP[i] instanceof PAS) {
				for(int j = 0; j<serv.length; j++) {
					if(((PAS)vP[i]).getServicio().getName()==serv[j]) {
						nempleados[j] += 1;
					}
				}
			}
		}
		int mayor = 0;
		for(int i = 0; i<nempleados.length; i++) {
			if(nempleados[mayor]<nempleados[i]) mayor = i;
		}
		return serv[mayor];
	}
	
	public static void main(String[] args) {
		Personal[] vP = new Personal[10];
		for(int i = 0; i<vP.length; i++) {
			int rand = (int)(Math.random()*2);
			if(rand%2==0) {
				PAS p = new PAS(randName(),Math.random()*35,randServ(),Math.random()*1600);
				vP[i]=p;
			}
			else {
				rand = (int)(Math.random()*2);
				if(rand%2==0) {
					PDI p = new PDI(randName(),Math.random()*35,randDepart(),true);
					vP[i] = p;
				}
				else {
					PDI p = new PDI(randName(),Math.random()*35,randDepart(),false);
					vP[i] = p;
				}
			}
			System.out.print(vP[i]);
			System.out.print("\n-------------------\n");
		}
		departamentoPDI(vP);
		System.out.printf("\nCoste del despido de no funcionarios: %.2f$ \n",calculaDespido(vP));
		System.out.printf("\n Mayor Servicio: %s \n", mayorServicio(vP));
	}

}
