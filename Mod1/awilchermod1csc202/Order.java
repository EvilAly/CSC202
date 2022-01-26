
package awilchermod1csc202;

import java.util.Collections;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Order {

	// instance variable
	public static final double TAX_RATE = 0.065; // I chose 6.5% as a tax rate
	private ArrayList<Dessert> desserts; // arraylist as field
	private Customer cust;

	// empty constructor
	public Order() {
		desserts = new ArrayList<>();
	}

	public Order(Customer c) {
		cust = c;
		desserts = new ArrayList<>();
	}

	public Order(ArrayList<Dessert> d, Customer c) {
		desserts = d;
		cust = c;
	}

	// clear method - clearing the arraylist
	public void clear() {
		desserts.clear();
	}

	// toString method
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();

		String receipt = "The customer is " + cust.toString() + "\n";
		for (int i = 0; i < desserts.size(); i++) {
			receipt = receipt + desserts.get(i).toString() + "\n";
		}

		receipt = receipt + "      Number of Items: " + getDesserts().size() + "\n";
		receipt = receipt + "      Total cost: " + nf.format(totalCost()) + "\n";
		receipt = receipt + "      Total tax: " + nf.format(totalTax()) + "\n";
		receipt = receipt + "      Cost + Tax: " + nf.format((totalCost() + totalTax()));

		return receipt;

	}

	public void sortDesserts() {
		//inward loop
		for (int out=desserts.size()-1; out>1; out--) {
			//outward loop
			for (int in=0; in<out; in++) {
				//assign each to variable
				Dessert one = desserts.get(in);
				Dessert two = desserts.get(in+1);
				//get names for comparison
				String name1 = one.getName();
				String name2 = two.getName();
				//compare and switch if needed
				if (name2.compareTo(name1) < 1) {
					desserts.set(in, two);
					desserts.set(in+1, one);
				}
			}
		}
	}

	public void enterItem(Candy candy) {
		this.desserts.add(candy);
	}

	public void enterItem(IceCream ic) {
		this.desserts.add(ic);
	}

	public void enterItem(Cake cake) {
		this.desserts.add(cake);
	}

	public void enterItem(Cookie cookie) {
		this.desserts.add(cookie);
	}

	public void enterItem(Sundae sundae) {
		this.desserts.add(sundae);
	}

	// totalCost method
	public double totalCost() {
		double cost = 0;
		for (int i = 0; i < desserts.size(); i++) {
			cost = cost + desserts.get(i).getCost();
		}
		return cost;
	}

	// totalTax method
	public double totalTax() {
		return totalCost() * 0.065;
	}

	// getter and setter for arraylist
	/**
	 * @return the desserts
	 */
	public ArrayList<Dessert> getDesserts() {
		return desserts;
	}

	/**
	 * @param desserts the desserts to set
	 */
	public void setDesserts(ArrayList<Dessert> desserts) {
		this.desserts = desserts;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

}// end class
