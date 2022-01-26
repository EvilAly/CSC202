
package awilchermod1csc202;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Candy extends Dessert {

	// fields should be weight and pricePerPound;
	protected double weight;
	protected double pricePerPound;

	// no argument and full constructors
	public Candy() {
		super();
	}

	public Candy(String s, double w, double p) {
		super(s);
		this.weight = w;
		this.pricePerPound = p;
	}

	// toString method
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		DecimalFormat df = new DecimalFormat("#.00");
		String ans = super.toString();
		return ans + " -- " + weight + "lbs " + " @ " + " $" + df.format(pricePerPound) + "  Cost:" + " $"
				+ df.format(getCost());
	}

	public double getCost() {
		return (weight * pricePerPound);
	}

	// add your getters and setters

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPricePerPound() {
		return pricePerPound;
	}

	public void setPricePerPound(double pricePerPound) {
		this.pricePerPound = pricePerPound;
	}

}// end class
