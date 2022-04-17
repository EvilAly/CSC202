package awilcherCSC202Mod6;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.security.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class SearchSortDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		List<Employee> data = new ArrayList<>();
		boolean more = true;
		while (more) {
			menu();
			System.out.println("Choice:");
			int choice = scan.nextInt();

			// load data
			if (choice == 1) {
				prime(data);
			} // employees born in a certain year, alphabetically
			else if (choice == 2) {
				System.out.println("What year are you looking for? ");
				int year = scan.nextInt();
				birthYear(data, year);

			} // print out all employees
			else if (choice == 3) {
				print(data);
			} // Find an employee with certain name and birth year - sequential search
			else if (choice == 4) {
				scan.nextLine();
				// ask for variables
				System.out.println("What is the first name of the employee are you searching for?");
				String name = scan.nextLine();
				System.out.println("What is " + name + "'s four (4) digit birth year?");
				int num = scan.nextInt();
				// start timer
				Instant start = Instant.now();
				// create employee object to pass to search
				Employee emp = new Employee(name, 0, 0, num);

				int loc = ObjectALLinearSearch.linearSearch(data, emp);

				// stop timer
				Instant stop = Instant.now();

				// Print timer results
				Duration timeElapsed = Duration.between(start, stop);
				long millis = timeElapsed.toMillis();
				System.out.println("That took " + millis + " milliseconds");

				// print search results
				if (loc >= 0)
					System.out.println("That employee was found at location " + loc);
				else
					System.out.println("That employee was not found.");
			} // Find an employee with certain name and birth year - non-recursive binary
				// search
			else if (choice == 5) {
				scan.nextLine();
				// ask for variables
				System.out.println("What is the first name of the employee are you searching for?");
				String name = scan.nextLine();
				System.out.println("What is " + name + "'s four (4) digit birth year?");
				int num = scan.nextInt();
				// start timer
				Instant start = Instant.now();
				// create employee object to pass to search
				Employee emp = new Employee(name, 0, 0, num);
				int loc = ObjectALBinarySearch.binarySearch(data, emp);
				
				// stop timer
				Instant stop = Instant.now();

				// Print timer results
				Duration timeElapsed = Duration.between(start, stop);
				long millis = timeElapsed.toMillis();
				System.out.println("That took " + millis + " milliseconds");
				
				if (loc >= 0)
					System.out.println("That employee was found at location " + loc);
				else
					System.out.println("That employee was not found.");
			} // Find an employee with certain name and birth year - recursive binary search
			else if (choice == 6) {
				scan.nextLine();
				// ask for variables
				System.out.println("What is the first name of the employee are you searching for?");
				String name = scan.nextLine();
				System.out.println("What is " + name + "'s four (4) digit birth year?");
				int num = scan.nextInt();
				// start timer
				Instant start = Instant.now();
				// create employee object to pass to search
				Employee emp = new Employee(name, 0, 0, num);
				int loc = ObjectALBinarySearchRecursive.recursiveBinarySearch(data, 0, data.size(), emp);
				
				// stop timer
				Instant stop = Instant.now();

				// Print timer results
				Duration timeElapsed = Duration.between(start, stop);
				long millis = timeElapsed.toMillis();
				System.out.println("That took " + millis + " milliseconds");
				
				if (loc >= 0)
					System.out.println("The value was found at location " + loc);
				else
					System.out.println("That employee was not found.");
			} // Merge Sort by first name and birth year
			else if (choice == 7) {
				Instant start = Instant.now();
				ObjectALMergeSort.mergeSort(data);
				Instant stop = Instant.now();
				Duration timeElapsed = Duration.between(start, stop);
				long millis = timeElapsed.toMillis();
				System.out.println("The merge sort took " + millis + " milliseconds");
			} // Insertion Sort by first name and birth year
			else if (choice == 8) {
				Instant start = Instant.now();
				ObjectALInsertionSort.insertionSort(data);
				Instant stop = Instant.now();
				Duration timeElapsed = Duration.between(start, stop);
				long millis = timeElapsed.toMillis();
				System.out.println("The insertion sort took " + millis + " milliseconds");
			} // Selection Sort by first name and birth year
			else if (choice == 9) {
				Instant start = Instant.now();
				ObjectALSelectionSort.selectionSort(data);
				Instant stop = Instant.now();
				Duration timeElapsed = Duration.between(start, stop);
				long millis = timeElapsed.toMillis();
				System.out.println("The selection sort took " + millis + " milliseconds");

			} // Shuffle data
			else if (choice == 10) {
				Collections.shuffle(data);

			} // exit/end
			else {
				System.out.println("BYE!!");
				System.exit(0);
			}

		}
	}

	public static void birthYear(List<Employee> data, int y) {
		// start timer
		Instant start = Instant.now();

		ArrayList<Employee> results = new ArrayList<Employee>();

		// look at each Employee's birth year
		// add those that match to results ArrayList
		for (Employee emp : data) {
			int birth = emp.getBirthYear();
			if (birth == y) {
				results.add(emp);
			}
		}
		// stop timer & print results
		// timer results
		Instant stop = Instant.now();
		Duration timeElapsed = Duration.between(start, stop);
		long millis = timeElapsed.toMillis();
		System.out.println("That took " + millis + " milliseconds");

		// search result
		if (results.isEmpty()) {
			System.out.println("There are no employees that were born in " + y);
		} else {
			System.out.println("The following employees were born in " + y);
			for (int i = 0; i < results.size(); i++) {
				System.out.println((i + 1) + ".  " + results.get(i).getFirst());
			}
		}

	}

	public static void prime(List<Employee> data) {

		Scanner scan = new Scanner(System.in);
		// get file location
		String filename = FileLoc.pickLocRead();
		File file = new File(filename);
		Scanner inputFile = null;

		try {
			inputFile = new Scanner(file);
			String line = inputFile.nextLine();

			// Read lines from the file until no more are left.
			while (inputFile.hasNext()) {
				// Read the next line.
				line = inputFile.nextLine();

				// Break out each item in the file
				StringTokenizer st = new StringTokenizer(line, ",");
				String firstName = st.nextToken().trim();
				double hours = Double.parseDouble(st.nextToken().trim());
				double payRate = Double.parseDouble(st.nextToken().trim());
				int birthYear = Integer.parseInt(st.nextToken().trim());

				// Create employee and add to data file
				Employee emp = new Employee(firstName, hours, payRate, birthYear);
				data.add(emp);

			}

		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			inputFile.close();

		}

	}

	public static void print(List<Employee> data) {
		for (int i = 0; i < data.size(); i++)
			System.out.println(data.get(i));
	}

	public static void menu() {
		System.out.println("\n1.  Prime the collection with new data from a file");
		System.out.println("2.   Print out all employees born in a given year");
		System.out.println("3.   Print out the collection");
		System.out.println("4.   Do a generic linear search for an item");
		System.out.println("5.   Do a generic non-recursion based binary search for an item");
		System.out.println("      NOTE!! Data must be sorted first before choosing 5");
		System.out.println("6.   Do a generic recursion based binary search for an item");
		System.out.println("      NOTE!! Data must be sorted first before choosing 6");
		System.out.println("7.   Merge sort the collection");
		System.out.println("8.   Insertion sort the collection");
		System.out.println("9.   Selection sort the collection");
		System.out.println("10.  Randomly shuffle the data in the list");
		System.out.println("11.  exit\n");
	}

}
