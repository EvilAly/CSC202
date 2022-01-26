package awilchermod1csc202;

import java.text.DecimalFormat;

public class Cake extends Dessert {
	
	private int numSlices;
	private double costPerSlice;
		
	public Cake() {
		
	}

	public Cake(String name, int numSlices, double costPerSlice) {
		super(name);
		this.numSlices = numSlices;
		this.costPerSlice = costPerSlice;
		getCost();
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		String ans = super.toString();
	    return ans + " -- " + numSlices + " slices @ $" + costPerSlice  
	               + " per slice    Cost: " + " $" + df.format(getCost());
	}
	
	public double getCost() {
		return numSlices * costPerSlice;
	}

	public int getNumSlices() {
		return numSlices;
	}

	public void setNumSlices(int numSlices) {
		this.numSlices = numSlices;
	}

	public double getCostPerSlice() {
		return costPerSlice;
	}

	public void setCostPerSlice(double costPerSlice) {
		this.costPerSlice = costPerSlice;
	}
	
	
	
	

}