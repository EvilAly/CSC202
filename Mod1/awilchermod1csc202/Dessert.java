
package awilchermod1csc202;

import java.text.*;


public abstract class Dessert implements Comparable<Dessert> {

    //instance variable Dessert name
    protected String name;

    // for currency output
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    //empty constructor
    public Dessert() {
    }

    //full constructor
    public Dessert(String n) {

        this.name = n;
    }

    //toString method
    public String toString() {
        return name;
    }

    //getCost method specified in each subclass- no body here since abstract
    public abstract double getCost();

    //compareTo method 
    public int compareTo(Dessert des) {
    	// you need to complete this - it is to compare desserts by name
    	return (this.getName().compareTo(des.getName()));
    }

    //getters and setters
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}//end class
