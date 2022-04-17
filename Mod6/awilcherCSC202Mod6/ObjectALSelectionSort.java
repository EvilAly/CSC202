package awilcherCSC202Mod6;

//  SelectionSort.java
// Sorting an array with selection sort.
import java.util.*;

public class ObjectALSelectionSort {
	// sort array using selection sort
	public static <T extends Comparable<T>> void selectionSort(List<T> data) {
		// loop over data.length - 1 elements
		for (int i = 0; i < data.size() - 1; i++) {
			int smallest = i; // first index of remaining array

			// loop to find index of smallest element
			for (int index = i + 1; index < data.size(); index++) {
				int comp = data.get(index).compareTo(data.get(smallest));
				if (comp < 0) {
					smallest = index;
				}
			}
			swap(data, i, smallest); // swap smallest element into position
			//printPass(data, i + 1, smallest); // output pass of algorithm
		}
	} // end method selectionSort

	// helper method to swap values in two elements
	private static <T extends Comparable<T>> void swap(List<T> data, int first, int second) {
		T temporary = data.get(first); // store first in temporary
		data.set(first, data.get(second)); // replace first with second
		data.set(second, temporary);// put temporary in second
	}

	public static void main(String[] args) {
		List<String> data = new Stack<String>(); // create array

		 // populate array
		data.add("test");
		data.add("sample");
		data.add("class");
		data.add("exam");

		System.out.printf("Unsorted array:%n%s%n%n", data); // display array
		selectionSort(data); // sort array

		System.out.printf("Sorted array:%n%s%n%n", data); // display array
	}
} // end class SelectionSort
