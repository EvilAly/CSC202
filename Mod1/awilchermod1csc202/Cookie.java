package awilchermod1csc202;

import java.text.DecimalFormat;

public class Cookie extends Dessert {
    
    //fields should be number and pricePerDz
	protected int number;
	protected double pricePerDz;
	
	//Need the empty and full constructor
	public Cookie() {
		super();
	}
	
	public Cookie(String n, int num, double price) {
		super(n);
		this.number = num;
		this.pricePerDz = price;
	}
	
        
    //toString method
    public String toString() {
   
    DecimalFormat df = new DecimalFormat("#.00");
    String ans = super.toString();
    return ans + " -- " + number + " @ " + " $" + pricePerDz 
               + "  Cost: " + " $" + df.format(getCost());
    }
    
    public double getCost() {
        return number * pricePerDz/12;
    }

    //generate your setters and getters
    public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPricePerDz() {
		return pricePerDz;
	}

	public void setPricePerDz(double pricePerDz) {
		this.pricePerDz = pricePerDz;
	}
    
   

    
    
}//end class


