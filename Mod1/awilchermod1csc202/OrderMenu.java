package awilchermod1csc202;

import java.text.*;
import java.util.*;

public class OrderMenu {

	private Scanner scan = new Scanner(System.in);

	public void printCustomers(ArrayList<Customer> cust) {
		for (Customer c : cust)
			System.out.println(c.toString());
	}

	public void loadCustomers(ArrayList<Customer> c) {
		// create some fake customers (used for testing the program)
		c.add(new Customer("Duck", "Donald"));
		c.add(new Customer("Mouse", "Minnie"));
		c.add(new Customer("Mouse", "Mickey"));
		c.add(new Customer("Brown", "Charlie"));
	}

	public void loadDesserts(ArrayList<Dessert> d) {
		// d.add(new Candy("Peanut Butter Fudge", 2.25, 3.99));
		d.add(new IceCream("Vanilla Ice Cream", 1.05, 3));
		// d.add(new Sundae("Choc. Chip Ice Cream", 1.45, 3, "Hot Fudge", .50));
		d.add(new IceCream("Strawberry Ice Cream", 1.45, 2));
		// d.add(new Sundae("Vanilla Ice Cream", 1.05, 3, "Caramel", .50));
		// d.add(new Candy("Gummy Worms", 1.33, .89));
		// d.add(new Cookie("Chocolate Chip Cookies", 4, 3.99));
		// d.add(new Candy("Salt Water Taffy", 1.5, 2.09));
		// d.add(new Candy("Candy Corn", 3.0, 1.09));
		// d.add(new Cookie("Oatmeal Raisin Cookies", 4, 3.99));
		d.add(new Cake("Chocolate Cake", 2, 3.99));
		d.add(new Cake("Carrot Cake", 1, 4.99));

	}

	public void printDesserts(ArrayList<Dessert> d) {
		for (int i = 0; i < d.size(); i++) {
			System.out.println(d.get(i).getName());
		}
	}

	public void printClass(ArrayList<Dessert> d) {
		System.out.println("What kind of dessert are you looking for? We have: ");
		System.out.println("\t1. Cake");
		System.out.println("\t2. Candy");
		System.out.println("\t3. Cookies");
		System.out.println("\t4. Ice Cream");
		System.out.println("\t5. Sundae");

		int cl = scan.nextInt();
		String search = null;
		switch (cl) {
		case 1:
			search = "Cake";
			break;
		case 2:
			search = "Candy";
			break;
		case 3:
			search = "Cookies";
			break;
		case 4:
			search = "IceCream";
			break;
		case 5:
			search = "Sundae";
			break;
		default:
			System.out.println("That was an invalid option.");
			break;
		}

		// search for search term
		for (int i = 0; i < d.size(); i++) {
			String type = d.get(i).getClass().toString();
			if (type.contains(search))
				System.out.println(d.get(i).getName());
		}
	}

	public void printPartName(ArrayList<Dessert> d) {
		boolean found = false;

		scan.nextLine();
		// ask for search value
		System.out.println("What are you searching for?");
		String search = scan.nextLine();

		for (int i = 0; i < d.size(); i++) {
			String name = d.get(i).getName();
			if (name.contains(search)) {
				System.out.println(name);
				found = true;
			}
		}
		if (!found) {
			System.out.println("Sorry - we do not have a dessert with that name");
		}
	}

	// use the Comparable to sort by name
	public void sortDessertNames(ArrayList<Dessert> d) {
		Collections.sort(d);
	}

	// use a bubble sort or equivalent to sort by cost

	public void sortDessertCosts(ArrayList<Dessert> d) {
		// loop backward
		for (int out = d.size() - 1; out > 1; out--) {
			// loop forward
			for (int in = 0; in < out; in++) {
				// get 2 desserts to compare
				Dessert first = d.get(in);
				Dessert second = d.get(in + 1);

				// get costs of desserts
				double cost1 = first.getCost();
				double cost2 = second.getCost();

				// compare costs
				if (cost1 > cost2) {
					d.set(in, second);
					d.set(in + 1, first);
				}

			}
		}

	}

	public void createOrder(ArrayList<Customer> cust, ArrayList<Dessert> d, ArrayList<Order> orders) {
		// get customer name for order
		System.out.println("Please select the customer placing the order:");
		printCustomers(cust);
		int c = (scan.nextInt() - 1);

		// get num of dessert(s) ordered
		System.out.println("How many desserts would you like to order?");
		int num = scan.nextInt();

		// get desserts and add to arraylist
		ArrayList<Dessert> des = new ArrayList<Dessert>();
		for (int count = 0; count < num; count++) {
			System.out.println("Please select the dessert being ordered: ");
			printDesserts(d);
			int food = (scan.nextInt() - 1);
			des.add(d.get(food));
		}

		// add to order to arraylist
		Order o = new Order(des, cust.get(c));
		orders.add(o);

	}

	public void printOrders(ArrayList<Order> orders) {
		for (int i = 0; i < orders.size(); i++) {
			System.out.println(orders.get(i).toString());
		}

	}

}
