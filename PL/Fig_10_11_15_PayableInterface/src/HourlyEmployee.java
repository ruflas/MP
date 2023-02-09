
public class HourlyEmployee extends Employee{
	private double hours,wage,salary;
	public HourlyEmployee(String first, String last, String ssn,double hours,double wage) {
		super(first, last, ssn);
		this.setHours(hours);
		this.setWage(wage);
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getSalary() {
		for(int i = 0; i<=this.getHours(); i++) {
			if(i<40) this.salary = this.getWage()*this.getHours();
			else this.salary += 1.5;
		}
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = this.getSalary();
	}

	@Override
	public double getPaymentAmount() {
		return this.getSalary();
	}
	
	@Override
	public String toString() {
		return String.format( "hourly employee: %s\n%s: $%,.2f", 
		         super.toString(), "salary", getSalary() );
	}

}
