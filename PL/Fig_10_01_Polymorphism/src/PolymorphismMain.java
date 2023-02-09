// Fig. 10.1: PolymorphismTest.java
// Assigning superclass and subclass references to superclass and
// subclass variables.

public class PolymorphismMain  
{
	public static CommissionEmployee earnsTheMost(CommissionEmployee[] v) {
		if(v == null || v.length == 0) return null;
		CommissionEmployee highest = v[0];
		for(int i = 1; i < v.length; i++) {
			if(highest.earnings()<v[i].earnings()) highest = v[i];
		}
		return highest;
	}
	
	public static void sortAscending(CommissionEmployee[] v) {
		boolean check = true;
		if(v == null || v.length == 0) check = false ;
		if(check == true) {
			for(int i = 0; i < v.length-1; i++) {
				for(int j = i+1; j < v.length; j++) {
					CommissionEmployee aux = v[i];
		    		  if(v[j].earnings()<v[i].earnings()) {
		    			  v[i] = v[j];
		    			  v[j] = aux;
		    		  }
				}
			}
		}
	}
	
   public static void main( String[] args ) 
   {
      // assign superclass reference to superclass variable
      CommissionEmployee commissionEmployee = new CommissionEmployee( 
         "Sue", "Jones", "222-22-2222", 10000, .06 );                    

      // assign subclass reference to subclass variable
      BasePlusCommissionEmployee basePlusCommissionEmployee = 
         new BasePlusCommissionEmployee( 
         "Bob", "Lewis", "333-33-3333", 5000, .04, 300 );         

      // invoke toString on superclass object using superclass variable
      System.out.printf( "%s %s:\n\n%s\n\n", 
         "Call CommissionEmployee's toString with superclass reference ",
         "to superclass object", commissionEmployee.toString() );

      // invoke toString on subclass object using subclass variable      
      System.out.printf( "%s %s:\n\n%s\n\n", 
         "Call BasePlusCommissionEmployee's toString with subclass",
         "reference to subclass object", 
         basePlusCommissionEmployee.toString() );

      // POLIMORFISM: invoke toString on subclass object using superclass variable
      CommissionEmployee commissionEmployee2 = 
         basePlusCommissionEmployee; 
      System.out.printf( "%s %s:\n\n%s\n", 
         "Call BasePlusCommissionEmployee's toString with superclass",
         "reference to subclass object", commissionEmployee2.toString() );
      
      
      CommissionEmployee[] v = {commissionEmployee,basePlusCommissionEmployee,commissionEmployee2};
      
      System.out.printf("\nThe Employee that earns the most is %s", earnsTheMost(v).toString());
      sortAscending(v);
      for(int i = 0; i<v.length; i++) {
    	  	System.out.println();
			System.out.print(v[i]);
	}
     /*
      * Apartado d)
      * Las ventajas del uso de polimorfismo en este caso es que es una función reutilizable para ambos tipos de clase a diferencia de las primeras practicas.
      */
   } // end main
} // end class PolymorphismTest

/**************************************************************************
 * (C) Copyright 1992-2010 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
