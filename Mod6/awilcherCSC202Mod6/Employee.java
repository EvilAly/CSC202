package awilcherCSC202Mod6;

import java.text.*;

public class Employee implements Comparable<Employee> {

	private String first;
	private double hours;
	private double payRate;
	private int birthYear;

	// constructors
	public Employee() {

	}

	public Employee(String n, double h, double p, int y) {
		this.first = n;
		this.hours = h;
		this.payRate = p;
		this.birthYear = y;
	}

	// methods
	public String toString() {
		DecimalFormat df = new DecimalFormat("##.##");
		return first + " worked " + hours + " hours at $" + df.format(payRate) + " per hour. They were born in " + birthYear + ".";
	}
	
	public int compareTo(Employee a) {
		if (this.first.compareTo(a.first) == 0) {
			if (this.birthYear > a.birthYear)
				return 1;
			else if (this.birthYear < a.birthYear)
				return -1;
			else
				return 0;
			
		} else 
			return (this.first.compareTo(a.first));
	}

	
	// getters and setters

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

}
