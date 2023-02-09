// Fig. 9.5: CommissionEmployeeTest.java
// CommissionEmployee class test program.
/**
 * 
 * @author UO282978
 *
 */

public class CommissionEmployeeTest 
{
   public static void main( String[] args ) 
   {
      // instantiate CommissionEmployee object
      CommissionEmployee employee = new CommissionEmployee( 
         "Sue", "Jones", "222-22-2222", 10000, .06 );
      CommissionEmployee employee2 = new CommissionEmployee( 
    	         "Maria", "Jones", "333-33-3333", 30000, .02 );
      CommissionEmployee employee3 = new CommissionEmployee( 
 	         "Lucia", "Jones", "444-44-4444", 5000, .25 );
      
      
      // get commission employee data
      System.out.println( 
         "Employee information obtained by get methods: \n" );
      System.out.printf( "%s %s\n", "First name is",
         employee.getFirstName() );
      System.out.printf( "%s %s\n", "Last name is", 
         employee.getLastName() );
      System.out.printf( "%s %s\n", "Social security number is", 
         employee.getSocialSecurityNumber() );
      System.out.printf( "%s %.2f\n", "Gross sales is", 
         employee.getGrossSales() );
      System.out.printf( "%s %.2f\n", "Commission rate is",
         employee.getCommissionRate() );

      employee.setGrossSales( 500 ); // set gross sales
      employee.setCommissionRate( .1 ); // set commission rate
      
      System.out.printf( "\n%s:\n\n%s\n", 
         "Updated employee information obtained by toString", employee );
      CommissionEmployee[] v = {employee,employee2,employee3};
      for(int i = 0; i<v.length-1;i++) {
    	  for(int j = i+1; j<v.length;j++) {
    		  CommissionEmployee aux = v[i];
    		  if(v[j].earnings()<v[i].earnings()) {
    			  v[i] = v[j];
    			  v[j] = aux;
    		  }
    	  }
      }
      System.out.printf("\nEmpleado que mas gana: \n%s\n", v[v.length-1]);
      System.out.println("\nLista de empleados menor a mayor: ");
      for(int i = 0; i<v.length; i++) {
    	  System.out.println(v[i]);
      }
   } // end main
} // end class CommissionEmployeeTest


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