package awilcherCSC202Mod6;

import java.util.*;

public class ObjectALLinearSearch {

	// perform a linear search on the data
	public static <T extends Comparable<T>> int linearSearch(List<T> data, T searchKey) {

		// loop through array sequentially
		for (int index = 0; index < data.size(); index++)
			if (data.get(index).compareTo(searchKey) == 0)

				return index; // return index of integer

		return -1; // integer was not found
	} // end method linearSearch

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<String> data = new Stack<String>(); // create array

		 // populate array
		data.add("test");
		data.add("sample");
		data.add("class");
		data.add("exam");

		System.out.printf("%s%n%n", data); // display array

		// get input from user
		System.out.print("Please enter the word you're looking for (end to quit): ");
		String searchWord = input.nextLine();

		// repeatedly input an integer; -1 terminates the program
		while (!searchWord.equals("end")) {
			int position = linearSearch(data, searchWord); // perform search

			if (position < 0) // not found
				System.out.println(searchWord + " was not found");
			else // found
				System.out.println(searchWord + " was found in position "+ position);

			// get input from user
			System.out.print("Please enter an integer value (end to quit): ");
			searchWord = input.nextLine();
		}
	} // end main
} // end class LinearSearch
