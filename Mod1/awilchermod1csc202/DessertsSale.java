package awilchermod1csc202;

import java.util.*;

public class DessertsSale {

	public static Scanner scan = new Scanner(System.in);

	// method that runs first
	public static void main(String[] args) throws Exception {
		
		OrderMenu om = new OrderMenu();

		// make an ArrayList of customers and desserts
		ArrayList<Customer> cust = new ArrayList<Customer>();
		// note - the ArrayList below can hold Dessert objects
		// and with inheritance, that includes Cookies, Candy, etc.
		ArrayList<Dessert> yummy = new ArrayList<Dessert>();		
		ArrayList<Order> orders = new ArrayList<Order>();
		
		// add some fake dessert and customer data
		om.loadDesserts(yummy);
		om.loadCustomers(cust);
		
		
		int choice = 0;
		while (choice >= 0) {
			choice = menu();
			if (choice == 1) {
				om.printCustomers(cust);
				System.out.println();
			} else if (choice == 2) {
				om.printDesserts(yummy);
				System.out.println();
			} else if (choice == 3) {
				om.printClass(yummy);
				System.out.println();
			} else if (choice == 4) {
				om.printPartName(yummy);
			} else if (choice == 5) {
				om.sortDessertNames(yummy);
				System.out.println();
			} else if (choice == 6) {
				om.sortDessertCosts(yummy);
				System.out.println();
			} else if (choice ==7) {
				om.createOrder(cust,yummy,orders);
				System.out.println();
			} else if (choice == 8) {
				om.printOrders(orders);
				System.out.println();
			} else if (choice == 9) {
				System.out.println("Bye!!!!!");
				System.exit(0);;
			}
		} // end while

	}

	public static int menu() {
		System.out.println("Choice:");
		System.out.println("   1.  Print all customers (call the toString method)");
		System.out.println("   2.  Print all of the desserts (call the toString method)");
		System.out.println("   3.  Find all of the desserts of a certain class (ex candy)");
		System.out.println("   4.  Find all of the desserts with a partial name ex chocolate or ice cream");
		System.out.println("   5.  Sort the desserts by name");
		System.out.println("   6.  Sort the desserts by cost");
		System.out.println("   7.  Create an order ");
		System.out.println("   8   Print all of the orders");
		System.out.println("   9. QUIT!! ");
		System.out.println("\n CHOICE:");
		int value = scan.nextInt();
		return value;
	}

	

}  //end of program