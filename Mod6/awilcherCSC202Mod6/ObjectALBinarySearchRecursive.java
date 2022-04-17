package awilcherCSC202Mod6;

import java.util.*;

public class ObjectALBinarySearchRecursive {
	// perform a binary search on the data

	public static <T extends Comparable<T>> int recursiveBinarySearch(List<T> sortedArray, int start, int end, T key) {

		if (start < end) {
			int mid = start + (end - start) / 2;
			if (sortedArray.get(mid).compareTo(key) > 0) {
				return recursiveBinarySearch(sortedArray, start, mid, key);

			} else if (0 > sortedArray.get(mid).compareTo(key)) {
				return recursiveBinarySearch(sortedArray, mid + 1, end, key);

			} else {
				return mid;
			}
		}
		return -(start + 1);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		List<String> data = new Stack<String>(); // create array

		// populate array
		data.add("test");
		data.add("sample");
		data.add("class");
		data.add("exam");

		data.sort(null);; // binarySearch requires sorted array
		System.out.printf("%s%n%n", data); // display array

		// get input from user
		System.out.print("Please enter the word you're looking for (end to quit): ");
		String searchWord = input.nextLine();

		// repeatedly input an integer; -1 terminates the program
		while (!searchWord.equals("end")) {
			// perform search
			int location = recursiveBinarySearch(data, 0, data.size(), searchWord);

			if (location < 0) // not found
				System.out.println(searchWord + " was not found");
			else // found
				System.out.println(searchWord + " was found in position "+ location);

			// get input from user
			System.out.print("Please enter the word you're looking for (end to quit): ");
			searchWord = input.nextLine();
		}
	} // end main

}