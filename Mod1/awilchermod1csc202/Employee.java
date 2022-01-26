
package awilchermod1csc202;

import java.text.NumberFormat;

public class Employee {
    
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {        
        this.name = name;
        this.salary = salary;
    }
    public String toStringF() {
    	return name + "|" + salary;
    }
    

     public String toString() {
    	NumberFormat nf = NumberFormat.getCurrencyInstance();
        return name + " has a salary of " + nf.format(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
    
}
