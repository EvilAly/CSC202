package awilchermod1csc202;

import java.text.*;

public class TestOrder {


	  public static void main(String[] args) {
		  NumberFormat nf = NumberFormat.getCurrencyInstance();
	  
	    Order checkout = new Order();
	    
	    checkout.setCust(new Customer("Smith", "Sara", 25));
	    checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 3.99));
	    checkout.enterItem(new IceCream("Vanilla Ice Cream",1.05,3));
	    checkout.enterItem(new Sundae("Choc. Chip Ice Cream",1.45, 3, "Hot Fudge", .50));
	    checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 3.99));
	    checkout.sortDesserts();
	    
	    System.out.println(checkout.toString());
	    //System.out.println("Number of items: " + checkout.getDesserts().size() );
	    //System.out.println("Total cost: " + nf.format(checkout.totalCost()) );
	    //System.out.println("Total tax: " + nf.format(checkout.totalTax()));
	    //System.out.println("Cost + Tax: " + nf.format((checkout.totalCost() + checkout.totalTax())));
	    

	    
	    checkout.clear();
	    System.out.println();
	    
	    checkout.enterItem(new IceCream("Strawberry Ice Cream",1.45,2));
	    checkout.enterItem(new Sundae("Vanilla Ice Cream",1.05,3, "Caramel", .50));
	    checkout.enterItem(new Candy("Gummy Worms", 1.33, .89));
	    checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 3.99));
	    checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 2.09));
	    checkout.enterItem(new Candy("Candy Corn",3.0, 1.09));
	    checkout.sortDesserts();
	    
	    System.out.println(checkout.toString());
	    //System.out.println("Number of items: " + checkout.getDesserts().size());
	    //System.out.println("Total cost: " + nf.format(checkout.totalCost()));
	    //System.out.println("Total tax: " + nf.format(checkout.totalTax()));
	    //System.out.println("Cost + Tax: " + nf.format((checkout.totalCost() + checkout.totalTax())));

	}

}
