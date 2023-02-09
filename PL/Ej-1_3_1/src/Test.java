/**
 * 
 * @author UO282978
 *
 */
public class Test {

	public static void main(String[] args) {
		//Creamos los empleados de ejemplo.
		CommissionEmployee employee = new CommissionEmployee( 
		         "Sue", "Jones", "222-22-2222", 10000, .06 );
		CommissionEmployee employee2 = new CommissionEmployee( 
		    	 "Maria", "Jones", "333-33-3333", 30000, .02 );
		CommissionEmployee employee3 = new CommissionEmployee( 
		 	     "Lucia", "Jones", "444-44-4444", 5000, .25 );
		BasePlusCommissionEmployee employee4 = 
		         new BasePlusCommissionEmployee( 
		         "Bob", "Lewis", "333-33-3333", 5000, .04, 300 );
		BasePlusCommissionEmployee employee5 = 
		    	 new BasePlusCommissionEmployee( 
		    	 "James", "Lewis", "444-44-4444", 8000, .02, 400 );
		BasePlusCommissionEmployee employee6 = 
		 	     new BasePlusCommissionEmployee( 
		 	     "Hardem", "Lewis", "666-66-6666", 3000, .25, 100 );
		//Creamos las dos listas de las clases CommissionEmployee y otra de BasePlusCommissionEmployee
		CommissionEmployee[] v1 = {employee,employee2,employee3};
		BasePlusCommissionEmployee[] v2 = {employee4,employee5,employee6};
		
		//Ordenamos las listas de menor a mayor earnings
		for(int i = 0; i<v1.length-1;i++) {
	    	  for(int j = i+1; j<v1.length;j++) {
	    		  CommissionEmployee aux = v1[i];
	    		  if(v1[j].earnings()<v1[i].earnings()) {
	    			  v1[i] = v1[j];
	    			  v1[j] = aux;
	    		  }
	    	  }
	      }
		for(int i = 0; i<v2.length-1;i++) {
	    	  for(int j = i+1; j<v2.length;j++) {
	    		  BasePlusCommissionEmployee aux = v2[i];
	    		  if(v2[j].earnings()<v2[i].earnings()) {
	    			  v2[i] = v2[j];
	    			  v2[j] = aux;
	    		  }
	    	  }
	      }
		
		//Mostramos por consola los empleados que mas ganan de cada lista.
		System.out.printf("\nEmpleado que mas gana (ComissionEmployee): \n%s\n", v1[v1.length-1]);
		System.out.printf("\nEmpleado que mas gana (BasePlusCE): \n%s\n", v2[v2.length-1]);
		System.out.println();
		
		//Aqui comparamos las dos listas e imprimimos de menor a mayor los empleados de ambas listas segun sus earnings
		int i = 0;
		int j = 0;
		int aux = 0;
		while(i<v1.length) {
			while(j<v2.length) {
				aux = j;
				if(v1[i].earnings()==v2[j].earnings()) System.out.print("\n"+v1[i]+"\n"+v2[i]+"\n");
				else if(v1[i].earnings()>v2[j].earnings()) System.out.print("\n"+v2[j]+"\n");
				else {
					System.out.print("\n"+v1[i]+"\n");
					j=v2.length+1;
					aux+=1;
				}
				j++;
			}
			if(j==v2.length && i<v1.length) {
				System.out.print("\n"+v1[i]+"\n");
				aux = i+1;
			}
			j = aux;
			i++;
		}
	}

}
