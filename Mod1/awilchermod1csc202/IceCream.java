
package awilchermod1csc202;

import java.text.DecimalFormat;

public class IceCream extends Dessert {

    //fields
    protected double costPerScoop;
    protected int numScoops;

    //empty constructor
    public IceCream() {

    }

    //full constructor
    public IceCream(String n, double scoop, int num) {
        super(n);
        costPerScoop = scoop;
        numScoops = num;
        getCost();
    }

    //toString method
    public String toString() {

        DecimalFormat df = new DecimalFormat("#.00");
        String ans = super.toString();
        return ans + " -- " + numScoops + " scoops " + " @ " + " $" + df.format(costPerScoop)
                + " per scoop " + "  Cost:" + " " + " $" + df.format(numScoops * costPerScoop);
    } //I didn't call the getCost() method to calculate the cost because it always added the topping from the subclass
    //(just as in your sample output). I wanted to show the cost for the scoops only and in the second line of the
    //output I wanted to have the total (ice-cream plus topping): see my output

    //getCost method
    public double getCost() {
        return numScoops * costPerScoop;
    }

    //getters and setters
    /**
     * @return the costPerScoop
     */
    public double getCostPerScoop() {
        return costPerScoop;
    }

    /**
     * @param costPerScoop the costPerScoop to set
     */
    public void setCostPerScoop(double costPerScoop) {
        this.costPerScoop = costPerScoop;
    }

    /**
     * @return the numScoops
     */
    public int getNumScoops() {
        return numScoops;
    }

    /**
     * @param numScoops the numScoops to set
     */
    public void setNumScoops(int numScoops) {
        this.numScoops = numScoops;
    }

}//end class
