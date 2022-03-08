package awilcherCSC202Mod4;

import java.util.Scanner;

public class QueueTest {

	public static void main(String[] args) {
		// create queues for planes waiting to take off and to land
		Queue<String> land = new Queue<String>();
		Queue<String> takeoff = new Queue<String>();

		loadQueues(land, takeoff);

		int command = 0;

		while (command != 5) {
			// ask user for menu option
			command = menu();

			// user wants to print queues
			if (command == 1) {
				printQueues(land, takeoff);
			} // user entered takeoff
			else if (command == 2) {
				waitToFly(takeoff);
			} // user entered land
			else if (command == 3) {
				waitToLand(land);
			} // user entered next
			else if (command == 4) {
				advance(takeoff, land);
			} // user entered end
			else if (command == 5) {
				System.out.println("-----Program End-----");
			}
			// user entered some other value
			else {
				System.err.println("\nI'm sorry but" + command + " is not a valid option. Please select again.");
				continue;
			}

		}
		System.exit(0);
	}

	public static void loadQueues(Queue<String> land, Queue<String> takeoff) {
		takeoff.enqueue("AA 123");
		takeoff.enqueue("Delta 877");
		takeoff.enqueue("United 344");
		takeoff.enqueue("AA 98");

		land.enqueue("AA 576");
		land.enqueue("Delta 83");
	}

	public static void printQueues(Queue<String> land, Queue<String> takeoff) {
		// Print planes ready to land
		System.out.println("The following planes are ready to land: ");
		land.print();

		// print planes ready to takeoff
		System.out.println("\nThe following planes are loaded and ready to takeoff: ");
		takeoff.print();

	}

	public static void waitToFly(Queue<String> to) {
		Scanner s = new Scanner(System.in);

		// ask user for flight number
		System.out.println("Please enter the flight number that is ready to takeoff:");
		String flight = s.nextLine();

		// add flight to takeoff queue
		to.enqueue(flight);

		System.out.println("\n" + flight + " is now waiting to takeoff");

	}

	public static void waitToLand(Queue<String> land) {
		Scanner s = new Scanner(System.in);

		// ask user for flight information
		System.out.println("Please enter the flight that would like to land:");
		String flight = s.nextLine();

		// add flight to landing queue
		land.enqueue(flight);

		System.out.println("\n" + flight + " is now waiting to land");
	}

	public static void advance(Queue<String> to, Queue<String> land) {
		String flight;
		// if both queues are empty
		if (land.isEmpty() && to.isEmpty()) {
			System.err.println("There are no flights waiting to take off or land at this time.");

		} // if nothing is waiting to land
		else if (land.isEmpty()) {
			flight = to.dequeue();
			System.out.println("Flight " + flight + " has taken off.");

		} // if there are flights wanting to land
		else {
			flight = land.dequeue();
			System.out.println("Flight " + flight + " has landed.");

		}
	}

	public static int menu() {
		Scanner s = new Scanner(System.in);
		System.out.println("\n Enter a command:");
		System.out.println("1. PRINT - print the queues)");
		System.out.println("2. TAKEOFF flightID - enters the flight ID of the plane into the takeoff queue");
		System.out.println("3. LAND flight ID - enters the flight ID into the pattern for the landing queue");
		System.out.println(
				"4. NEXT - enables the take off or landing, with landing priority. Prints the action that occured.");
		System.out.println("5. END - ends the program");

		return s.nextInt();
	}

}
