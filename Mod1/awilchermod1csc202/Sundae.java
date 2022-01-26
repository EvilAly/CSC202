package awilchermod1csc202;

import java.text.DecimalFormat;

public class Sundae extends IceCream {

	// fields
	protected String flavor;
	protected double costPerTopping;

	// empty constructor
	public Sundae() {

	}

	// full constructor
	public Sundae(String n, double scoop, int num, String flav, double top) {
		super(n, scoop, num);
		this.flavor = flav;
		this.costPerTopping = top;
	}

	// toString method
	public String toString() {

		DecimalFormat df = new DecimalFormat("#.00");
		String ans = super.toString();
		return ans + "\n Topping: " + flavor + "   $" + df.format(costPerTopping) + " Total Cost:" + " " + " $"
				+ df.format(getCost());
	} // I didn't call the getCost() method to calculate the cost because it always
		// added the topping from the subclass
		// (just as in your sample output). I wanted to show the cost for the scoops
		// only and in the second line of the
		// output I wanted to have the total (ice-cream plus topping): see my output

	// getCost method
	public double getCost() {
		return ((numScoops * costPerScoop) + costPerTopping);
	}

	// getters and setters
	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public double getCostPerTopping() {
		return costPerTopping;
	}

	public void setCostPerTopping(double costPerTopping) {
		this.costPerTopping = costPerTopping;
	}

}// end class
