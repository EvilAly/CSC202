package awilcherCSC202Mod6;

import java.util.*;

public class ObjectALMergeSort {
	// calls recursive split method to begin merge sorting
	public static <T extends Comparable<T>> void mergeSort(List<T> array) {
		sortArray(array, 0, array.size() - 1);
	}

	// splits array, sorts subarrays and merges subarrays into sorted array
	private static <T extends Comparable<T>> void sortArray(List<T> array, int low, int high) {

		// tests for the base case of (arraySize = 1). If not true...
		if ((high - low) >= 1) {

			// 1) calculate middle of array and next element over
			int middle1 = (low + high) / 2;
			int middle2 = middle1 + 1;

			// 3) split array in half; sort first and second halves with recursive calls
			sortArray(array, low, middle1);
			sortArray(array, middle2, high);

			// 4) and then merge two sorted arrays after split calls return
			merge(array, low, middle1, middle2, high);
		}
	} // end method sortArray

	// merge two sorted subarrays into one sorted subarray
	private static <T extends Comparable<T>> void merge(List<T> array, int left, int middle1, int middle2,
			int right) {
		int leftIndex = left; // index into left subarray
		int rightIndex = middle2; // index into right subarray
		int combinedIndex = left; // index into temporary working array

		// create working arraylist with empty elements that can be specifically
		// assigned values
		ArrayList<T> combined = new ArrayList<T>();
		for (int x = 0; x < array.size(); x++) {
			combined.add(null);
		}

		// merge arrays until reaching end of either
		while (leftIndex <= middle1 && rightIndex <= right) {
			// place smaller of two current elements into result and move to next space in
			// arrays
			if (array.get(leftIndex).compareTo(array.get(rightIndex)) <= 0) {
				combined.set(combinedIndex++, array.get(leftIndex++));
				// combined.add(array.get(leftIndex++));
			} else {
				combined.set(combinedIndex++, array.get(rightIndex++));
				// combined.add(array.get(rightIndex++));
			}
		}

		// if left array is empty, copy in rest of right array
		if (leftIndex == middle2) {
			while (rightIndex <= right)
				combined.set(combinedIndex++, array.get(rightIndex++));
			// combined.add(array.get(rightIndex++));
		}

		// else copy in the rest of the left array
		else {
			while (leftIndex <= middle1)
				combined.set(combinedIndex++, array.get(leftIndex++));
			// combined.add(array.get(leftIndex++));
		}

		// then copy values back into original array
		for (int i = left; i <= right; i++)
			array.set(i, combined.get(i));

		// output merged array
		// System.out.printf(" %s%n%n", subarrayString(array, left, right));
	}

	// method to output certain values in array
	
	public static void main(String[] args) {
	
		List<String> data = new Stack<String>(); // create array

		 // populate array
		data.add("test");
		data.add("sample");
		data.add("class");
		data.add("exam");

		System.out.printf("Unsorted array:%n%s%n%n", data); // display array
		mergeSort(data); // sort array

		System.out.printf("Sorted array:%n%s%n%n", data); // display array
	}
} // end class MergeSort
