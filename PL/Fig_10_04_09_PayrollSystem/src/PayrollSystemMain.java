// Fig. 10.9: PayrollSystemTest.java
// Employee hierarchy test program.

public class PayrollSystemMain 
{
	public static Employee earnsTheMost(Employee[] v) {
		if(v == null || v.length == 0) return null;
		Employee highest = v[0];
		for(int i = 1; i < v.length; i++) {
			if(highest.earnings()<v[i].earnings()) highest = v[i];
		}
		return highest;
	}
	
	public static void sortAscending(Employee[] v) {
		boolean check = true;
		if(v == null || v.length == 0) check = false ;
		if(check == true) {
			for(int i = 0; i < v.length-1; i++) {
				for(int j = i+1; j < v.length; j++) {
					Employee aux = v[i];
		    		  if(v[j].earnings()<v[i].earnings()) {
		    			  v[i] = v[j];
		    			  v[j] = aux;
		    		  }
				}
			}
		}
	}
	
	public static void changeCommissionRate(Employee[] v,double inc, int toWhom) {
		boolean check = true;
		if(v == null || v.length == 0) check = false ;
		if(check == true) {
			for(int i = 0; i < v.length; i++) {
				if(toWhom == 2){
					if(v[i] instanceof BasePlusCommissionEmployee) ((BasePlusCommissionEmployee)v[i]).setCommissionRate(((BasePlusCommissionEmployee)v[i]).getCommissionRate()+inc);
				}
				else if(toWhom == 1) {
					if(v[i] instanceof CommissionEmployee) ((CommissionEmployee)v[i]).setCommissionRate(((CommissionEmployee)v[i]).getCommissionRate()+inc);
				}
				else if(toWhom == 0) {
					//if(v[i] instanceof CommissionEmployee) ((CommissionEmployee)v[i]).setCommissionRate(((CommissionEmployee)v[i]).getCommissionRate()+inc);
					if(v[i].getClass().getSimpleName().equals("CommissionEmployee")) ((CommissionEmployee)v[i]).setCommissionRate(((CommissionEmployee)v[i]).getCommissionRate()+inc);
				}
				else {
					System.out.print("toWhom Incorrect Value.");
				}
			}
		}
	}
	
   public static void main( String[] args ) 
   {
      // create subclass objects
      SalariedEmployee salariedEmployee = 
         new SalariedEmployee( "John", "Smith", "111-11-1111", 800.00 );
      HourlyEmployee hourlyEmployee = 
         new HourlyEmployee( "Karen", "Price", "222-22-2222", 16.75, 40 );
      CommissionEmployee commissionEmployee = 
         new CommissionEmployee( 
         "Sue", "Jones", "333-33-3333", 10000, .06 );
      BasePlusCommissionEmployee basePlusCommissionEmployee = 
         new BasePlusCommissionEmployee( 
         "Bob", "Lewis", "444-44-4444", 5000, .04, 300 );

      System.out.println( "Employees processed individually:\n" );
      
      System.out.printf( "%s\n%s: $%,.2f\n\n", 
         salariedEmployee, "earned", salariedEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
         hourlyEmployee, "earned", hourlyEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
         commissionEmployee, "earned", commissionEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n", 
         basePlusCommissionEmployee, 
         "earned", basePlusCommissionEmployee.earnings() );

      // create four-element Employee array
      Employee[] employees = new Employee[ 4 ]; 

      // initialize array with Employees
      employees[ 0 ] = salariedEmployee;
      employees[ 1 ] = hourlyEmployee;
      employees[ 2 ] = commissionEmployee; 
      employees[ 3 ] = basePlusCommissionEmployee;
      System.out.println( "Employees processed polymorphically:\n" );
      
      // POLIMORFISM: generically process each element in array employees
      for ( Employee currentEmployee : employees ) 
      {
         System.out.println( currentEmployee ); // invokes toString

         // determine whether element is a BasePlusCommissionEmployee
         if ( currentEmployee instanceof BasePlusCommissionEmployee ) 
         {
            // downcast Employee reference to 
            // BasePlusCommissionEmployee reference
            //BasePlusCommissionEmployee employee = 
             //  ( BasePlusCommissionEmployee ) currentEmployee;

            ((BasePlusCommissionEmployee)currentEmployee).setBaseSalary( 1.10 * ((BasePlusCommissionEmployee) currentEmployee).getBaseSalary() );

            System.out.printf( 
               "new base salary with 10%% increase is: $%,.2f\n",
               ((BasePlusCommissionEmployee)currentEmployee).getBaseSalary() );
         } // end if

         System.out.printf( 
            "earned $%,.2f\n\n", currentEmployee.earnings() );
      } // end for 

      // get type name of each object in employees array
      for ( int j = 0; j < employees.length; j++ )
         System.out.printf( "Employee %d is a %s\n", j, 
            employees[ j ].getClass().getName() ); 
  Employee[] v = {salariedEmployee,hourlyEmployee,commissionEmployee,basePlusCommissionEmployee};
      
      System.out.printf("\nThe Employee that earns the most is %s", earnsTheMost(v).toString());
      sortAscending(v);
      for(int i = 0; i<v.length; i++) {
    	  	System.out.println();
			System.out.print(v[i]);
	}
   } // end main
} // end class PayrollSystemTest

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
